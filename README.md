# Money transfer project: Java

## Step 1: Start the Temporal Service

```
temporal server start-dev
```

## Step 2: Run the Worker

Open another terminal window and run the following command to run
the Worker:

```
./run-worker.sh
```

## Step 3: Start the Workflow

Open another terminal window and run the following command to start
the Workflow:

```
./transfer.sh
```

The Workflow Execution should begin, but pause as it awaits approval
to continue that is delivered through a Signal. You can view its
status and details with the Temporal Web UI, which you can access
at <http://localhost:8233>.

You can use the Web UI to signal the Workflow Execution (in which
case you'll choose `approve` from the **Signal name** dropdown and
enter `true` in the **Data** field). 

Alternatively, you can send a Signal from code:

```
./signal.sh
```

Or from the CLI:

```
temporal workflow signal --workflow-id money-transfer-testrun \
    --name approve --input '"true"'
```


