package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	private WebDriver driver;
	private WebDriverWait wait;

	By firstName = By.id("first-name");
	By lastName = By.id("last-name");
	By zipCode = By.id("postal-code");
	By checkOut = By.id("checkout");
	By submit = By.id("continue");
	By finish = By.name("finish");
	By clickOnCart = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
	By successMessage = By.id("checkout_complete_container");


	public CheckoutPage(WebDriver driver, WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait; 
	}
	
	public void navigateToCheckout()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkOut)).click();
	}

	public void enterFirstname(String fName)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
	}

	public void enterLastname(String lName)
	{
		driver.findElement(lastName).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(lName);
	}
	public void enterZipcode(String zip)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode)).sendKeys(zip);
	}
	public void continueOrder()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(submit)).click();
	}
	public void finishButtonClick() {
		driver.findElement(finish).click();
	}
	
	public void navigateToCart() {
		driver.findElement(clickOnCart).click();
	}

	public void completeCheckout(String fName, String lName, String zip) {
		enterFirstname(fName);
		enterLastname(lName);
		enterZipcode(zip);
		continueOrder();
		finishButtonClick();
	}
	public boolean isSuccessMessageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
	}

}
