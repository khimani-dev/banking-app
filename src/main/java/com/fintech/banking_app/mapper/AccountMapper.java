package com.fintech.banking_app.mapper;

import com.fintech.banking_app.dto.AccountDto;
import com.fintech.banking_app.entity.Account;

//converts the AccountDto into Account JPA Entity and vice versa
public class AccountMapper {
    //converts accountDto into account
    public static Account mapToAccount(AccountDto accountDto){
        Account account =new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return account;
    }
    //converts Account jpa entity into AccountDto
    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto=new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;
    }
}
