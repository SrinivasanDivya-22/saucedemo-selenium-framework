package base;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public static WebDriver driver;
	protected static WebDriverWait wait;

	@BeforeSuite
	public void setUp()
	{

		ChromeOptions options = new ChromeOptions();
		
		
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		prefs.put("credentials_enable_service", false);

		options.setExperimentalOption("prefs", prefs);
		
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));


		options.addArguments("--incognito");

		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--no-first-run");
		options.addArguments("--no-default-browser-check");
		options.addArguments("--user-data-dir=" 
				+ System.getProperty("java.io.tmpdir") 
				+ "/chrome-profile-" 
				+ System.currentTimeMillis());

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();


		driver.get("https://www.saucedemo.com/");
	}

	@AfterSuite
	public void tearDown() 
	{
		if (driver != null) {
			driver.quit();
		}
	}
	@AfterMethod
	public void captureFailure(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			System.out.println("❌ TEST FAILED: " + result.getName());
		}
	}
}
