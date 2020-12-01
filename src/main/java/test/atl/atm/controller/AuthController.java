package test.atl.atm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/login")
public class AuthController {
  @GetMapping()
  public ResponseEntity login(){

    return ResponseEntity.ok("ok");
  }
}
