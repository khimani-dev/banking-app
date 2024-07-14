package com.fintech.banking_app.controller;


import com.fintech.banking_app.dto.AccountDto;
import com.fintech.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
