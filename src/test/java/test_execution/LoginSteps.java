package test_execution;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.PimPage;



public class LoginSteps 
{
		LoginPage loginpage=new LoginPage();
		
		
		
		//////////*******************************Loginpage******************
	 	@Given("^open the browser$")
	    public void open_the_browser() throws Throwable 
	 	{
	        loginpage.init();
	        
	       
	    }
	    @When("^enter orangeHRM url$")
	    public void enter_orangehrm_url() throws Throwable
	    {
	        loginpage.openurl();
	    }
	    @Then("^login page is displayed$")
	    public void login_page_is_displayed() throws Throwable 
	    {
	        loginpage.validate_loginpage();
	    }
	    
	    ///********************** valid login**********************************8
	    @Given("^user is on loginpage$")
	    public void user_is_on_loginpage() throws Throwable 
	    {
	        loginpage.openurl();
	    }
	    @When("^enter valid username and password and click login$")
	    public void enter_valid_username_and_password_and_click_login() throws Throwable 
	    {
	    	loginpage.validlogin();	        
	    }
	    @Then("^the dashboard page is displayed$")
	    public void the_dashboard_page_is_displayed() throws Throwable 
	    {
	        loginpage.validatedashboardpage();
	    }
	   
	    ////////*****************logout**************************
	    @Given("^user is on dashboard page$")
	    public void user_is_on_dashboard_page() throws Throwable
	    {
	    	loginpage.validatedashboardpage();
	    }

	    @When("^click signout$")
	    public void click_signout() throws Throwable
	    {
	        loginpage.logout();
	    }

	    ////////********** INvalid login**********************************
	    @When("^enter invalid (.+) or invalid (.+) and click login$")
	    public void enter_invalid_or_invalid_and_click_login(String uid, String pwd) throws Throwable 
	    {
	    	loginpage.logout();
	        loginpage.invalidlogin(uid, pwd);
	    }

	    @Then("^error message is displayed$")
	    public void error_message_is_displayed() throws Throwable 
	    {
	        loginpage.errorMessage();
	    }

}