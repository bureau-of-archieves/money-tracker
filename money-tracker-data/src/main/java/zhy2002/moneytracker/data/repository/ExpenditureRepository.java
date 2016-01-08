package zhy2002.moneytracker.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import zhy2002.moneytracker.domain.Expenditure;

/**
 * Expenditure repository.
 */
public interface ExpenditureRepository extends JpaRepository<Expenditure, Long>, JpaSpecificationExecutor {

}
