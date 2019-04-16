package com.mck.samples.webapp.features.accountbalance;


import com.mck.samples.webapp.crosscuttingconcerns.LogDecoratorHandler;
import com.mck.samples.webapp.mediator.BaseResponse;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/accounts/")
public class AccountBalanceRestResource {

    @RequestMapping(value = "/balance/{accountNumber}", method = RequestMethod.GET, produces = "application/json")
    public BaseResponse<AccountBalance> getBalance(@PathVariable("accountNumber") String accountNumber){

        AccountBalance response = new LogDecoratorHandler<>(new GetAccountBalanceHandler()).handle(new GetAccountBalance(accountNumber));

        return new BaseResponse<>(response);

    }

    @RequestMapping(value = "/seed/{seed}", method = RequestMethod.GET, produces = "application/json")
    public BaseResponse<AccountSeed> getBalance(@PathVariable("seed") int seed){

        AccountSeed response= new LogDecoratorHandler<>(new GetAccountSeedHandler()).handle(new GetAccountSeed(seed));
        return new BaseResponse<>(response);

    }
}
