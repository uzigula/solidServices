package com.mck.samples.webapp.features.accountbalance;

import com.mck.samples.webapp.infrastructure.RequestIdGenerator;
import com.mck.samples.webapp.mediator.BaseResponse;
import com.mck.samples.webapp.mediator.IAmCommandHandler;

public class GetAccountSeedHandler implements IAmCommandHandler<GetAccountSeed, AccountSeed> {
    @Override
    public AccountSeed handle(GetAccountSeed command) {

        return new AccountSeed(RequestIdGenerator.getInstance(command.getSeed()).getId());

    }
}
