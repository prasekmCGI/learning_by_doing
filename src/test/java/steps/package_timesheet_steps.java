package steps;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import framework.DriverUtil;

public class steps_dolotinaCGI {

      WebDriver browser = DriverUtil.getDriver();

      @Given("^User is logged in the timesheet application with specified credentails$")
      public void user_is_logged_in_the_timesheet_application_with_specified_credentails_PZ(DataTable credentialsTable) throws Exception {


             // navigate to timesheet login page
             browser.get("*********");

             // get the credentials data from scenario
             List<List<String>> data = credentialsTable.raw();

             String username = data.get(1).get(0);
             String password = data.get(1).get(1);

             // find the web element for the username
             WebElement inputUsername = browser.findElement(By.id("userid"));

             //fill the username
             inputUsername.clear();
             inputUsername.sendKeys(username);

             // find the web element for the password
             WebElement inputPassword = browser.findElement(By.id("pwd"));

             //fill the password
             inputPassword.clear();
             inputPassword.sendKeys(password);

             // click on the login button
             WebElement buttonLogin = browser.findElement(By.name("Submit"));

             // submit the login
             buttonLogin.click();
      }

      @And("^User navigates to CGI Timesheet Reports$")
      public void user_navigates_to_CGI_Timesheet_Reports_ID() {

             //validate login successful
             WebElement img = browser.findElement(By.id("PS_REPORT_TIME_L_FL$0"));
             assertTrue(img.isDisplayed());

             //click on new timesheet
             img.click();
      }

      @And("^User fill main time report details$")
      public void user_fill_main_time_report_details_(DataTable dataTable) throws InterruptedException  {

             //get data from table 
             List<List<String>> data = dataTable.raw();
             String empId = data.get(1).get(0);
             String period = data.get(1).get(1);

      browser.switchTo().frame(browser.findElement(By.id("main_target_win0")));

             //find EmpID 
             WebElement inputEmpId = browser.findElement(By.name("EX_TIME_ADD_VW_EMPLID"));

             //fill in EmpID
             inputEmpId.clear();
             inputEmpId.sendKeys(empId);

             //find period
             WebElement inputPeriod = browser.findElement(By.id("EX_TIME_ADD_VW_PERIOD_END_DT"));

             //set period date
             inputPeriod.clear();
             inputPeriod.sendKeys(period);

             //find a Add button
             WebElement addButton = browser.findElement(By.id("#ICSearch"));

             //click Add button
             addButton.click();

      }

      @And("^User creates a blank time report$")
      public void user_creates_a_blank_time_report_() throws Exception {
             // find open blank ink
             WebElement blankLink = browser.findElement(By.id("EX_ICLIENT_WRK_OK_PB"));

             blankLink.click();
      }
      
      @And("^User fill project hours details$")
      public void user_fill_project_hours_details(DataTable ProjectHoursDetails) throws Exception {

             //get data for project hours

    	  
          List<List<String>> data = ProjectHoursDetails.raw();
          
            String Project = data.get(1).get(1); 
            String Activity = data.get(1).get(1);  
            String Category = data.get(1).get(2); 
            String Monday = data.get(1).get(3); 
            String Tuesday = data.get(1).get(4); 
            String Wednesday = data.get(1).get(5); 
            String Thursday = data.get(1).get(6);
            String Friday = data.get(1).get(7);
            
            // Insert data into ProjectHoursDetails
            
            WebElement ProjectId = browser.findElement(By.id ("PROJECT_CODE$0"));
         
			inputProjectId.clear();
            inputProjectId.sendKeys (Project);
            
            inputActivity.clear ();
            inputActivity.sendKeys (Activity);
            
}
      
      
      @When("^User added comment: \"([^\"]*)\"$")
      public void user_added_comment(String arg1) throws Exception {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @When("^User add attachments$")
      public void user_add_attachments(DataTable arg1) throws Exception {
          // Write code here that turns the phrase above into concrete actions
          // For automatic transformation, change DataTable to one of
          // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
          // E,K,V must be a scalar (String, Integer, Date, enum etc)
          throw new PendingException();
      }

}










