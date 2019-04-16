package com.mck.samples.webapp.features.accountbalance;

import com.mck.samples.webapp.mediator.BaseResponse;
import com.mck.samples.webapp.mediator.IAmCommand;
import lombok.Getter;

@Getter
public class GetAccountSeed implements IAmCommand<BaseResponse<AccountSeed>> {
    private final int seed;

    public GetAccountSeed(int seed) {
        this.seed = seed;
    }
}
