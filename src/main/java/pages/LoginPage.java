package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.BasePage;



public class LoginPage extends BasePage
{

	@FindBy(name="txtUsername") static WebElement username;
	@FindBy(name="txtPassword") static WebElement password;
	@FindBy(name="Submit")  static WebElement signin;
	@FindBy(id="spanMessage") static WebElement errmsg;
	@FindBy(xpath="//h1[text()='Dashboard']") static WebElement dashboard;
	@FindBy(id="welcome") static WebElement welcome;
	@FindBy(linkText="Logout") static WebElement signout;
	
	public void init()
	{		
		PageFactory.initElements(driver,this);		
	}
	
	public void openurl()
	{
		driver.get(prop.getProperty("url"));
	}
	
	public void validate_loginpage()
	{
		String title=driver.getTitle();
		if(title.matches("OrangeHRM"))
		{
			testlog=ext.createTest("LoginPage");
			testlog.log(Status.PASS, "login page is displayed");
			takescreenshot("loginpage.png");
		}
		else
		{
			testlog=ext.createTest("LoginPage");
			testlog.log(Status.FAIL, "login page NOT displayed");
			takescreenshot("loginpage.png");
		}			
	}
	
	public void validlogin()
	{
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		signin.click();
		try {Thread.sleep(5000);}catch(Exception e) {}
	}
	
	public void validatedashboardpage()
	{
		if(dashboard.isDisplayed())
		{
			testlog=ext.createTest("DashBoardPage");
			testlog.log(Status.PASS, "DashBoardPage is displayed");
			takescreenshot("dashboard.png");
		}
		else
		{
			testlog=ext.createTest("DashBoardPage");
			testlog.log(Status.FAIL, "DashBoardPage NOT displayed");
			takescreenshot("dashboard.png");
		}
	}
	public void logout()
	{
		try
		{
		if(welcome.isDisplayed())
		{
			welcome.click();
			try {Thread.sleep(2000);}catch(Exception e) {}
			signout.click();
			try {Thread.sleep(3000);}catch(Exception e) {}
		}
		}catch(Exception e) {System.out.println("Not is dashboard page to  logout");}
	}
	public void invalidlogin(String userid,String pwd)
	{	
		username.sendKeys(userid);
		password.sendKeys(pwd);
		signin.click();
		try {Thread.sleep(2000);}catch(Exception e) {}
		if(errmsg.isDisplayed())
		{
			testlog=ext.createTest("InvalidLogin");
			testlog.log(Status.INFO, "Login is Failed");
			takescreenshot("loginfail.png");
		}
		else
		{
			validatedashboardpage();
			logout();
		}
					
	}


	public void errorMessage() {
		String message = errmsg.getText();
		System.out.println(message);
		
	}
}
