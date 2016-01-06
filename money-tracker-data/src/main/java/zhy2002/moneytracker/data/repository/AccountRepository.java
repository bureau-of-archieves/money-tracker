package zhy2002.moneytracker.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zhy2002.moneytracker.domain.Account;

/**
 * Account repository.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
