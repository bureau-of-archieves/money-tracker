package zhy2002.data.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;
import zhy2002.data.AbstractRepositoryTest;
import zhy2002.moneytracker.data.repository.UserRepository;
import zhy2002.moneytracker.domain.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Test user repository.
 */

public class UserRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private UserRepository userRepository;

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
    public void authoritiesIsSavedWhenSavingUser(){

        try {
            //arrange
            final String AUTHORITY_VALUE = "ROLE_USER";
            User user = new User();
            user.setUsername("User With Authority");
            user.setPassword("password");
            user.getAuthorities().add(new Authority(user, AUTHORITY_VALUE));

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
            User user = new User();
            user.setUsername("Budget User");
            user.setPassword("password");
            user.setBudget(new Budget());
            user.getBudget().setAmount(BigDecimal.TEN);

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
