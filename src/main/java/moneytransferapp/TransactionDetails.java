package moneytransferapp;

public class TransactionDetails {

    private String sourceAccountId;
    private String destinationAccountId;
    private String transactionReferenceId;
    private int amountToTransfer;

    public TransactionDetails() {
    }

    public TransactionDetails(String sourceAccountId,
                              String destinationAccountId,
                              String transactionReferenceId,
                              int amountToTransfer) {
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
        this.transactionReferenceId = transactionReferenceId;
        this.amountToTransfer = amountToTransfer;
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public String getDestinationAccountId() {
        return destinationAccountId;
    }

    public String getTransactionReferenceId() {
        return transactionReferenceId;
    }

    public int getAmountToTransfer() {
        return amountToTransfer;
    }
}