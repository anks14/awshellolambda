package handler;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class TestContext implements Context {

    public void setAwsRequestId(String awsRequestId) {
        this.awsRequestId = awsRequestId;
    }

    public void setClientContext(ClientContext clientContext) {
        this.clientContext = clientContext;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public void setIdentity(CognitoIdentity identity) {
        this.identity = identity;
    }

    public void setLogGroupName(String logGroupName) {
        this.logGroupName = logGroupName;
    }

    public void setLogStreamName(String logStreamName) {
        this.logStreamName = logStreamName;
    }

    public void setLogger(LambdaLogger logger) {
        this.logger = logger;
    }

    public void setMemoryLimitInMB(int memoryLimitInMB) {
        this.memoryLimitInMB = memoryLimitInMB;
    }

    public void setRemainingTimeInMillis(int remainingTimeInMillis) {
        this.remainingTimeInMillis = remainingTimeInMillis;
    }

    private String awsRequestId = "EXAMPLE";
    private ClientContext clientContext;
    private String functionName = "HELLO";
    private CognitoIdentity identity;
    private String logGroupName = "EXAMPLE";
    private String logStreamName = "EXAMPLE";
    private LambdaLogger logger = new TestLogger();
    private int memoryLimitInMB = 128;
    private int remainingTimeInMillis = 15000;



    @Override
    public String getAwsRequestId() {
        return awsRequestId;
    }

    @Override
    public String getLogGroupName() {
        return logGroupName;
    }

    @Override
    public String getLogStreamName() {
        return logStreamName;
    }

    @Override
    public String getFunctionName() {
        return functionName;
    }

    @Override
    public String getFunctionVersion() {
        return "1.0";
    }

    @Override
    public String getInvokedFunctionArn() {
        return null;
    }

    @Override
    public CognitoIdentity getIdentity() {
        return identity;
    }

    @Override
    public ClientContext getClientContext() {
        return clientContext;
    }

    @Override
    public int getRemainingTimeInMillis() {
        return remainingTimeInMillis;
    }

    @Override
    public int getMemoryLimitInMB() {
        return memoryLimitInMB;
    }

    @Override
    public LambdaLogger getLogger() {
        return logger;
    }

    private class TestLogger implements LambdaLogger {
        @Override
        public void log(String message) {
            System.err.println(message);
        }
    }
}
