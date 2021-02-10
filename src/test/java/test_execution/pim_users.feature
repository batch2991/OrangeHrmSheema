@pim
Feature: PIM_users functionality 
This feature is to validate Add and Delete functionalities of PIM module

@pimLogin 
Scenario: Verify login with valid credentials
Given user is on loginpage
When enter valid username and password and click login
Then the dashboard page is displayed

 @pimpage 
  Scenario: Go to employee information page
    Given user is on the dashboard page
    When user click on PIM and clicks on employee list
    Then employee information page is displayed
 
@idsearch
Scenario: Verify search with employee id
Given user is on employee information page 
When user enters the id in search field and clicks search button
Then list of employees with the id is displayed 

 @addemp 
  Scenario Outline: Verify admin is able to add a new employee
    Given user is on employee information page
    When click Add button and enter <fn>  <ln> in mandatory fields and click save button
    Then user should be created successfully

    Examples: 
      | fn|ln| 
      | apple |apple| 
     
      
 @delete @sanity
  Scenario: Verify admin is able to delete an employee
    Given user is on employee information page 
    When click the check box of the employee click delete and click OK on the dialog window
    Then  user should be deleted successfully and message is displayed 




   
   
