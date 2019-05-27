package test.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import support.DriverFactory;
import test.pageobjects.InvoiceDetails0;
import test.pageobjects.InvoiceList;
import test.pageobjects.Login;

public class InvoiceTests {

	@Test(description = "001 - Validate invoice information")
	public void loginPositiveTest() {
		
		SoftAssert aAssert;
		String username, password;
		
		//Get driver
		WebDriver driver = DriverFactory.getDriver();

		// Instantiate the pages
		Login pLogin = new Login(driver);
		InvoiceList pInvoiceList = new InvoiceList(driver);
		InvoiceDetails0 pInvoiceDetails0 = new InvoiceDetails0(driver);

		// Data setup
		username = "demouser";
		password = "abc123";

		// 1. Navigate do login page
		pLogin.navigateToLogin();

		// 2. Login into page
		pLogin.loginIntoPage(username, password);

		// 3. Validate invoice list is displayed
		pInvoiceList.validatePageLoaded();
		
		//4. Click on the first link
		pInvoiceList.doClickOn0List(1);
		
		//5. Validate Invoice details
		pInvoiceDetails0.validatePageLoaded();
		
		//6. Validate information
		aAssert = new SoftAssert();
		aAssert.assertEquals("0875".trim().toUpperCase(), pInvoiceDetails0.getBookingCode().trim().toUpperCase());
		aAssert.assertEquals("14/01/2018".trim().toUpperCase(), pInvoiceDetails0.getCheckIn().trim().toUpperCase());
		aAssert.assertEquals("15/01/2018".trim().toUpperCase(), pInvoiceDetails0.getCheckOut().trim().toUpperCase());
		aAssert.assertEquals("15/01/2018".trim().toUpperCase(),pInvoiceDetails0.getDueDate().trim().toUpperCase());
		aAssert.assertEquals("Rendezvous Hotel".trim().toUpperCase(),pInvoiceDetails0.getHotelName().trim().toUpperCase());
		aAssert.assertEquals("14/01/2018".trim().toUpperCase(), pInvoiceDetails0.getInvoiceDate().trim().toUpperCase());
		aAssert.assertEquals("Superior Double".trim().toUpperCase(), pInvoiceDetails0.getRoom().trim().toUpperCase());
		aAssert.assertEquals("$150", pInvoiceDetails0.getTotalStayAmount());
		aAssert.assertEquals("1".trim().toUpperCase(), pInvoiceDetails0.getTotalStayCount().trim().toUpperCase());
		
		//Run the assert
		aAssert.assertAll();
	}
	
}
