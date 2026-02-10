package listeners;

import com.aventstack.extentreports.*;

import base.BaseClass;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

import util.ExtentManager;
import util.ScreenshotUtil;

public class ExtentListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	Object testClass = result.getInstance();
        WebDriver driver = ((BaseClass) testClass).driver;

        String path = ScreenshotUtil.capture(driver, result.getName());

        test.get().fail(result.getThrowable());
        test.get().addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
    
}