package listeners;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseClass;

public class TestListeners implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
 
        WebDriver driver = BaseClass.driver;

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String testName = result.getName();

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/" + testName + "_" + timestamp + ".png");

        dest.getParentFile().mkdirs();

        try {
            Files.copy(src.toPath(), dest.toPath());
            System.out.println("📸 Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}