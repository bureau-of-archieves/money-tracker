package zhy2002.moneytracker.business;


import org.springframework.data.jpa.domain.Specification;
import zhy2002.moneytracker.domain.Account;
import zhy2002.moneytracker.domain.Account_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * JPA specs
 */
public class AccountSpecs {

    private AccountSpecs(){}

    public static Specification<Account> hasBudget() {
        return (root, query, builder) -> builder.isNotNull(root.get(Account_.budget));
    }

}
