package core;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by YaskoYA on 27.07.2015.
 */
public class Retry implements IRetryAnalyzer {

    private int retryCount = 1;
    private int maxRetryCount = 1;// Количество раз прохода теста

    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}