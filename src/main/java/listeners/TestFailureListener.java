package listeners;

import base.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverFactory;
import utils.ScreenshotUtils;

public class TestFailureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        Object testClass = result.getInstance();

        if (testClass instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) testClass;

            ScreenshotUtils.captureScreenshot(
                    DriverFactory.getDriver(),
                    result.getMethod().getMethodName()
            );
        }
    }
}