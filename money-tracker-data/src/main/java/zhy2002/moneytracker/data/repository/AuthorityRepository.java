package zhy2002.moneytracker.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import zhy2002.moneytracker.domain.Authority;

/**
 * Repository for Authority domain object.
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long>, JpaSpecificationExecutor<Authority> {

}
