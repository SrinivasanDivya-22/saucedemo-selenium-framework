package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import graphql.Assert;
import pages.CheckoutPage;
import utils.configFile;

public class CheckoutTest extends BaseClass {

	@Test(priority=3,description = "Checkout")
	public void checkoutTest() 
	{
		CheckoutPage checkoutPage = new CheckoutPage(driver, wait);
		checkoutPage.navigateToCart();
		checkoutPage.navigateToCheckout();
		checkoutPage.enterFirstname(configFile.getFirstName());
		checkoutPage.enterLastname(configFile.getLastName());
		checkoutPage.enterZipcode(configFile.getPostalCode());
		checkoutPage.continueOrder();
		checkoutPage.finishButtonClick();
		Assert.assertTrue(checkoutPage.isSuccessMessageDisplayed(),"Error, order was not places successully");
		System.out.println("Driver hash: " + driver.hashCode());
	}

}
