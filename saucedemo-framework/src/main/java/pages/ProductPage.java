package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	private WebDriver driver;
    private WebDriverWait wait;

    private By backpackAddBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By bikeLightAddBtn = By.id("add-to-cart-sauce-labs-bike-light");
    private By cartIcon = By.className("shopping_cart_link");

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void addBackpackToCart() {
        driver.findElement(backpackAddBtn).click();
    }

    public void addBikeLightToCart() {
        driver.findElement(bikeLightAddBtn).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}
