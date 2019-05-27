package support;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Settings {

	public static boolean initialized = false;
	private static Properties properties;
	private static final String CONFIG_PROPERTIES_PATH = "config.properties";

	private static void initialize() {

		// Load the properties file		
		try {
			
			properties = new Properties();
			properties.load(new FileInputStream(CONFIG_PROPERTIES_PATH));
			
			//Set initialized
			initialized = true;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getSetting(String settingName) {

		//Check if it's initialized
		if (!initialized)
			initialize(); 
		
		return properties.getProperty(settingName);
	}

}
