package com.fintech.banking_app.service;

import com.fintech.banking_app.dto.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long Id);

    AccountDto deposit(Long id,double amount);
}
