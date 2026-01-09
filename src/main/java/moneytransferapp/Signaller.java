package moneytransferapp;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

import static moneytransferapp.Shared.WORKFLOW_ID;

public class Signaller {

    public static void main(String[] args) throws Exception {
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);

        MoneyTransferWorkflow workflow = client.newWorkflowStub(MoneyTransferWorkflow.class, WORKFLOW_ID);
        workflow.approve(true);

        System.exit(0);
    }
}