package com.mck.samples.webapp.features.accountbalance;

import com.mck.samples.webapp.mediator.BaseResponse;
import com.mck.samples.webapp.mediator.IAmCommandHandler;
import org.slf4j.MDC;

public class GetAccountBalanceHandler implements IAmCommandHandler<GetAccountBalance, AccountBalance> {
    @Override
    public AccountBalance handle(GetAccountBalance command) {

        return new AccountBalance(MDC.get("requestId"), command.getAccountNumber());
    }
}
