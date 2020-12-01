package test.atl.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.atl.atm.service.AccountService;

@Controller
@RequestMapping("/api/account")
public class AccountController {
  @Autowired
  private AccountService accountService;

    @GetMapping("/{number}/withdraw/")
    @Secured("USER")
    public ResponseEntity withdraw(@PathVariable Long number, @Param("value") Double value) throws Exception {
      return accountService.withdraw(number,value);
    }

    @GetMapping("/{number}/balance")
    public ResponseEntity balance(@PathVariable Long number){
      return accountService.balance(number);
    }

}
