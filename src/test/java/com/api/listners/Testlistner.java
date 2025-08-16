package com.api.listners;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.event.ItemListener;

public class Testlistner implements ITestListener {

    private static final Logger logger = LogManager.getLogger(Testlistner.class);

    public void onStart(ITestContext context) {
        logger.info("Test Suite Started !!!");
    }

    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed !!!");

    }
    public void onTestStart(ITestResult result) {
        logger.info("Test Started !!!");
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Passed!!!!" +result.getMethod().getMethodName());
        logger.info("Description!!" + result.getMethod().getDescription());


    }

    public void onTestFailure(ITestResult result) {
        logger.error("Failed!!!!" +result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
        logger.info("skipped!!!!" +result.getMethod().getMethodName());

    }
}
