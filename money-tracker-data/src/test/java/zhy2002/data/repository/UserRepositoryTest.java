package zhy2002.data.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;
import zhy2002.data.AbstractRepositoryTest;
import zhy2002.moneytracker.data.repository.AuthorityRepository;
import zhy2002.moneytracker.data.repository.BudgetRepository;
import zhy2002.moneytracker.data.repository.UserRepository;
import zhy2002.moneytracker.domain.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Test user repository.
 */

public class UserRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    private final static String AUTHORITY_VALUE = "ROLE_USER";

    @Test()
    @Transactional()
    @Rollback(true)
    public void canCreateUser(){

        //arrange
        User user = new User();
        user.setUsername("canCreateUser User");
        user.setPassword("password");

        //act
        User savedUser = userRepository.save(user);

        //assert
        assertThat(savedUser, notNullValue());
        assertThat(savedUser.getId(), greaterThan(0L));
        assertThat(savedUser.getUsername(), equalTo(user.getUsername()));
        assertThat(savedUser.getPassword(), equalTo(user.getPassword()));

        Set<Authority> authorities = user.getAuthorities();
        assertThat(authorities, hasSize(0));
    }

    @Test
    public void authoritiesAreSavedWhenSavingUser(){

        try {
            //arrange
            User user = createTestUserWithAuthority();

            //act
            userRepository.save(user);

            //assert
            User savedUser = userRepository.findOne(user.getId());
            assertThat(savedUser, not(sameInstance(user)));
            assertThat(savedUser.getAuthorities(), hasSize(1));
            savedUser.getAuthorities().forEach(authority -> {
                assertThat(authority.getValue(), equalTo(AUTHORITY_VALUE));
            });
        }finally {
            userRepository.deleteAll();
        }

    }

    @Test
    public void budgetIsSavedWhenSavingUser(){

        try {
            //arrange
            User user = createTestUserWithBudget();

            //act
            userRepository.save(user);

            //assert
            User savedUser = (User)userRepository.findOne(new GetByIdWithEagerFetchBudget(user.getId()));
            assertThat(savedUser, not(sameInstance(user)));
            assertThat(savedUser.getBudget(), notNullValue());
            assertThat(savedUser.getBudget().getAmount(), comparesEqualTo(BigDecimal.TEN));
            assertThat(savedUser.getBudget().getPeriod(), notNullValue());

        }finally {
            userRepository.deleteAll();
        }

    }

    @Test
    public void budgetIsDeletedWhenUserIsDeleted(){

        //precondition
        List<Budget> allBudgets = budgetRepository.findAll();
        assertThat(allBudgets, hasSize(0));

        //arrange
        User user = createTestUserWithBudget();

        try{
            userRepository.save(user);
            allBudgets = budgetRepository.findAll();
            assertThat(allBudgets, hasSize(1));
        }finally {
            //act
            if(user.getId() != null){
                userRepository.delete(user);

                //assert
                allBudgets = budgetRepository.findAll();
                assertThat(allBudgets, hasSize(0));
            }
        }
    }

    @Test
    public void budgetIsDeletedWhenRemoved(){
        User user = createTestUserWithBudget();
        try{
            //arrange
            userRepository.save(user);
            List<Budget> allBudgets = budgetRepository.findAll();
            assertThat(allBudgets, hasSize(1));

            //act
            user.setBudget(null);
            userRepository.save(user);

            //assert
            allBudgets = budgetRepository.findAll();
            assertThat(allBudgets, hasSize(0));

        } finally {
            userRepository.deleteAll();
        }
    }

    @Test
    public void authorityIsDeletedWhenRemoved(){

        List<Authority> authorities = authorityRepository.findAll();
        assertThat(authorities, hasSize(0));
        User user = createTestUserWithAuthority();

        try{
            //arrange
            userRepository.save(user);
            long authorityCount = authorityRepository.count();
            assertThat(authorityCount, equalTo(1L));

            //act
            user.getAuthorities().clear();
            userRepository.save(user);

            //assert
            authorityCount = authorityRepository.count();
            assertThat(authorityCount, equalTo(0L));

        }finally {
            userRepository.deleteAll();
        }
    }

    private User createTestUserWithBudget(){
        User user = new User();
        user.setUsername("Budget User1");
        user.setPassword("Password");
        user.setBudget(new Budget());
        user.getBudget().setAmount(BigDecimal.TEN);
        return user;
    }

    private User createTestUserWithAuthority(){
        User user = new User();
        user.setUsername("User With Authority");
        user.setPassword("password");
        user.getAuthorities().add(new Authority(user, AUTHORITY_VALUE));
        return user;
    }
}

class GetByIdWithEagerFetchBudget implements Specification<User> {

    private Long userId;

    public GetByIdWithEagerFetchBudget(Long userId){
        this.userId = userId;
    }

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        root.fetch(User_.budget).fetch(Budget_.period);
        return criteriaBuilder.equal(root.get(User_.id), userId);
    }
}
