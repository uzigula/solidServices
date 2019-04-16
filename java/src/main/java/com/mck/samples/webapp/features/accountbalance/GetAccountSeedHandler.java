package com.mck.samples.webapp.features.accountbalance;

import com.mck.samples.webapp.infrastructure.RequestIdGenerator;
import com.mck.samples.webapp.mediator.BaseResponse;
import com.mck.samples.webapp.mediator.IAmCommandHandler;

public class GetAccountSeedHandler implements IAmCommandHandler<GetAccountSeed, BaseResponse<AccountSeed>> {
    @Override
    public BaseResponse<AccountSeed> handle(GetAccountSeed command) {

        return new BaseResponse(new AccountSeed(RequestIdGenerator.getInstance(command.getSeed()).getId()));

    }
}
