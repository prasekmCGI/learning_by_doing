package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DriverUtil {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		return driver;
	}
	
	public static WebDriver initDriver() {
		
		// turning off the logger from selenium.remote
		Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
		
		// setting the chromedriver to the path
		String pathToChromedriverFile = System.getProperty("user.dir") + "/src/test/java/binaries/chromedriver.exe";
				
		// start new browser session
		System.setProperty("webdriver.chrome.driver", pathToChromedriverFile);
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("incognito");
		driver = new ChromeDriver(chromeOptions);
		
		return driver;
	}
	
	public static void closeDriver() {
		
		driver.close();
	}
		
}