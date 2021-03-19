package repository;

import model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author egor.oparin@x5.ru
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
