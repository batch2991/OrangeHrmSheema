package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage
{
	
	 public static WebDriver driver;
	 public static Properties prop;
	 public static ExtentHtmlReporter htmlreport;	//location to save the report,heading,title,backgroundcolor,graph,,,etc
	 public static ExtentReports ext;
	 public static ExtentTest testlog;
	 
	 @BeforeSuite
	 public void initialize()
	 {
	    	System.out.println("Before the Suite and driver set up,initialise");
	    	
	    	 prop=new Properties();
		        try {
		        prop.load(new FileInputStream("C:\\sheema\\eclipse\\OrangeHRM\\src\\main\\java\\config\\data.properties"));
		        }catch(Exception e) {}
		        
		    if(prop.getProperty("browsername").matches("firefox"))
		    {
		    	WebDriverManager.firefoxdriver().setup();
		    	driver=new FirefoxDriver();
		    }
		    if(prop.getProperty("browsername").matches("chrome"))
		    {
		    	WebDriverManager.chromedriver().setup();
		    	driver=new ChromeDriver();
		    }
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	        
	        
	       
	        htmlreport = new ExtentHtmlReporter(prop.getProperty("reportlocation")+"\\orangehrm.html");
			ext = new ExtentReports();
			ext.attachReporter(htmlreport);
			ext.setSystemInfo("Host Name", "sheema-sysname");
			ext.setSystemInfo("Environment", "Test Env");
			ext.setSystemInfo("User Name", "sheema-testername");
			   
			htmlreport.config().setDocumentTitle("OrangeHRM");
			htmlreport.config().setReportName("OrangeHRM Functional Testing");
			htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlreport.config().setTheme(Theme.STANDARD);
	 }
	 
	 public void takescreenshot(String imagename)
	 {
			try
			{		
			 File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(f, new File(prop.getProperty("screenshots")+imagename));
			 testlog.addScreenCaptureFromPath(prop.getProperty("screenshots")+imagename);
			}catch(Exception e) {}
	 }
	 
	 @AfterSuite
	 public void teardown()
	 {

	        driver.quit();
	        ext.flush();
	        try 
	        { Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
	        }catch(Exception e) {}
	 }
}
