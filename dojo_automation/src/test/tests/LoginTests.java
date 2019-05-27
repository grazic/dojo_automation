package test.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import support.DriverFactory;
import test.pageobjects.InvoiceList;
import test.pageobjects.Login;

public class LoginTests {

	@Test(description = "001 - Login into application - Positive")
	public void loginPositiveTest() {

		String username, password;

		// Get driver
		WebDriver driver = DriverFactory.getDriver();

		// Instantiate the pages
		Login pLogin = new Login(driver);
		InvoiceList pInvoiceList = new InvoiceList(driver);

		// Data setup
		username = "demouser";
		password = "abc123";

		// 1. Navigate do login page
		pLogin.navigateToLogin();

		// 2. Login into page
		pLogin.loginIntoPage(username, password);

		// 3. Validate invoice list is displayed
		pInvoiceList.validatePageLoaded();
	}

	@Test(description = "002 - Login into application - Negative", dataProvider = "giveBadCredentials")
	public void loginNegativeTest(String username, String password) {

		String negativeMessage = "Wrong username or password.".trim().toUpperCase();

		// Get driver
		WebDriver driver = DriverFactory.getDriver();

		// Instantiate the pages
		Login pLogin = new Login(driver);
		
		// 1. Navigate do login page
		pLogin.navigateToLogin();

		// 2. Login into page
		pLogin.loginIntoPage(username, password);

		// 3. Validate error message is displayed
		assert (pLogin.negativeMessageDisplayed());

		// 4. Validate error message is correct
		assertEquals(pLogin.getNegativeMessage().trim().toUpperCase(), negativeMessage.trim().toUpperCase());

	}

	@DataProvider
	public Object[][] giveBadCredentials() {
		return new Object[][] {

				new Object[] { "Demouser", "abc123" }, new Object[] { "demouser_", "xyz" },
				new Object[] { "demouser", "nanana" }, new Object[] { "demouser", "abc123" }

		};

	}

}
