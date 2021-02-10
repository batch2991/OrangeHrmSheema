package test_execution;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PimPage;

public class PimSteps
{
	
	 
	PimPage pimPage = new PimPage();
	
	
	 @Given("^user is on the dashboard page$")
	    public void user_is_on_the_dashboard_page() throws Throwable
	    {
		 pimPage.initialise();
		 //loginpage.validatedashboardpage();       
	       
	    }

	    @When("^user click on PIM and clicks on employee list$")
	    public void user_click_on_pim_and_clicks_on_employee_list() throws Throwable
	    {
	    	pimPage.clickpimlink();
	    	pimPage.clickEmployeeList();
	    }

	    @Then("^employee information page is displayed$")
	    public void employee_information_page_is_displayed() throws Throwable
	    {
	    	
	    	pimPage.validateEmployeeinfoPage();
	    }
	    
//============================search with id================================	    	

        @When("^user enters the id in search field and clicks search button$")
        public void user_enters_the_id_in_search_field_and_clicks_search_button() throws Throwable {
          pimPage.entersearchid();
          pimPage.clickSearch();
        }

        @Then("^list of employees with the id is displayed$")
        public void list_of_employees_with_the_id_is_displayed() throws Throwable {
            pimPage.validateSearchid();
        }
        
//////////*******************************addemployee******************
	    @Given("^user is on employee information page$")
	    public void user_is_on_employee_information_page() throws Throwable 
	    {
	    	pimPage.clickpimBtn();
	    	pimPage.clickEmployeeList();
	    	pimPage.validateEmployeeinfoPage();
	    	
	    }
	    

	    
	    @When("^click Add button and enter (.+)  (.+) in mandatory fields and click save button$")
	    public void click_add_button_and_enter_in_mandatory_fields_and_click_save_button(String firstname, String lastname) throws Throwable
	    {     	        
	        pimPage.clickaddBtn();
	        pimPage.validateAddEmployee();
	        pimPage.enterFirstname(firstname);
	        pimPage.enterLastname(lastname);
	        pimPage.clickSaveBtn();
	        
	    }

	    @Then("^user should be created successfully$")
	    public void user_should_be_created_successfully() throws Throwable 
	    {
	    pimPage.validatePersonalDetailspage();
	        
	    }
	    
//////////*******************************delete******************   
	    
	    @When("^click the check box of the employee click delete and click OK on the dialog window$")
	    public void click_the_check_box_of_the_employee_click_delete_and_click_ok_on_the_dialog_window() throws Throwable
	    {
	    	pimPage.clickpimBtn();
	    	
	        pimPage.clickchckBtn();
	       
	        pimPage.validatebtnDelete();
	        pimPage.validateModalDialog();
	        
	        Thread.sleep(1000);
	        
	        pimPage.clickokbtn();
	       
	        
	    }
	    

	    	@Then("user should be deleted successfully and message is displayed")
	    	public void user_should_be_deleted_successfully_and_message_is_displayed()  throws Throwable
	    	{
	    		 pimPage.validateSuccessfullydeleted();
	    		 pimPage.validaterowcount();
	    		 pimPage.logout();	   
	    	}

	        
}

	  

