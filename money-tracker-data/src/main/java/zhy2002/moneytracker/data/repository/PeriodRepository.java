package zhy2002.moneytracker.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import zhy2002.moneytracker.domain.Period;

/**
 * Repository for period domain object.
 */
public interface PeriodRepository extends JpaRepository<Period, Long>, JpaSpecificationExecutor<Period>{
}
