package com.fintech.banking_app.controller;


import com.fintech.banking_app.dto.AccountDto;
import com.fintech.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    //accountService dependency injection using the generated constructor on the ide
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add REST API(calls accountService.createAccount which returns the saved account from the Dto)
   @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //GET ACCOUNT REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById( @PathVariable Long id){
        AccountDto accountDto= accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    //DEPOSIT REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit ( @PathVariable Long id, //@PathVariable binds the id template on put-mapping url to Long id
                                               @RequestBody Map< String,Double> request){
        double amount=request.get("amount");
         AccountDto accountDto=accountService.deposit(id,amount);
         return ResponseEntity.ok(accountDto);
    }
}
