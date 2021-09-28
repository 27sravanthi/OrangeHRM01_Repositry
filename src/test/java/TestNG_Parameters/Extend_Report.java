package TestNG_Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonUtil.TestBrowser;
import Day_009_Extent_Reports.ExtentReport;
import ExcelUtil.ExcelApiTest4;

public class Extend_Report {

	static WebDriver driver;
	public static int iRow = 0;
    
    
     ExtentTest logger;
	 ExtentReports extent; 
	 String screenShotPath;
	 public static String TestScriptName = "Add_Jobs_Extend_Report";
	 public static String TestName;
  
    
	@Parameters({"Browser1"})
	@BeforeTest
	public void OpenchromeBrowser(String Browser) throws Exception {

		if (Browser.equalsIgnoreCase("Chrome")) {
			driver = TestBrowser.OpenChromeBrowser();
		   
		}

		else if (Browser.equalsIgnoreCase("FireFox")) {
			driver = TestBrowser.OpenFirefoxBrowser();
		}

		else if (Browser.equalsIgnoreCase("IE")) {
			driver = TestBrowser.OpenIEBrowser();
		} 
		else {
			driver = TestBrowser.OpenChromeBrowser();
			System.out.println("Chrome Browser started :" + Browser);
		}

	}
	@DataProvider(name ="AddJobs")
	public static Object[][] Authentication1() throws Exception {
	
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C:\\HTML Report\\OrangeHRM6\\Add_jobs.xlsx","Sheet2");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
@Test(dataProvider="AddJobs")
	public void Login(String URL, String Username, String Password,String JobTitle, String JobDiscription ) throws Exception {
		
	if (iRow==0)
	{
		 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
		 Date now = new Date();
		 String strDate = sdfDate.format(now);
		 
		 TestName=TestScriptName+"_"+strDate+".html";
		 TestScriptName=TestScriptName+"_"+strDate;
		  String TestHtmlName="C:/HTML Report/test-output/ExtentReportScreenShots/"+ TestScriptName +"/"+TestName;
		  
		 //String TestHtmlName=TestName;
		 ExtentHtmlReporter reporter=new ExtentHtmlReporter(TestHtmlName);
		 
		 System.out.println("Html Report path is : "+TestHtmlName);
		 
		 extent=new ExtentReports();
		 extent.attachReporter(reporter);
		 logger=extent.createTest(TestName);
		
		
		iRow=iRow+1;
		Login(URL,Username,Password);
		AddJobDetails(JobTitle,JobDiscription );
		
	}
	
	else
	{
		
		iRow=iRow+1;
		AddJobDetails(JobTitle,JobDiscription );
	}
	
  }
  @AfterTest
	public  void CloseBrowser() throws Exception {

		driver.close();
	    

	}
  public void Login(String URL, String Username,String Password) throws Exception {
		
	    driver.get(URL);
	    screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Opened Orange HRM URL",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
	   
	    
	    findElement(By.id("txtUsername")).sendKeys(Username);
	    screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - Entered user Name",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		

		findElement(By.id("txtPassword")).sendKeys(Password);
		screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - Entered Paasword",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		

		findElement(By.id("btnLogin")).click();
		screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page -Clicked on Login",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		

	
	}
  
  public void AddJobDetails(String JobTitle ,String JobDiscription) throws Exception {
		

	   findElement(By.linkText("Admin")).click();
	   screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Add Jobs - Clicked on Admin",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		

       findElement(By.linkText("Job")).click();
       screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Add Jobs - Clicked on Job",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		

       findElement(By.linkText("Job Titles")).click();
       screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Add Jobs - Clicked on JobTitle",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		

       findElement(By.id("btnAdd")).click();
       screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - Clicked on add",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		

       findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle);
       screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Add Jobs - Entered JobTitle",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		

       findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDiscription);
       screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - Entered JobDiscription",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		

       findElement(By.id("btnSave")).click();
       screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - Clicked on Save ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		extent.flush();


	}
	
	public static WebElement findElement(By by) throws Exception {

		WebElement elem = driver.findElement(by);

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);

		}
		return elem;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
