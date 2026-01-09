package moneytransferapp;

public class AccountActivityImpl implements AccountActivity {
    
    @Override
    public void withdraw(String accountId, String referenceId, int amount) {
        System.out.println("Withdrawal operation complete.");
    }

    @Override
    public void deposit(String accountId, String referenceId, int amount) {
        System.out.println("Deposit operation complete.");
    }
}

