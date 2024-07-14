package com.fintech.banking_app.service.impl;

import com.fintech.banking_app.dto.AccountDto;
import com.fintech.banking_app.entity.Account;
import com.fintech.banking_app.mapper.AccountMapper;
import com.fintech.banking_app.repository.AccountRepository;
import com.fintech.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

@Service //creates the spring bean for AccountService Impl
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    //generated constructor by ide
    public AccountServiceImpl(AccountRepository accountRepository) { //injects accountRepository dependency
        this.accountRepository = accountRepository;
    }

    @Override
    //the method createAccount calls the AccountRepository to save the account entered into the db
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
