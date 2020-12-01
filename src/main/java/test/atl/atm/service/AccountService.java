package test.atl.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import test.atl.atm.model.Account;
import test.atl.atm.repository.AccountRepository;
import test.atl.atm.util.BillCounterUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AccountService {
  @Autowired
  private AccountRepository accountRepository;

  public ResponseEntity withdraw(Long number,Double value) throws Exception {
    Optional<Account> account = accountRepository.findById(number);
    if(account.isEmpty()){
      return ResponseEntity.noContent()
        .eTag("Account number not found").build();
    }
    Double balance = account.map(Account::getBalance).orElse(0.0);
    balance -=value;
    if(balance<0){
      return ResponseEntity.badRequest()
        .eTag("Account balance is 0.").build();
    }
    account.get().setBalance(balance);
    accountRepository.save(account.get());
    return ResponseEntity.ok(BillCounterUtil.returnBills(value));
  }

  public ResponseEntity balance(Long number){
    Double balance = accountRepository.findById(number)
      .map(Account::getBalance).orElse(0.0);
    if(balance==0){
      return ResponseEntity.noContent()
        .eTag("Account number not found, or empty balance.").build();
    }
    return ResponseEntity.ok(balance);
  }

}
