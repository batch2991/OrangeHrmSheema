@search
Feature: Search functionality
@loginsearch @sanity
Scenario: Verify login with valid credentials
Given user is on loginpage
When enter valid username and password and click login
Then the dashboard page is displayed

  @searchuser @sanity
 Scenario Outline: Verify search with username
 Given user navigates to System users page
 When enters the <username> and click search button
 Then list of employees with the user name displayed
      Examples: 
      | username  |
      | json.format | 
       
      
      
  @searchrole
Scenario: Verify search with User Role
Given user navigates to System users page
When user selects User role admin from dropdown
Then list of employees with the User Role displayed


    
