package steps;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import framework.DriverUtil;

public class timesheet_steps {
	WebDriver browser = DriverUtil.getDriver();
	@Given("^User is logged in the timesheet application with specified credentails$")
	public void user_is_logged_in_the_timesheet_application_with_specified_credentails(DataTable credentialsTable) throws Exception {
	    
		
		// navigate to timesheet login page
		
		
		// get the credentials data from scenario
		List<List<String>> data = credentialsTable.raw();
		
		String url = data.get(1).get(0);
		String username = data.get(1).get(1);
		String password = data.get(1).get(2);
		
		browser.get(url);
		
		// find the web element for the username
		WebElement inputUsername = browser.findElement(By.id("userid"));
		
		
		//fill the username
		inputUsername.clear();
		inputUsername.sendKeys(username);
		
		WebElement inputPassword = browser.findElement(By.id("pwd"));
		
		//fill the password
		inputPassword.clear();
		inputPassword.sendKeys(password);
				
		// click on the login button
		WebElement buttonLogin = browser.findElement(By.name("Submit"));
				
		// submit the login
		buttonLogin.click(); 
		
				
		
						
		// click on the login button
		// buttonLogin.click();

		// submit the login
		
		//System.out.println("this is a header of my table: " + data.get(0));
		//System.out.println("this is a row with my credentials: " + data.get(1));
		
		// 
		
		//Thread.sleep(8000);
		
		//[[Username, Password], [peter.sova, myPassword1]]
		
	}

	@And("^User navigates to CGI Timesheet Reports$")
	public void user_navigates_to_cgi_timesheet_reports() {
		
	WebElement buttonTile = browser.findElement(By.id("PS_REPORT_TIME_L_FL$0"));
	buttonTile.click(); 
	
		
	}
	
	@And("^User fill main time report details$")
	public void user_fill_main_time_report_details(DataTable DatesTable) throws Exception {
	
	// get the credentials data from scenario
	List<List<String>> data = DatesTable.raw();	
	String emplid = data.get(1).get(0);
	String enddate = data.get(1).get(1);
	
	browser.switchTo().frame(browser.findElement(By.id("main_target_win0")));
	WebElement inputEmplid = browser.findElement(By.id("EX_TIME_ADD_VW_EMPLID"));
	
	//fill the empl id
	inputEmplid.clear();
	
	inputEmplid.sendKeys(emplid);
	
	WebElement inputDate = browser.findElement(By.id("EX_TIME_ADD_VW_PERIOD_END_DT"));
	inputDate.clear();
	inputDate.sendKeys(enddate);
	
	
	//button add

	WebElement buttonAdd = browser.findElement(By.id("#ICSearch"));	
	buttonAdd.click();	
	
	}
	
	@And("^User creates a blank time report$")
	public void user_creates_a_blank_time_report() throws Exception {

	WebElement linkBlank = browser.findElement(By.id("EX_ICLIENT_WRK_OK_PB"));	
	linkBlank.click();
	
	}
	
	@And("^User fill project hours detail$")
	public void user_fill_project_hours_detail(DataTable ProjectTable) throws Exception {
	    
		// get the project data from scenario
		List<List<String>> data = ProjectTable.raw();	
		String projid = data.get(1).get(0);
		String activity = data.get(1).get(1);
		String category = data.get(1).get(2);
		String mo = data.get(1).get(3);
		String tu = data.get(1).get(4);
		String we = data.get(1).get(5);
		String th = data.get(1).get(6);
		String fr = data.get(1).get(7);
		
		
		WebElement inputProjId = browser.findElement(By.id("PROJECT_CODE$0"));
		inputProjId.clear();
		inputProjId.sendKeys(projid);	
		
		
		//primo input fields activity id vepsat
		//WebElement inputActId = browser.findElement(By.id("ACTIVITY_CODE$0"));
		//inputActId.click();
		//inputActId.sendKeys(activity);
		
		//aktivity pres lupicku:
		WebElement inputActId = browser.findElement(By.id("ACTIVITY_CODE$prompt$img$0"));
		inputActId.click();
		//WebElement linkActivity = browser.findElement(By.id("RESULT0$2"));
		//linkActivity.click();
		//inputActId.sendKeys(activity);	
		
		
		//
		//inputProjId.sendKeys(Keys.ENTER);
				
		//pokus s javascriptem
//		JavascriptExecutor jse = (JavascriptExecutor)browser;
//		jse.executeScript("arguments[0].value='gjhgj';", inputActId);
					
			
		// Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		
		
		browser.switchTo().frame(browser.findElement(By.xpath("//iframe[@title='popup window']")));
		//browser.findElement(By.linkText("DE-DELIVERY")).click(); 
		WebElement projLink = browser.findElement(By.linkText("DE-DELIVERY"));
		projLink.click();
		

		
		
		//vyplneni hodin:
		
//		WebElement inputMo = browser.findElement(By.id("TIME2$0"));
//		inputMo.click();
//		inputMo.clear();
//		inputMo.sendKeys(mo);
////	inputMo.sendKeys(Keys.ENTER);
//		inputMo.click();
//	
	}
	
	

}














//
//
//
//package steps;
//
//import static org.junit.Assert.assertTrue;
//import java.util.List;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import cucumber.api.DataTable;
//import cucumber.api.java.en.Given;
//import framework.DriverUtil;
//
//public class timesheet_steps {
//	
//	// get the driver:
//	WebDriver browser = DriverUtil.getDriver();
//	
//	@Given("^User is logged in the timesheet application with specified credentails$")
//	public void user_is_logged_in_the_timesheet_application_with_specified_credentails(DataTable credentialsTable) throws Exception {
//	    		
//		// get the credentials data from scenario
//		List<List<String>> data = credentialsTable.raw();
//		
//		String timesheetUrl = data.get(1).get(0);
//		String username = data.get(1).get(1);
//		String password = data.get(1).get(2);
//				
//		// navigate to timesheet login page
//		browser.get(timesheetUrl);
//		
//		// find the elements
//		WebElement inputUsername = browser.findElement(By.id("userid"));
//		WebElement inputPassword = browser.findElement(By.id("pwd"));
//		WebElement buttonLogin = browser.findElement(By.name("Submit"));
//		
//		//fill the username
//		inputUsername.clear();
//		inputUsername.sendKeys(username);
//		
//		// fill the password
//		inputPassword.clear();
//		inputPassword.sendKeys(password);
//		
//		// click on the login button
//		buttonLogin.click();
//		
//		// verify that everything is ok:
//		WebElement buttonReports = browser.findElement(By.id("win0groupletPTNUI_LAND_REC_GROUPLET$0"));
//		assertTrue(buttonReports.isDisplayed());
//		//pokus zmena
//		
//	}
//}