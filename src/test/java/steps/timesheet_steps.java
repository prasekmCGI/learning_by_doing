package steps;


import static org.junit.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import framework.DriverUtil;
import framework.Wrappers;

public class timesheet_steps {
	
	// get the driver:
	WebDriver browser = DriverUtil.getDriver();
	
	@Given("^User is logged in the timesheet application with specified credentails$")
	public void user_is_logged_in_the_timesheet_application_with_specified_credentails(DataTable credentialsTable) throws Exception {
	    		
		// get the credentials data from scenario
		List<List<String>> data = credentialsTable.raw();
		
		String timesheetUrl = data.get(1).get(0);
		String username = data.get(1).get(1);
		String password = data.get(1).get(2);
		
		// navigate to timesheet login page
		browser.get(timesheetUrl);
		
		// find the elements
		WebElement inputUsername = browser.findElement(By.id("userid"));
		WebElement inputPassword = browser.findElement(By.id("pwd"));
		WebElement buttonLogin = browser.findElement(By.name("Submit"));
		
		//fill the username
		inputUsername.clear();
		inputUsername.sendKeys(username);
		
		// fill the password
		inputPassword.clear();
		inputPassword.sendKeys(password);
		
		// click on the login button
		buttonLogin.click();
		
		// verify that everything is ok:
		WebElement buttonReports = browser.findElement(By.id("win0groupletPTNUI_LAND_REC_GROUPLET$0"));
		assertTrue(buttonReports.isDisplayed());
		
	}
	
	@Given("^User navigates to CGI Timesheet Reports$")
	public void user_navigates_to_CGI_Timesheet_Reports() throws Exception {
		
		// find the element
		WebElement buttonReports = browser.findElement(By.id("win0groupletPTNUI_LAND_REC_GROUPLET$0"));
		
		// click on it
		buttonReports.click();
		
		// change to the main iframe
		WebElement mainIframe = browser.findElement(By.xpath("//iframe[@title='Main Content']"));
		browser.switchTo().frame(mainIframe);
		
		// verify that we are on the proper page
		WebElement inputEmployee = browser.findElement(By.xpath("//input[@id='EX_TIME_ADD_VW_EMPLID']"));
		assertTrue(inputEmployee.isDisplayed());
		
	}
	
	@Given("^User fill main time report details$")
	public void user_fill_main_time_report_details(DataTable arg1) throws Exception {
		
		// get the data from datatable from scenario
		List<List<String>> data = arg1.raw();
		
		String empl = data.get(1).get(0);
		String period = data.get(1).get(1);
		
		// find elements
		WebElement inputEmployee = browser.findElement(By.id("EX_TIME_ADD_VW_EMPLID"));
		WebElement inputPeriod = browser.findElement(By.id("EX_TIME_ADD_VW_PERIOD_END_DT"));
		
		// fill elements
		inputEmployee.clear();
		inputEmployee.sendKeys(empl);
		inputPeriod.clear();
		inputPeriod.sendKeys(period);
		
	}
	
	@Given("^User creates a blank time report$")
	public void user_creates_a_blank_time_report() throws Exception {

		// click on the button add
		WebElement buttonAdd = browser.findElement(By.id("#ICSearch"));
		buttonAdd.click();
		
		// open a  blank report
		WebElement linkOpen = browser.findElement(By.id("EX_ICLIENT_WRK_OK_PB"));
		linkOpen.click();
	}
	
	@When("^User add attachments$")
	public void user_added_attachments(DataTable arg1) throws Exception {
		
		// identify and click on link attachments
		WebElement linkAttachments = browser.findElement(By.xpath("//a[text()='Attachments']"));
		linkAttachments.click();
		
		// get data from scenario datatable
		List<List<String>> data = arg1.raw();
				
		for (int i=1; i<data.size(); i++) {
			
			// get the path from the current row
			String attachmentPath = data.get(i).get(0);
			String buttonIndex = String.valueOf(i-1);
			
			if (!attachmentPath.equals("")) {
				
				// identify and click on button Add Attachment
				WebElement inputAddAttachment = browser.findElement(By.id("UC_TI_ATTAC_WRK_ATTACHADD$"+ buttonIndex +""));
				inputAddAttachment.click();
				
				// switch to popup iframe
				browser.switchTo().defaultContent();
				WebElement popupIframe = browser.findElement(By.xpath("//iframe[@title='Popup window']"));
				browser.switchTo().frame(popupIframe);
				
				// add attachment
				WebElement inputAddFile = browser.findElement(By.xpath("//input[@type='file']"));
				//inputAddFile.sendKeys("C:\\Users\\sovap\\Downloads\\attachment_1.txt");
				inputAddFile.sendKeys(attachmentPath);
				
				// upload attachment
				WebElement uploadAttachment = browser.findElement(By.xpath("//input[@name='Upload']"));
				uploadAttachment.click();
							
				// change to the main iframe
				browser.switchTo().defaultContent();
				WebElement mainIframe = browser.findElement(By.xpath("//iframe[@title='Main Content']"));
				browser.switchTo().frame(mainIframe);
				
				// wait for the attachment to be added
				WebElement buttonView = browser.findElement(By.id("UC_TI_ATTAC_WRK_ATTACHVIEW$" + buttonIndex + ""));
				Wrappers.waitForElement(buttonView);
			}
						
			// add a new row
			WebElement addRow = browser.findElement(By.id("UC_FILE_UPL_TM$new$" + buttonIndex +"$$0"));
			Wrappers.waitThenClick(addRow);
			
			// wait for the row to be added
			WebElement newRowAddAttachment = browser.findElement(By.id("UC_TI_ATTAC_WRK_ATTACHADD$"+ i +""));
			Wrappers.waitForElement(newRowAddAttachment);
		}
		
		// click on button DONE
		WebElement buttonDone = browser.findElement(By.id("UC_EX_WRK_UC_DONE_PB$0"));
		Wrappers.waitThenClick(buttonDone);
	}
	
	@When("^User added comment: \"([^\"]*)\"$")
	public void user_added_comment(String comment) throws Exception {
	    
		// identify input for comment and fill it
		WebElement inputComment = browser.findElement(By.id("EX_TIME_HDR_COMMENTS"));
		inputComment.sendKeys(comment);
		
	}
	
	@Given("^User fill project hours details$")
	public void user_fill_project_hours_detail(DataTable dataTable) throws Exception {

		// get the data from scenario
		List<List<String>> data = dataTable.raw();
				
		String projectNumber = data.get(1).get(0);
		String activityNumber = data.get(1).get(1);
		
		// open lookup for project
		WebElement buttonLookupProject = browser.findElement(By.id("PROJECT_CODE$prompt$img$0"));
		buttonLookupProject.click();
				
		// switch to popup iframe
		browser.switchTo().defaultContent();
		WebElement popupIframe = browser.findElement(By.xpath("//iframe[@title='Popup window']"));
		browser.switchTo().frame(popupIframe);
				
		// select project
		WebElement linkProject = browser.findElement(By.xpath("//table[@id='PTSRCHRESULTS']//a[text()='" + projectNumber +  "']"));
		linkProject.click();
		browser.switchTo().defaultContent();
		
		// THIS NEEDS TO BE EXPLAINED PROPERLY - comment this block to show the issue
		// wait until popup iframe dissapears (it is overlapping the main iframe, causing issues)
		Wrappers.waitForElementToDisappear("//iframe[@title='Popup window']");
		
		// change to the main iframe
		WebElement mainIframe = browser.findElement(By.xpath("//iframe[@title='Main Content']"));
		browser.switchTo().frame(mainIframe);
				
		// open lookup for activity
		WebElement buttonLookupActivity = browser.findElement(By.id("ACTIVITY_CODE$prompt$img$0"));
		buttonLookupActivity.click();
				
		// switch to popup iframe
		browser.switchTo().defaultContent();
		popupIframe = browser.findElement(By.xpath("//iframe[@title='Popup window']"));
		browser.switchTo().frame(popupIframe);
		
		// select activity
		WebElement linkActivity = browser.findElement(By.xpath("//table[@id='PTSRCHRESULTS']//a[text()='" + activityNumber + "']"));
		linkActivity.click();
		browser.switchTo().defaultContent();
		
		// THIS NEEDS TO BE EXPLAINED PROPERLY - comment this block to show the issue
		// wait until popup iframe dissapears (it is overlapping the main iframe, causing issues)
		Wrappers.waitForElementToDisappear("//iframe[@title='Popup window']");
		
		// change to the main iframe
		mainIframe = browser.findElement(By.xpath("//iframe[@title='Main Content']"));
		browser.switchTo().frame(mainIframe);
		
		//Thread.sleep(5000);
	}

}