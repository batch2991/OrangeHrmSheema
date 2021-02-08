package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import com.aventstack.extentreports.Status;

import base.BasePage;

public class DashboardPage extends BasePage
{
public void init() 
{	
	PageFactory.initElements(driver,this);
}



@FindBy(id="menu_admin_viewAdminModule") static WebElement adminLink;
@FindBy(xpath = "//*[@id='systemUser-information']/div[1]/h1") static WebElement SystemUsersPage;
@FindBy(name = "searchSystemUser[userName]")static WebElement usernameTxtBx;
@FindBy(name = "searchSystemUser[userType]" )static WebElement role;
@FindBy(id = "searchBtn" )static WebElement searchbtn;
@FindBy(id = "resetBtn") static WebElement resetbtn;

public void clickAdmin()
{
	adminLink.click();
}

public void clickReset()
{
	resetbtn.click();
}


public void validateSysUsersPage()
{
	String sysUsers=SystemUsersPage.getText();
	if (sysUsers.matches("System Users"))
	{
		testlog=ext.createTest("SystemUsersPage");
		testlog.log(Status.PASS, "SystemUsersPage is displayed");
		takescreenshot("SystemUsersPage.png");
	}
	else
	{
		testlog=ext.createTest("SystemUsersPage");
	    testlog.log(Status.FAIL,"SystemUsersPage is NOT displayed");
	    takescreenshot("SystemUsersPage.png");
	}
}
public void enterUsername(String username)
{
	usernameTxtBx.sendKeys(username);
}

public void selectRole()
{
	
	Select select=new Select(role);
	select.selectByVisibleText("Admin");
}

public void clickSearch()
{
	searchbtn.click();
}
public void validateUsername()
{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	 List<WebElement> rows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
	 int r;
 	String unamebeforexpath="//table[@id='resultTable']/tbody/tr[";
 	String unameafterxpath="]/td[2]";
 	
 	
 	 for(r=1;r<=rows.size();r++)
 	 {
 		String actualuname=unamebeforexpath+r+unameafterxpath;
		String username=driver.findElement(By.xpath(actualuname)).getText();
	
	if (username.matches(prop.getProperty("uname")))
	{
		testlog=ext.createTest("searchUsername");
		testlog.log(Status.PASS, "serch results matching");
		takescreenshot("searchUsername.png");
	}
	else
	{
		testlog=ext.createTest("searchUsername");
	    testlog.log(Status.FAIL,"search results not matching");
	    takescreenshot("searchUsername.png");
	}
 	 }
}

public void validaterole()
{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	 List<WebElement> rows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
	 int r;
	 
	 String rolebeforexpath="//table[@id='resultTable']/tbody/tr[";
	 	String roleafterxpath="]/td[3]";
	 for(r=1;r<=rows.size();r++)
 	 {
		 String actualrole=rolebeforexpath+r+roleafterxpath;
			String role=driver.findElement(By.xpath(actualrole)).getText();

	
	if (role.matches(prop.getProperty("role")))
	{
		testlog=ext.createTest("searchRole");
		testlog.log(Status.PASS, "search results matching role");
		takescreenshot("searchRole.png");
	}
	else {
		testlog=ext.createTest("searchRole");
	    testlog.log(Status.FAIL,"search results not matching role");
	    takescreenshot("searchRole.png");
	     }
    }

}
	 }
