package com.fintech.banking_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //created constructor that resolved relation error at AccountMapper class(Account jpa entity to dto method)
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;
}
