package zhy2002.moneytracker.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import zhy2002.moneytracker.domain.Budget;

/**
 * JPA repository for budget domain object.
 */
public interface BudgetRepository extends JpaRepository<Budget, Long>, JpaSpecificationExecutor<Budget> {
}
