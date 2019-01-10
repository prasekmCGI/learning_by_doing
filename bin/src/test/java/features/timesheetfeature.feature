Feature: Timesheet creation  
   
   @dolotinai 
   Scenario: User should be able to submit a new timesheet
	   Given User is logged in the timesheet application with specified credentails
	   | Username * | Password * |
	   | izida.dolotina | Samuel2019 | 
	   When User navigates to CGI Timesheet Reports
	   And User fill main time report details
	   | Empl ID *   | Period End Date * |
	   | LPS00343830 | 01/26/2019        |
	   And User creates a blank time report
	   And User added comment: "my comment"
	   And User fill project hours details
	   
	   | Project *       | Activity * |Source Type *| Category * | Monday *| Tuesday *| Wednesday* | Thursday *| Friday *|
	   | 000000000110523 | L33_QA_ANA_EXPE|1000     | 10100      |8        |8         |8           |8          |8        |
	   
	   And User add attachments
	   | Attachment local path                                                             |
	   | C:\Users\dolotinai\Projects\learning_by_doing\src\test\java\binaries\attachment_1.txt |
	   | C:\Users\dolotinai\Projects\learning_by_doing\src\test\java\binaries\attachment_2.txt |
	   | C:\Users\dolotinai\Projects\learning_by_doing\src\test\java\binaries\attachment_3.txt |
