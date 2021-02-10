package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.BasePage;

public class PimPage extends BasePage
{
	
    @FindBy(xpath = "//*[@id='employee-information']/div[1]/h1") static WebElement empinfo;
    @FindBy(xpath = "//h1[text()='Add Employee']") static WebElement addEmpPage;
	 @FindBy(xpath = "//input[@id='btnAdd']") static WebElement addBtn;
	@FindBy(linkText = "Employee List") static WebElement employeeList;
	
	 @FindBy(xpath = "//input[@id='firstName']") static WebElement firstnameTxtbox;
	 @FindBy(id="lastName") static WebElement lastNameTxtbox;
	 @FindBy(id="btnSave") static WebElement saveBtn;
	 @FindBy(name="chkSelectRow[]") static WebElement chckBtn;
	 @FindBy(xpath = "//input[@id='btnDelete']") static WebElement deletebtn;
	 @FindBy(id="dialogDeleteBtn") static WebElement dialogOkBtn;   //OK button
	@FindBy(xpath  = "//h1[text()='Personal Details']") static WebElement personalDetailstxt;
	@FindBy(id="searchBtn") static WebElement searchBtn;
	@FindBy(id="menu_pim_viewPimModule") public WebElement pimlink;
	@FindBy(xpath = "//*[@id='menu_pim_viewPimModule']/b") static WebElement pimbtn;
	
	@FindBy(xpath = "//*[@id='deleteConfModal']") static WebElement modalDialogBox;
	
	@FindBy(xpath ="//div[@class='message success fadable']" ) static WebElement deleteSuccessMessage;
	
	@FindBy(id="welcome") static WebElement welcome;
	@FindBy(linkText="Logout") static WebElement signout;
	
	@FindBy(xpath = "//input [@id='empsearch_id']") static WebElement searchidtxtbx;
	@FindBy(id = "searchBtn" )static WebElement searchbtn;
	
	
	public void initialise()
		{
			
		    PageFactory.initElements(driver,this);
		}
		
		public void validateEmployeeinfoPage()
		{
			if(empinfo.isDisplayed())
			{
				testlog=ext.createTest("Employee information page");
				testlog.log(Status.PASS,"Employee information page is displayed");
				takescreenshot("employeeInfoPage.png");
			}else
			{
				testlog=ext.createTest("Employee information page");
				testlog.log(Status.FAIL,"Employee information page is NOT displayed");
				takescreenshot("employeeInfoPage.png");
			}
		}
		
		public void validateAddEmployee()
		{
			
			String addemp=addEmpPage.getText();
			if(addemp.matches("Add Employee"))
			{
				testlog=ext.createTest("Add Employee page");
				testlog.log(Status.PASS,"Add Employee page is displayed");
				takescreenshot("addemployeePage.png");
			}else
			{
				testlog=ext.createTest("Add Employee page");
				testlog.log(Status.FAIL,"Add Employee page is NOT displayed");
				takescreenshot("addemployeePage.png");
			}
		}
		
		
				
public void clickpimlink()
{
	pimlink.click();
}
		public void clickpimBtn()
		{		
			pimbtn.click();

		}
    public void clickEmployeeList()
    {
	employeeList.click();
     }

		public void clickaddBtn()
	    {
			//addBtn.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@id='btnAdd']")));
			
         
	    }
         
	    
	    
	    public void enterFirstname(String fn) 
		{
	    	firstnameTxtbox.sendKeys(fn);
			
		}
	    
	    public void enterLastname(String ln) 
		{
	    	lastNameTxtbox.sendKeys(ln);	    		    		
		}
	    
	    
	    public void clickSaveBtn()
	    {

	    	saveBtn.click();

	    }
	    
	     public int rowcount3 ;
	     public int rowcount2 ;
	     
	     public void clickchckBtn()
	    {
	    	 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    	 List<WebElement> rows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
             int rowcount1 = rows.size(); 
             rowcount2 =rowcount1;
	    	 //String fname,lname;
	    	int r;
	    	String fnamebeforexpath="//table[@id='resultTable']/tbody/tr[";
	    	String fnameafterxpath="]/td[3]";
	    	
	    	String lnamebeforexpath="//table[@id='resultTable']/tbody/tr[";
	    	String lnameafterxpath="]/td[4]";
	    	
	    	
	    	 for(r=1;r<=rows.size();r++)
	    	 {
	    		String actualfname=fnamebeforexpath+r+fnameafterxpath;
	    		String firstname=driver.findElement(By.xpath(actualfname)).getText();
	    		
	    		String actuallname=lnamebeforexpath+r+lnameafterxpath;
	    		String lastname=driver.findElement(By.xpath(actuallname)).getText();
	    		
	    	  // fname=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr["+r+"]/td[3]")).getText();
	    	 // lname= driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr["+r+"]/td[4]")).getText();
	    	 
	    		if(firstname.equals(prop.getProperty("firstname")) && lastname.equals(prop.getProperty("lastname")))
	    	  {
	    	   driver.findElement(By.xpath("(//input[@name='chkSelectRow[]'])["+(r)+"]")).click();
	    	 break;
	    	  }
	    	 }

	    }	
	     
	    

	     public void validatebtnDelete() {
		  
			if(deletebtn.isEnabled())
			{
				testlog=ext.createTest("deletebutton");
				testlog.log(Status.PASS, "delete button enabled after selecting");
				takescreenshot("deletebtn.png");
			}
			else 
			{
				testlog=ext.createTest("deletebutton");
				testlog.log(Status.FAIL,"delete button is not enabled");
				takescreenshot("deletebtn.png");
			}
			
				
			deletebtn.click();
			
			
		    
		}

		public void validateModalDialog()
		{
			
			if(modalDialogBox.isDisplayed())
			{
			testlog=ext.createTest("delete confirm dialog box");
			testlog.log(Status.PASS, "confirmation required dialog box is displayed");
			takescreenshot("deleteconfirmation.png");
			}
			else
			{
				testlog=ext.createTest("delete confirm dialog box");
				testlog.log(Status.FAIL, "confirmation required dialog box is displayed");
				takescreenshot("deleteconfirmation.png");
			}
			
		}

		public void clickokbtn() 
		{  
		
			dialogOkBtn.isEnabled();
		
		   dialogOkBtn.click();
			
		   
		   List<WebElement> rows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
           rowcount3 = rows.size(); 
           
		}
		
		public void validaterowcount()
		{
			if (rowcount2>rowcount3)
			{
				testlog=ext.createTest("Delete employee");
				testlog.log(Status.PASS,"Row count validation successfull ");
			}
			else
			{
				testlog=ext.createTest("Delete employee");
			testlog.log(Status.FAIL,"Row count validation NOT successfull ");
			}
		}
		
		
		
	     
		public void clickSearch()
		{
			searchBtn.click();
		}

		

		public void validatePersonalDetailspage() {
			personalDetailstxt.isDisplayed();
	    	String text= personalDetailstxt.getText();
	    	if(text.matches("Personal Details"))
	    	{
	    		testlog=ext.createTest("Personaldetailspage");
	    		testlog.log(Status.PASS, "Employee is added");
	    		takescreenshot("personaldetailspage.png");
	    	}else
	    	{
	    		testlog=ext.createTest("Personaldetailspage");
	    		testlog.log(Status.FAIL, "Employee is NOT added");
	    		takescreenshot("personaldetailspage.png");
	    	}
	    	}
	    	
	    	
	    	public void validateSuccessfullydeleted()
			{
	    		
				if(deleteSuccessMessage.isDisplayed())
				{
				testlog=ext.createTest("Delete employee");
				testlog.log(Status.PASS,"successfully deleted message is displayed");
				takescreenshot("Successfully Deleted.png");
				}
				else
				{
					testlog=ext.createTest("Delete employee");
					testlog.log(Status.FAIL,"successfully deleted message is NOT displayed");
					takescreenshot("Successfully Deleted.png");
					}
								
			
			}

	    	public void logout()
	    	{
	    		try
	    		{
	    		if(welcome.isDisplayed())
	    		{
	    			welcome.click();
	    			try
	    			{Thread.sleep(2000);}catch(Exception e) {}
	    			signout.click();
	    			try {Thread.sleep(3000);}catch(Exception e) {}
	    		}
	    		}catch(Exception e) {System.out.println("Not is dashboard page to  logout");}
	    	
		}

	    	
	    	
	    public void entersearchid()
	    {
	    	searchidtxtbx.clear();
	    	searchidtxtbx.sendKeys(prop.getProperty("searchid"));
	    }
	    

public void validateSearchid()
{
	
	int rows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr")).size();
	 int columns=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td")).size();
	 int r,c;
 
 	 for(r=1;r<=rows;r++)
 	 {
 		for(c=1;c<=columns;c++)
 	 	 {
		String id=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+r+"]/td["+c+"]")).getText();
		
		
	if (id.matches(prop.getProperty("searchid")))
	{
		testlog=ext.createTest("searchid");
		testlog.log(Status.PASS, "search with id results matching");
		takescreenshot("searchid.png");
		break;
	}
	System.out.print(id+"  ");
	
 	 } 		
 		System.out.println();
 	 }
 	 
 	 }


}