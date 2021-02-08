package test_execution;

import io.cucumber.java.en.*;
import pages.DashboardPage;

public class SearchSteps
{
	DashboardPage dashBoardPage=new DashboardPage();
	
	//===============================search with username===========================
	
	 @Given("^user navigates to System users page$")
	    public void user_navigates_to_system_users_page() throws Throwable
	    {
		 dashBoardPage.init();
		 dashBoardPage.clickAdmin();
	        dashBoardPage.validateSysUsersPage();
	    }

	    @When("^enters the (.+) and click search button$")
	    public void enters_the_and_click_search_button(String username) throws Throwable {
	    	
	    	dashBoardPage.enterUsername(username);
	    	dashBoardPage.clickSearch();
	    }

	    @Then("^list of employees with the user name displayed$")
	    public void list_of_employees_with_the_user_name_displayed() throws Throwable {
	    	dashBoardPage.validateUsername();
	    }

//===================================search with role====================================	    
	    
	    @When("^user selects User role admin from dropdown$")
	    public void user_selects_user_role_admin_from_dropdown() throws Throwable {
	    	
	    	
	    	dashBoardPage.clickReset();
	    	dashBoardPage.selectRole();
	    	dashBoardPage.clickSearch();
	    }

	    @Then("^list of employees with the User Role displayed$")
	    public void list_of_employees_with_the_user_role_displayed() throws Throwable {
	    	dashBoardPage.validaterole();
	    }


}
