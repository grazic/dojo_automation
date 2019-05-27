package test.pageobjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import support.PageObject;

public class Login extends PageObject {
	
	//Selectors
	By btnLogin = By.xpath("//button[@id= 'btnLogin']");
	By txtUsername = By.xpath("//input[@name = 'username']");
	By txtPassword = By.xpath("//input[@name = 'password']");
	By negativeMessage = By.xpath("//div[contains(@class, 'alert-danger')]");
	
	public Login(WebDriver driver) {
		super(driver);
	}

	public void validatePageLoaded() {
		new WebDriverWait(driver, defaultTimeOut).until(ExpectedConditions.presenceOfElementLocated(btnLogin));

	}
	
	public void navigateToLogin() {
		driver.get(support.TestEnvironment.AUTOMATION_SANDBOX_URL);
		
	}

	public void loginIntoPage(String username, String password ) {

		// Fill the username
		driver.findElement(txtUsername).sendKeys(username);
		driver.findElement(txtPassword).sendKeys(password);
		
		// Click on the Login button
		driver.findElement(btnLogin).click();

	}

	public boolean negativeMessageDisplayed() {
		return driver.findElement(negativeMessage).isDisplayed();
		
	}
	
	public String getNegativeMessage() {
		return driver.findElement(negativeMessage).getText();
		
	}

	
}
