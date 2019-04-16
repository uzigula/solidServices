package com.mck.samples.webapp.features.accountbalance;

import lombok.Getter;

@Getter
public class AccountBalance   {

    private final String accountNumber;
    private final String requestId;


    public AccountBalance(String requestId, String accountNumber) {

        this.requestId = requestId;
        this.accountNumber = accountNumber;
    }
}
