Feature: Timesheet creation  
   
   @timesheet 
   Scenario: User should be able to submit a new timesheet
	   Given User is logged in the timesheet application with specified credentails
	   | Timesheet Url * | Username * | Password * |
	   |                 |            |            |
	   When User navigates to CGI Timesheet Reports
	   And User fill main time report details
	   | Empl ID *   | Period End Date * |
	   | LPS00264008 | 01/26/2019        |
	   And User creates a blank time report
	   And User added comment: "my comment"
	   And User fill project hours details
	   | Project *       | Activity * |
	   | 000000000115886 | 2          |
	   And User add attachments
	   | Attachment local path                                                             |
	   | C:\Users\sovap\Projects\learning_by_doing\src\test\java\binaries\attachment_1.txt |
	   | C:\Users\sovap\Projects\learning_by_doing\src\test\java\binaries\attachment_2.txt |
	   | C:\Users\sovap\Projects\learning_by_doing\src\test\java\binaries\attachment_3.txt |




#	   And User fill personal hours details for Administration
#	   | Sunday | Monday  | .. |
#	   | .. 		| ...			| .. |
#	   And User fill personal hours details for Training
#	   | Sunday | Monday  | .. |
#	   | .. 		| ...			| .. | 		