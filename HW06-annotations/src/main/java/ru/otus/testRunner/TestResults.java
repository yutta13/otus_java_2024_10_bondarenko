package ru.otus.testRunner;

import static ru.otus.test.Tests.logger;

import java.util.ArrayList;
import java.util.List;

public class TestResults {
    private static int totalTests;
    private static int passedTests;
    private static int failedTests;
    private static final List<String> failedTestDetails = new ArrayList<>();

    public void addTestResult(boolean isSuccess, String testName, Throwable error) {
        totalTests++;
        if (isSuccess) {
            passedTests++;
        } else {
            failedTests++;
            failedTestDetails.add(testName + ": " + (error != null ? error.getMessage() : "Unknown error"));
        }
    }

    public void logTestResults() {
        logger.atInfo()
                .setMessage("\n*****************************************************\n"
                        + "Total number of tests: {}. Passed : {}. Failed : {}\n"
                        + "*****************************************************\n")
                .addArgument(getTotalTests())
                .addArgument(getPassedTests())
                .addArgument(getFailedTests())
                .log();
        if (getFailedTests() > 0) {
            logger.atInfo().setMessage("Failed test details:").log();
            for (String detail : getFailedTestDetails()) {
                logger.atWarn().setMessage(" - " + detail).log();
            }
        }
    }

    public static int getTotalTests() {
        return totalTests;
    }

    public static int getPassedTests() {
        return passedTests;
    }

    public static int getFailedTests() {
        return failedTests;
    }

    public static List<String> getFailedTestDetails() {
        return failedTestDetails;
    }
}
