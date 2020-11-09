package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private static final int RETRY_LIMIT = 3;
    private int counter = 0;

    @Override
    public boolean retry(ITestResult result) {
        if(counter < RETRY_LIMIT) {
            counter++;
            return true;
        }
        return false;
    }
}
