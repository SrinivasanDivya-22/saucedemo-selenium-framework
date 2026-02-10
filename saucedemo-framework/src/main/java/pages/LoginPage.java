package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;

	// Locators
	private By userName = By.id("user-name");
	private By password = By.id("password");
	private By loginBtn = By.id("login-button");
	private By productsLogo = By.className("app_logo");

	public LoginPage(WebDriver driver, WebDriverWait wait)
	{	
		this.driver = driver;
		this.wait = wait;
	}

	//Actions

	public void enterUsername(String uname)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(userName)).sendKeys(uname);
	}

	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}

	public void login(String uname, String pwd) {
		enterUsername(uname);
		enterPassword(pwd);
		clickLogin();
	}

	public boolean isProductsPageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(productsLogo)).isDisplayed();
	}
}
