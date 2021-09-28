package Emilable_Report;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Add_Jobs2_BeforeAndAfterTest {
	
	  WebDriver driver;
	  
			String URL="https://opensource-demo.orangehrmlive.com/";
			String Username="Admin", Password="admin123";
			String JobTitle="Tester2", JobDicription="Testerdiscription2";
			


			 
			
@BeforeTest	
			 
 public void OpenChromeBroser() throws Exception {
				  
	 driver=TestBrowser.OpenChromeBrowser();
	 Reporter.log("Pass-Open Chrome Browser");
			  
 }
 @Test		
public void Add_jobs(String URL,String Username, String Password,String JobTitle, String JobDicription ) throws Exception {
	 
	     OpenOrangeHRMURL(URL);		  
	     Login(Username,Password);
	    AddJobs(JobTitle,JobDicription );
		
 }
  		 
 @AfterTest	
			 
 public void CloseBrowser() throws Exception {
				  
	 driver.close();
      Reporter.log("Pass-Close Chrome Browser");
			  
 }
 public void OpenOrangeHRMURL(String URL) throws Exception {
	  
	driver.get(URL);
	 Reporter.log("Pass-Open OrangeHRM URL");
			
 }
  
 public void Login(String Username, String Password) throws Exception {
				  
	findElement(By.id("txtUsername")).sendKeys(Username);
	Reporter.log("Pass-Enter User Nmae");
		
	findElement(By.id("txtPassword")).sendKeys(Password);
	Reporter.log("Pass-Enter Password");
		
	findElement(By.id("btnLogin")).click();
	Reporter.log("Pass-Login");

		  
 }
 public void AddJobs(String JobTitle, String JobDicription) throws Exception {
				 
    findElement(By.linkText("Admin")).click();
	Reporter.log("Pass-Open Admin");
				
	findElement(By.linkText("Job")).click();
    Reporter.log("Pass-Go to jons");
				
    findElement(By.linkText("Job Titles")).click();
	Reporter.log("Pass-Go tojob titles");
				
	findElement(By.id("btnAdd")).click();
	Reporter.log("Pass-Add");
				
	 findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle);
	 Reporter.log("Pass-Enter Job title");
				
	 findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDicription);
	 Reporter.log("Pass-Enter job title dicription");
				
	findElement(By.id("btnSave")).click();
	Reporter.log("Pass-Save");
						
 }
 public   WebElement findElement(By by) throws Exception 
	{

	WebElement elem = driver.findElement(by);  
				
	if (driver instanceof JavascriptExecutor) 
	{
	 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
			 
	}
	return elem;
	}
}	
			
			  

