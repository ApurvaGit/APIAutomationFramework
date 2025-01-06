package com.api.listners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListner implements ITestListener {
    private static final Logger logger = LogManager.getLogger(ITestListener.class);

    public void onStart(ITestListener context){
        logger.info("Test suite started!");
    }
    public void onTestStart(ITestResult result){
        logger.info("Started!!"+result.getMethod().getMethodName());
        logger.info("Description!!"+result.getMethod().getDescription());
    }
    public void onTestSuccess(ITestResult result){
        logger.info("Passed!!"+result.getMethod().getMethodName());
    }
    public void onTestFailure(ITestResult result){
        logger.error("Failed!!"+result.getMethod().getMethodName());
    }
    public void onTestSkipped(ITestResult result){
        logger.info("Skipped!!"+result.getMethod().getMethodName());
    }
    public void onTestFinish(ITestListener context){
        logger.info("Test suite completed!");
    }
}