package moneytransferapp;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface AccountActivity {

    @ActivityMethod
    void withdraw(String accountId, String referenceId, int amount);

    @ActivityMethod
    void deposit(String accountId, String referenceId, int amount);
}