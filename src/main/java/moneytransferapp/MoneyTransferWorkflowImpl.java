package moneytransferapp;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class MoneyTransferWorkflowImpl implements MoneyTransferWorkflow {

    private boolean wasTransferApproved = false;

    private final ActivityOptions options = ActivityOptions.newBuilder()
        .setStartToCloseTimeout(Duration.ofSeconds(2))
        .build();

    private final AccountActivity accountActivityStub = Workflow.newActivityStub(AccountActivity.class, options);

    @Override
    public String transfer(TransactionDetails transaction) {
        String sourceAccountId = transaction.getSourceAccountId();
        String destinationAccountId = transaction.getDestinationAccountId();
        String transactionReferenceId = transaction.getTransactionReferenceId();
        int amountToTransfer = transaction.getAmountToTransfer();

        // await approval (via Signal) before continuing
        System.out.println("Send 'approve' signal with a 'true' value to continue execution");
        Workflow.await(() -> wasTransferApproved);

        accountActivityStub.withdraw(sourceAccountId, transactionReferenceId, amountToTransfer);
        accountActivityStub.deposit(destinationAccountId, transactionReferenceId, amountToTransfer);

        return "TX123456789";
    }

    @Override
    public void approve(boolean isApproved) {
        System.out.println("Received 'approve' signal with value=" + isApproved);
        this.wasTransferApproved = isApproved;
    }
}