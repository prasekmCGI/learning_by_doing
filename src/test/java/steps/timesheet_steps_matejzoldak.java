package steps;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

//import org.apache.http.annotation.ThreadSafe;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import framework.DriverUtil;
import framework.Wrappers;
import framework.Helpers;


public class timesheet_steps_matejzoldak {
	
	@Given("^User is logged in the timesheet application with specified credentails$")
	public void user_is_logged_in_the_timesheet_application_with_specified_credentails() throws Exception {
		
//		GET CLASSIFIED INFO
		ArrayList<String> classifiedInfo = Helpers.getClassifiedInformation();
		
//		GET DATA FROM CLASSIFIED FILE
		String URL = classifiedInfo.get(0);
		String username = classifiedInfo.get(1);
		String password = classifiedInfo.get(2);
		
//		NAVIGATE TO LOGIN PAGE
		WebDriver browser = DriverUtil.getDriver();
		browser.get(URL);
		
//		find elements and add the credentials
		browser.findElement(By.id("userid")).sendKeys(username); 
	    browser.findElement(By.id("pwd")).sendKeys(password);
	    browser.findElement(By.name("Submit")).click();
	    
//	    VALIDATION
		try {
		    assertEquals(browser.findElement(By.id("PTNUI_LAND_REC_GROUPLET_LBL$0")).getText(), "CGI Time Reports");
		    //If the message is displayed
		    System.out.println("PASS");
		} catch (Exception e) {
		    //If the message is not displayed
		    System.out.println("FAIL");
		}
	
	}
	
	
	@When("^User navigates to CGI Timesheet Reports$")
	public void user_navigates_to_CGI_Timesheet_Reports() throws Exception {
		WebDriver browser = DriverUtil.getDriver();
		browser.findElement(By.id("win0groupletPTNUI_LAND_REC_GROUPLET$0")).click();
	}

	
	@And("^User fills main time report details$")
	public void user_fills_main_time_report_details(DataTable employeeID) throws Exception {
		WebDriver browser = DriverUtil.getDriver();
			    	   
	    //FIND IFRAME and SWITCH TO IT
	    WebElement iFrame = browser.findElement(By.xpath("//iframe"));
	    browser.switchTo().frame(iFrame);  
		
	    //CLEAR INPUT
	    WebElement inputField = browser.findElement(By.id("EX_TIME_ADD_VW_EMPLID"));
	    inputField.click();
	    inputField.clear();
	        
	    //ENTER Employee ID DATA
	    List<List<String>> data = employeeID.raw();
	    inputField.sendKeys(data.get(1).get(0));
	        
	    
	    //CLEAR & ENTER Period End Date
	    WebElement periodField = browser.findElement(By.id("EX_TIME_ADD_VW_PERIOD_END_DT"));
	    periodField.click();
	    periodField.clear();
	    List<List<String>> data2 = employeeID.raw();
	    periodField.sendKeys(data2.get(1).get(1));
	    
	    //CLICK ADD
	    browser.findElement(By.id("#ICSearch")).click();   
	}
	
	
	@And("^User creates a blank time report$")
	public void user_creates_a_blank_time_report() throws Exception {
		WebDriver browser = DriverUtil.getDriver();
		browser.findElement(By.id("EX_ICLIENT_WRK_OK_PB")).click();	 
	}

	
	@And("^User fills project hours details$")
	public void user_fills_project_hours_details(DataTable projecttable) throws Exception {
		WebDriver browser = DriverUtil.getDriver();
		List<List<String>> data = projecttable.raw();
		
		    
		//ENTER PROJECT NUMBER POPUP WINDOW
		WebElement searchIcon = browser.findElement(By.id("PROJECT_CODE$prompt$0"));
	    searchIcon.click();
	    	   
		// SWITCH TO POPUP iFRAME
		browser.switchTo().defaultContent();
		WebElement popupIframe = browser.findElement(By.xpath("//iframe[@title='Popup window']"));
		browser.switchTo().frame(popupIframe);

		//FIND THE CORRECT PROJECT via projectNumber
		String projectNumber = data.get(1).get(0);
	    WebElement correctProject = browser.findElement(By.xpath("//table[@id='PTSRCHRESULTS']//a[text()='" + projectNumber + "']"));
	    
//	    CLICK ON CORRECT PROJECT
	    correctProject.click();
	    browser.switchTo().defaultContent();
	 	Wrappers.waitForElementToDisappear("//iframe[@title='Popup window']");
	 	
//	  	SWITCH TO MAIN iFRAME
	    WebElement mainIframe = browser.findElement(By.xpath("//iframe[@title='Main Content']"));
		browser.switchTo().frame(mainIframe);

	        
//	    ACTIVITY SEARCH ICON CLICK   
	    WebElement searchActivityIcon = browser.findElement(By.id("ACTIVITY_CODE$prompt$0"));
	    searchActivityIcon.click();
	    
//	  	SWITCH TO POPUP iFRAME
	    browser.switchTo().defaultContent();
		WebElement popupActIframe = browser.findElement(By.xpath("//iframe[@title='Popup window']"));
		browser.switchTo().frame(popupActIframe);

		
//		FIND THE CORRECT ACTIVITY via activityNumber
		String activityNumber = data.get(1).get(1);
		WebElement correctActivity = browser.findElement(By.xpath("//table[@id='PTSRCHRESULTS']//a[text()='" + activityNumber + "']"));
		
	
//		CLICK ON THE CORRECT ACTIVITY NUMBER
		correctActivity.click();
	    
//	    SWITCH BACK TO MAIN iFRAME
	    browser.switchTo().defaultContent();
	    Wrappers.waitForElementToDisappear("//iframe[@title='Popup window']");	    
		browser.switchTo().frame(mainIframe);
	}
	
	
	@And("^User fills project hours$")
	public void user_fills_project_hours(DataTable weekHours) throws Exception {
		WebDriver browser = DriverUtil.getDriver();
		List<List<String>> data = weekHours.raw();

//		FOR LOOP FOR ENTERING PROJECT HOURS DETAILS
		System.out.println(data.size() + "PROJECT HOUR DETAILS TO HORNE");
	    for (int i = 1; i <= 7; i++) {
	    	browser.findElement(By.id("TIME" + i + "$0")).sendKeys(data.get(1).get((i-1)));
	    }
	}
	
	
	@And("^User fills personal hours details$")
	public void user_fills_personal_hours_details(DataTable addHours) throws Exception {
		WebDriver browser = DriverUtil.getDriver();
		List<List<String>> data = addHours.raw();
		
//		view all
		browser.findElement(By.id("EX_TRC_MAP_VW$hviewall$0")).click();
		Thread.sleep(1500);
		
		
//		FOR LOOP SYNTAX
		for (int i = 0; i <= (data.size()-2); i++) {
	        for (int j = 1; j <= 7; j++) {
	        	browser.findElement(By.id("POL_TIME" + j + "$" + i)).sendKeys(data.get((i+1)).get(j));
	        }     
	    }
	}

	@And("^User adds attachments$")
	public void user_adds_attachments(DataTable attachmentTable) throws Exception {
		WebDriver browser = DriverUtil.getDriver();
		List<List<String>> data = attachmentTable.raw();
		
//		CLICK ON ATTACHMENTS
		WebElement attachments = browser.findElement(By.id("UC_EX_WRK_ATTACHMENT_PB$323$"));
		attachments.click();
		
			
//		FIND AND CLICK ON ADD ATTACHMENT
		WebElement addAttachment = browser.findElement(By.id("UC_TI_ATTAC_WRK_ATTACHADD$0"));
		addAttachment.click();
	
	
//		SWITCH TO POPUP IFRAME
		browser.switchTo().defaultContent();
		WebElement popupIframe = browser.findElement(By.xpath("//iframe[@title='Popup window']"));
		browser.switchTo().frame(popupIframe);
		
//		ADD ATTACHMENT
		WebElement addFile = browser.findElement(By.xpath("//input[@title='Browse']"));
		addFile.sendKeys(data.get(1).get(0));
	
//		CLICK UPLOAD
		WebElement upload = browser.findElement(By.xpath("//input[@name='Upload']"));
		upload.click();
		
//		SWITCH BACK TO MAIN iFRAME
		browser.switchTo().defaultContent();
		Wrappers.waitForElementToDisappear("//iframe[@title='Popup window']");	
		WebElement mainIframe = browser.findElement(By.xpath("//iframe[@title='Main Content']"));
		browser.switchTo().frame(mainIframe);
		
		
//		GO BACK TO TIMESHEET
		WebElement clickDone = browser.findElement(By.id("UC_EX_WRK_UC_DONE_PB$0"));
		clickDone.click();
		
		
		Thread.sleep(5000);
	}
}
