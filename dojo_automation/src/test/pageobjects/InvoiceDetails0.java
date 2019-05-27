package test.pageobjects;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import support.PageObject;

public class InvoiceDetails0 extends PageObject {

	// Selectors
	By lblInvoiceDetailsHeader = By.xpath("//h2[text() = 'Invoice Details']");
	By lblHotelName = By.xpath("//h4");
	By lblInvoiceDate = By.xpath("//span[contains(text(), 'Invoice Date:')]/..");
	By lblDueDate = By.xpath("//span[contains(text(), 'Due Date:)]/..");
	By lblBookingCode = By.xpath("//td[text() = 'Booking Code']/following-sibling::td");
	By lblRoom = By.xpath("//td[text() = 'Room']/following-sibling::td");
	By lblTotalStayCount = By.xpath("//td[text() = 'Total Stay Count']/following-sibling::td");
	By lblTotalStayAmount = By.xpath("//td[text() = 'Total Stay Amount']/following-sibling::td");
	By lblCheckIn = By.xpath("//td[text() = 'Check-In']/following-sibling::td");
	By lblCheckOut = By.xpath("//td[text() = 'Check-Out']/following-sibling::td");

	public InvoiceDetails0(WebDriver driver) {
		super(driver);
	}

	public void validatePageLoaded() {

		for (String handle : driver.getWindowHandles()) {

			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		new WebDriverWait(driver, defaultTimeOut)
				.until(ExpectedConditions.presenceOfElementLocated(lblInvoiceDetailsHeader));

	}
	
	public void resetWindowContext() {
		driver.switchTo().window(parentHandle);
	}

	public String getHotelName() {
		return driver.findElement(lblHotelName).getText();
	}

	public String getInvoiceDate() {
		return driver.findElement(lblInvoiceDate).getText().replaceAll("Invoice Date: ", "");
	}

	public String getDueDate() {
		return driver.findElement(lblDueDate).getText().replaceAll("Due Date: ", "");
	}

	public String getBookingCode() {
		return driver.findElement(lblBookingCode).getText();
	}

	public String getRoom() {
		return driver.findElement(lblRoom).getText();
	}

	public String getTotalStayCount() {
		return driver.findElement(lblTotalStayCount).getText();
	}

	public String getTotalStayAmount() {
		return driver.findElement(lblTotalStayAmount).getText();
	}

	public String getCheckIn() {
		return driver.findElement(lblTotalStayAmount).getText();
	}

	public String getCheckOut() {
		return driver.findElement(lblCheckOut).getText();
	}

}
