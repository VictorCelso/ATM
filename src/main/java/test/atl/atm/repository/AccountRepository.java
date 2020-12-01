package test.atl.atm.repository;

import org.springframework.data.repository.CrudRepository;
import test.atl.atm.model.Account;

public interface AccountRepository extends CrudRepository<Account,Long> {
}
