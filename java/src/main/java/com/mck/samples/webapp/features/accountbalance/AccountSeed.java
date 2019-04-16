package com.mck.samples.webapp.features.accountbalance;

import lombok.Getter;

@Getter
public class AccountSeed {
    private final long requestId;

    public AccountSeed(long requestId) {
        this.requestId = requestId;
    }
}
