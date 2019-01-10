Feature: Timesheet creation

	@timesheetmatej    
	Scenario: User should be able to submit a new timesheet
	   Given User is logged in the timesheet application with specified credentails
	   | Username     | Password    |
	   | MMMMMZZZZZZZ | PASSSSSSSSS |

When User navigates to CGI Timesheet Reports

And User fills main time report details
	   | Empl ID     | Period End Date |
	   | LPS00350291 | 09.01.2019      |

And User creates a blank time report

And User fills project hours details
	|	Project  	 			| Activity 	| Source Type |Category|
	| 300000000009805	|    3	 		| 	10000     | 10100  |	

And User fills project hours
	|Sunday|Monday|Tuesday |Wednesday |Thursday |Friday |Saturday|
	|  0   |   8  |  8     |    8     |   8     |   8   |   0    |


And User fills personal hours details
	|Description             			|Sunday|Monday|Tuesday |Wednesday |Thursday |Friday |Saturday|
	|Administration								|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|Training											|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|Proposal											|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|In Between Assignments				|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|Quality Assurance						|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|Statutory Holiday						|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|Vacation											|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|Sick leave- No doc. letter		|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|Sick leave										|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|Bereavement Leave						|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|Work Injury Leave						|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|Personal Authorized Leave		|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|Paternity Leave							|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|Family Support Leave					|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|Administrative Leave					|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|Unpaid Leave									|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|Unauthorized/Unpaid Leave		|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|Leave without pay						|  0   |   0  |  0     |    0     |   0     |   0   |   0    |
	|Carers Leave									|  0   |   0  |  0     |    0     |   0     |   0   |   0    |

And User adds attachments
	   | Attachment local path                                                            										|
	   | C:\Users\matej.zoldak\Desktop\software\GIT\learning_by_doing\src\test\java\binaries\attachment_1.txt |
#	   | C:\Users\matej.zoldak\Desktop\software\GIT\learning_by_doing\src\test\java\binaries\attachment_2.txt |
#	   | C:\Users\matej.zoldak\Desktop\software\GIT\learning_by_doing\src\test\java\binaries\attachment_3.txt |
#
