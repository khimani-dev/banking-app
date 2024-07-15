package com.fintech.banking_app.service.impl;

import com.fintech.banking_app.dto.AccountDto;
import com.fintech.banking_app.entity.Account;
import com.fintech.banking_app.mapper.AccountMapper;
import com.fintech.banking_app.repository.AccountRepository;
import com.fintech.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service //creates the spring bean for AccountService Impl
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    //generated constructor by ide
    public AccountServiceImpl(AccountRepository accountRepository) { //injects accountRepository dependency
        this.accountRepository = accountRepository;
    }

    //Add account REST Api
    //Method createAccount calls the AccountRepository to save the account entered into the db
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    //GET ACCOUNT REST API
    @Override
    public AccountDto getAccountById(Long Id) {
       Account account = accountRepository
               .findById(Id)
               .orElseThrow(()-> new RuntimeException("The account does not exist"));
    return AccountMapper.mapToAccountDto(account);
    }

    //Method for depositing money into the account
    @Override
    public AccountDto deposit(Long id, double amount) {
            //below 3 lines block checks whether the account exists in the db
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("The account does not exist"));

        double total=account.getBalance() + amount;  //adds the existing balance to the added amount
        account.setBalance(total);
       Account savedAccount= accountRepository.save(account);  //saves the new amount into the db

        return AccountMapper.mapToAccountDto(savedAccount); //converts accountJPA Entity into accountDTO
    }
}
