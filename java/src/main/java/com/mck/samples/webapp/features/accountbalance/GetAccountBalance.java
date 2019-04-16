package com.mck.samples.webapp.features.accountbalance;

import com.mck.samples.webapp.mediator.BaseResponse;
import com.mck.samples.webapp.mediator.IAmCommand;
import lombok.Getter;

@Getter
public class GetAccountBalance implements IAmCommand<AccountBalance> {
    private final String accountNumber;

    public GetAccountBalance(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
