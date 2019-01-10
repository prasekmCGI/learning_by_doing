package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.runtime.junit.Assertions;

//import runner.DriverUtil;
import framework.DriverUtil;

public class timesheet_steps_prasekmCGI {
	
	
	
	
	@Given("^User is logged in the timesheet application with specified credentails$")
	public void user_is_logged_in_the_timesheet_application_with_specified_credentails(DataTable credentialsTable ) throws Exception {
		
		WebDriver browser = DriverUtil.getDriver();
		browser.get("aaaaaa");
		
//		 get the credentials data from scenario
		List<List<String>> data = credentialsTable.raw();
		
		String username = data.get(1).get(0);
		String password = data.get(1).get(1);
//		System.out.println(data);
//		(("Username","Password"),("peter.sova","myPassword1")) 
		
		
		WebElement inputUsername = browser.findElement(By.id("userid"));
		inputUsername.clear();
		inputUsername.sendKeys(username);
				
			
		WebElement inputPassword = browser.findElement(By.id("pwd"));
		inputPassword.clear();
		inputPassword.sendKeys(password);
				
		
		WebElement buttonLogin = browser.findElement(By.name("Submit"));
		buttonLogin.click();
		
		
		WebElement result = browser.findElement(By.xpath("//*[@id=\"PTNUI_LAND_WRK_GROUPBOX14$PIMG\"]/span[1]"));
	
// Assertion #1:		
		String resultText = result.getText();
		assertEquals(resultText, "PSA Finance");
		
// Assertion #2:
//		assertTrue(result.isDisplayed());
		
// Assertion #3:	NEFUNGUJE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!	
//		try {
//			browser.findElement(By.xpath("//*[@id=\"PTNUI_LAND_WRK_GROUPBOX14$PIMG\"]/span[1]"));
//			}
//			catch (NoSuchElementException e) {
//			throw new RuntimeException("The desired element is not displayed");
//			}
				
//		Thread.sleep(2000);
		
	}


	@Given("^User navigates to CGI Timesheet Reports$")
	public void user_navigates_to_CGI_Timesheet_Reports() throws Exception {
		
		WebDriver browser = DriverUtil.getDriver();

		WebElement cgiTimeReportsButton = browser.findElement(By.id("win0divPTNUI_LAND_REC_GROUPLET$0"));
		cgiTimeReportsButton.click();
		
		WebElement cgiTimeReportsTitle = browser.findElement(By.id("PT_PAGETITLElbl"));
		String cgiTimeReportsTitle_Text = cgiTimeReportsTitle.getText();
		assertEquals(cgiTimeReportsTitle_Text, "CGI Time Reports");
		
//		Thread.sleep(2000);
	}
	
	
	@Given("^User fill main time report details$")
	public void user_fill_main_time_report_details(DataTable emplIDPeriodTable) throws Exception {
		
		WebDriver browser = DriverUtil.getDriver();
		
		List<List<String>> data = emplIDPeriodTable.raw();
		String emplID = data.get(1).get(0);
		String periodEndDate = data.get(1).get(1);
		
		WebElement myIframe = browser.findElement(By.xpath("//iframe"));
		browser.switchTo().frame(myIframe);
		
		WebElement input_emplID = browser.findElement(By.id("EX_TIME_ADD_VW_EMPLID"));
		input_emplID.clear();
		input_emplID.sendKeys(emplID);	
		
		WebElement input_periodEndDate = browser.findElement(By.id("EX_TIME_ADD_VW_PERIOD_END_DT"));
		input_periodEndDate.clear();
		input_periodEndDate.sendKeys(periodEndDate);	
				
		
//		Thread.sleep(2000);

	}

	@Given("^User creates a blank time report$")
	public void user_creates_a_blank_time_report() throws Exception {

		WebDriver browser = DriverUtil.getDriver();
		
		WebElement addButton = browser.findElement(By.id("#ICSearch"));
		addButton.click();
		
//		Thread.sleep(2000);
		
		WebElement openBlankLink = browser.findElement(By.id("EX_ICLIENT_WRK_OK_PB"));
		openBlankLink.click();
		
//		Thread.sleep(2000);

//		Explicit Wait:		
		WebDriverWait wait = new WebDriverWait(browser, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EX_TIME_HDR_COMMENTS_LBL")));
		
		
		WebElement summaryTitle = browser.findElement(By.id("EX_ICLIENT_WRK_PAGE_TITLE_60"));
		String text_summaryTitle = summaryTitle.getText();
		
		assertEquals("Time Report Summary", text_summaryTitle);
		
	}
	
	
	@Given("^User added comment: \"([^\"]*)\"$")
	public void user_added_comment(String commentText) throws Exception {

		WebDriver browser = DriverUtil.getDriver();
		
		WebElement input_comment = browser.findElement(By.id("EX_TIME_HDR_COMMENTS"));
		input_comment.clear();
		input_comment.sendKeys(commentText);
		
	}

	
	@Given("^User fill project hours details$")
	public void user_fill_project_hours_detail(DataTable projectTable) throws Exception {
		
		WebDriver browser = DriverUtil.getDriver();
		
		List<List<String>> data = projectTable.raw();
		String project = data.get(1).get(0);
		String activity = data.get(1).get(1);
		String monday = data.get(1).get(2);
		String tuesday = data.get(1).get(3);
		String wednesday = data.get(1).get(4);
		String thursday = data.get(1).get(5);
		String friday = data.get(1).get(6);

		WebElement lookUpProjectIcon = browser.findElement(By.id("PROJECT_CODE$prompt$img$0"));
		lookUpProjectIcon.click();
		
		browser.switchTo().defaultContent();
		WebElement popupIframe = browser.findElement(By.xpath("//iframe[@title='Popup window']"));
		browser.switchTo().frame(popupIframe);
		
		WebElement linkProject = browser.findElement(By.xpath("//table[@id='PTSRCHRESULTS']//a[text()='" + project +  "']"));
		linkProject.click();
		browser.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		
		// change to the main iframe
		WebElement mainIframe = browser.findElement(By.xpath("//iframe[@title='Main Content']"));
		browser.switchTo().frame(mainIframe);
				
		WebElement lookUpActivityIcon = browser.findElement(By.id("ACTIVITY_CODE$prompt$img$0"));
		lookUpActivityIcon.click();

		Thread.sleep(2000);
		
		browser.switchTo().defaultContent();
		popupIframe = browser.findElement(By.xpath("//iframe[@title='Popup window']"));
		browser.switchTo().frame(popupIframe);
		
		Thread.sleep(2000);
		
		// select activity
		WebElement linkActivity = browser.findElement(By.xpath("//table[@id='PTSRCHRESULTS']//a[text()='" + activity + "']"));
		linkActivity.click();
		browser.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		// change to the main iframe
		mainIframe = browser.findElement(By.xpath("//iframe[@title='Main Content']"));
		browser.switchTo().frame(mainIframe);
		

		
		
		
		
//		WebElement input_project = browser.findElement(By.id("PROJECT_CODE$0"));
//		input_project.clear();
//		input_project.sendKeys(project);
//		input_project.sendKeys(Keys.ENTER);		
//		Thread.sleep(2000);

//		explicit Wait:
//		WebDriverWait wait = new WebDriverWait(browser, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("TIME2$0")));

		
//// Activity "3" je pro 2019 zatim neplatna	
//		WebElement input_activity = browser.findElement(By.id("ACTIVITY_CODE$0"));
//		input_activity.clear();
//		input_activity.sendKeys(activity);
//	
//				
//		WebElement input_monday = browser.findElement(By.id("TIME2$0"));
//		input_monday.clear();
//		input_monday.sendKeys(monday);
//		
//		WebElement input_tuesday = browser.findElement(By.id("TIME3$0"));
//		input_tuesday.clear();
//		input_tuesday.sendKeys(tuesday);
//		
//		WebElement input_wednesday = browser.findElement(By.id("TIME4$0"));
//		input_wednesday.clear();
//		input_wednesday.sendKeys(wednesday);
//		
//		WebElement input_thursday = browser.findElement(By.id("TIME5$0"));
//		input_thursday.clear();
//		input_thursday.sendKeys(thursday);
//		
//		WebElement input_friday = browser.findElement(By.id("TIME6$0"));
//		input_friday.clear();
//		input_friday.sendKeys(friday);
		
			
	}

	
	@Given("^User fills non-project hours detail$")
	public void user_fills_non_project_hours_detail(DataTable nonProjectTable) throws Exception {
		
		WebDriver browser = DriverUtil.getDriver();
		
		WebElement hyperlink_viewAll = browser.findElement(By.id("EX_TRC_MAP_VW$hviewall$0"));
		hyperlink_viewAll.click();

		Thread.sleep(5000);

////		Explicit Wait:		
//		WebDriverWait wait = new WebDriverWait(browser, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("POL_TIME2$5")));
		
		
		List<List<String>> data = nonProjectTable.raw();

		
		for (int i = 0; i < 19; i++) {
		      
			for (int j = 2; j < 7; j++) {

//			 System.out.println("POL_TIME" + j + "$" + i);
//			 System.out.println("data.get(" + (i + 1) + ").get(" + (j - 1) + ")");
		     
			 WebElement identification = browser.findElement(By.id("POL_TIME" + j + "$" + i));
			 identification.clear();
			 identification.sendKeys(data.get(i + 1).get(j - 1));

			}
	    }
		
		
		Thread.sleep(15000);
	
		
	}
	
}