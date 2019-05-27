package support;

import org.openqa.selenium.WebDriver;

public abstract class PageObject {

	// Selenium driver
	public WebDriver driver;
	
	//Default timeout
	public static int defaultTimeOut = 60;
	
	//Store the window
	public String parentHandle;

	// Copy the driver to class
	public PageObject(WebDriver driver) {
		
		//Copy driver to class
		this.driver = driver;
		
		//Get the window
		this.parentHandle = driver.getWindowHandle();
		
	}

	public abstract void validatePageLoaded();

}
