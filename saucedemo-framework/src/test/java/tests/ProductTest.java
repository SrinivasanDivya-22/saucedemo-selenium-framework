package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.ProductPage;

public class ProductTest extends BaseClass {

	@Test(priority=2,description = "Add Two Products To Cart")
	public void addTwoProductsToCart() {
		ProductPage productPage = new ProductPage(driver, wait);

		productPage.addBackpackToCart();
		productPage.addBikeLightToCart();
		productPage.goToCart();
		
		System.out.println("Driver hash: " + driver.hashCode());
	}
}
