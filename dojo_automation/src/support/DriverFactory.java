package support;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

	public static WebDriver getDriver() {

		switch (Settings.getSetting("browser").trim().toUpperCase()) {

		case "CHROME":

			return getChromeDriver();
		default:
			throw new RuntimeException("Browser not supported");

		}

	}

	private static WebDriver getChromeDriver() {

		WebDriver driver;
		ChromeOptions options;

		// Add the property for the chromedriver

		System.setProperty("webdriver.chrome.driver",
				Settings.getSetting("driver_path") + File.separator + "chromedriver.exe");

		// Setup desired capabilities
		options = new ChromeOptions();

		// Avoid something that may block. Password pop-ups
		//options = setCapability("credentials_enable_service", false);
		//options = setCapability("password_manager_enabled", false);

		// Instatiate the driver
		driver = new ChromeDriver(options);

		// Maximize the window
		driver.manage().window().maximize();

		// Return it
		return driver;

	}

}
