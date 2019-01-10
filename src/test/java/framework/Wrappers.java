package framework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Function;

public final class Wrappers {
	
	public static int IMPLICIT_WAIT = 25;
	public static int EXPLICIT_WAIT = 15;
	public static int PAGE_LOAD_WAIT = 120;
	public static int JS_WAIT = 15;
	
	public static WebElement waitForElement(WebElement elementToWaitFor) {
	
		return (new WebDriverWait(DriverUtil.getDriver(), EXPLICIT_WAIT)).until(ExpectedConditions.elementToBeClickable(elementToWaitFor));
	}

	public static void waitThenClick(WebElement elementToClick) {
	
		WebElement element = (new WebDriverWait(DriverUtil.getDriver(), EXPLICIT_WAIT)).until(ExpectedConditions.elementToBeClickable(elementToClick));
		element.click();
	}
	
	public static void waitForElementToDisappear(String locator){
		
		WebDriver browser = DriverUtil.getDriver();
		
		// turn off implicit wait
		browser.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		FluentWait<WebDriver> wait = new FluentWait<>(browser)
			    .withTimeout(EXPLICIT_WAIT, TimeUnit.SECONDS)
			    .pollingEvery(100, TimeUnit.MILLISECONDS)
			    .ignoring(NoSuchElementException.class);

		wait.until(new Function<WebDriver, Boolean>() {
			  @Override
			  public Boolean apply(WebDriver browser) {
				  Boolean elementExist = browser.findElements(By.xpath(locator)).size() == 0;
				  return elementExist;
			  }
		});
		
		// turn on implicit wait
		browser.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	
}