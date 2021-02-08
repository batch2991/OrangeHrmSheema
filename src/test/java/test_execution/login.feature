@login
Feature: Login to OrangeHRM application
This feature is to validate login functionality for OrangeHRM

@Loginpage 
Scenario: verify loginpage
Given open the browser
When enter orangeHRM url
Then login page is displayed

@validLogin 
Scenario: Verify login with valid credentials
Given user is on loginpage
When enter valid username and password and click login
Then the dashboard page is displayed

@logout
Scenario: verify the logout functionality
Given user is on dashboard page
When click signout
Then login page is displayed

@invalidLogin 
Scenario Outline: Verify with invalid credentials
Given user is on loginpage
When enter invalid <uid> or invalid <pwd> and click login
Then error message is displayed

Examples: 
|uid|pwd|
|Adminn|admin123|
|Admin|admin1234|