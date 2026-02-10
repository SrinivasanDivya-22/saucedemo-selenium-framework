package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	private WebDriver driver;
    private WebDriverWait wait;
    
    By removeItem = By.id("remove-sauce-labs-backpack");
    By checkOut = By.id("checkout");
    
    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

	public void removeItemFromCart()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(removeItem)).click();
	}
	
	public void checkOut()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkOut)).click();
	}
	
}
