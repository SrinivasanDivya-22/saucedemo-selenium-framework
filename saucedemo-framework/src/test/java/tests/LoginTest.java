package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import graphql.Assert;
import pages.LoginPage;
import utils.configFile;

public class LoginTest extends BaseClass {

	@Test (priority=1,description = "Valid Login Test")
	public void validloginTest() 
	{
		LoginPage loginPage = new LoginPage(driver,wait);
		loginPage.login(configFile.getUsername(),configFile.getPassword());
		Assert.assertTrue(loginPage.isProductsPageDisplayed(),
				 "Login failed: Products page NOT displayed");
		
		System.out.println("Driver hash: " + driver.hashCode());
	}
	
	/*
	 * @Test(priority=1,description = "Invalid Login Test") public void
	 * invalidloginTest() { LoginPage loginPage = new LoginPage(driver,wait);
	 * loginPage.login(configFile.getinvalidUsername(),configFile.getinvalidPassword
	 * ()); Assert.assertTrue(loginPage.isProductsPageDisplayed(),
	 * "Error message NOT displayed for invalid login"); }
	 * 
	 */
}
