package test.pageobjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.PageObject;


public class InvoiceList extends PageObject {

	// Selectors
	By invoiceHeader = By.xpath("//h2[text() = 'Invoice List']");
	String invoiceDetailsLink1 = "(//a[text= 'Invoice Details'])[?]";

	public InvoiceList(WebDriver driver) {
		super(driver);
	 }

	public void validatePageLoaded() {
		new WebDriverWait(driver, defaultTimeOut).until(ExpectedConditions.presenceOfElementLocated(invoiceHeader));

	}

	public void doClickOn0List(int invoiceNumber) {
		
		By selector;
		
		//Set the number/index of the invoice
		selector = By.xpath(invoiceDetailsLink1.replaceAll("\\?", String.valueOf(invoiceNumber)));
		
		//Click on the link
		
		driver.findElement(selector).click();

	}

}
