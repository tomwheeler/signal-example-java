package moneytransferapp;

import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface MoneyTransferWorkflow {

    @WorkflowMethod
    String transfer(TransactionDetails transaction);

    @SignalMethod
    void approve(boolean isApproved);
}