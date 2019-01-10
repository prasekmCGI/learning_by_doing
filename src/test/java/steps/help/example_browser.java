package steps.help;

import cucumber.api.java.en.Given;
import framework.DriverUtil;
import org.openqa.selenium.WebDriver;

public class example_browser {
	
	WebDriver browser;
	
	@Given("^get browser$")
	public void open_new_browser() throws Exception {
		
		// get browser instance (driver)
		browser = DriverUtil.getDriver();		
	}

	@Given("^navigate to url$")
	public void navigate_to_url() throws Exception {
		
		// navigate to specified url
		browser.get("http://google.com");
		
	}
	
}