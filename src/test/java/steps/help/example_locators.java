package steps.help;

import cucumber.api.java.en.Given;
import framework.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class example_locators {
	
	WebDriver browser;
	
	public void highlightElement(WebElement elem) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) browser;
		
		for(int i=0; i < 3; i++) {
			
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 5px solid red;');", elem);
			Thread.sleep(300);
			js.executeScript("arguments[0].setAttribute('style', 'background: none; border: none;');", elem);
			Thread.sleep(300);
		}
		
	}
	
	@Given("^browser is opened with timesheet login page$")
	public void open_new_browser() throws Exception {
		
		browser = DriverUtil.getDriver();
		browser.get("https://psa-fs.ent.cgi.com/psc/fsprda/EMPLOYEE/ERP/c/NUI_FRAMEWORK.PT_LANDINGPAGE.GBL?");
		
	}
	
	@Given("^element located by id is highlighted$")
	public void element_located_by_id_is_highlighted() throws Exception {
		
		// locate by id: input username
		WebElement element = browser.findElement(By.id("userid"));
		
		// highlight
		highlightElement(element);
	}
		
	@Given("^element located by name is highlighted$")
	public void element_located_by_name_is_highlighted() throws Exception {
		
		// locate by name: input password
		WebElement element = browser.findElement(By.name("pwd"));
				
		// highlight
		highlightElement(element);
	}
	
	@Given("^element located by className is highlighted$")
	public void element_located_by_className_is_highlighted() throws Exception {

		// locate by className: select language
		WebElement element = browser.findElement(By.className("ps_select"));
				
		// highlight
		highlightElement(element);
	}

	@Given("^element located by linkText is highlighted$")
	public void element_located_by_linkText_is_highlighted() throws Exception {

		// locate by linkText: link Help
		WebElement element = browser.findElement(By.linkText("Help"));
				
		// highlight
		highlightElement(element);
	}
	
	@Given("^element located by partialLinkText is highlighted$")
	public void element_located_by_partialLinkText_is_highlighted() throws Exception {

		// locate by partialLinkText: link Help
		WebElement element = browser.findElement(By.partialLinkText("elp"));
				
		// highlight
		highlightElement(element);
	}
	
	@Given("^element located by cssSelector is highlighted$")
	public void element_located_by_cssSelector_is_highlighted() throws Exception {
		
		// locate by cssSelector: label Select A Language
		WebElement element = browser.findElement(By.cssSelector("label[for='ps_select_box']"));
				
		// highlight
		highlightElement(element);
	}

	@Given("^element located by tagName is highlighted$")
	public void element_located_by_tagName_is_highlighted() throws Exception {
		
		// locate by tagName: image
		WebElement element = browser.findElement(By.tagName("img"));
				
		// highlight
		highlightElement(element);
	}

	@Given("^element located by xpath is highlighted$")
	public void element_located_by_xpath_is_highlighted() throws Exception {
		
		// locate by xpath: label User ID
		WebElement element = browser.findElement(By.xpath("//label[text()='User ID']"));
				
		// highlight
		highlightElement(element);
	}
	
	@Given("^element error: NoSuchElementException explained$")
	public void element_error_NoSuchElementException_explained() throws Exception {

		// not existing element or synchronization issue
		WebElement element = browser.findElement(By.id("not_existing"));
		element.click();
	}

	@Given("^element error: StaleElementReferenceException explained$")
	public void element_error_StaleElementReferenceException_explained() throws Exception {

		// identify element
		WebElement element = browser.findElement(By.id("userid"));
		
		// highlight to prove that the identification works
		highlightElement(element);
		
		// refresh page to loose reference to the element
		browser.navigate().refresh();
		
		// fix error: identify the element once again to get the current reference
		// WebElement element = browser.findElement(By.id("userid"));
		
		// try to highlight again to get the stale element error
		highlightElement(element);
	}
}