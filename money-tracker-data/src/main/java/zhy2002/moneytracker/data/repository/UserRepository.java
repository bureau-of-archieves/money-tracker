package zhy2002.moneytracker.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import zhy2002.moneytracker.domain.User;

/**
 * User repository.
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor {

}
