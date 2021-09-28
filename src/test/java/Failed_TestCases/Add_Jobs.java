package Failed_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Add_Jobs {
	
	  WebDriver driver;
	  
			String URL="https://opensource-demo.orangehrmlive.com/";
			String Username="Admin", Password="admin123";
			String JobTitle="Tester1", JobDicription="Testerdiscription1";
			
			 public   WebElement findElement(By by) throws Exception 
				{

					WebElement elem = driver.findElement(by);  
					
					if (driver instanceof JavascriptExecutor) 
					{
					 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
				 
					}
					return elem;
					
				}
				
 @Test		
  public void Add_jobs() throws Exception {
	  
	  Add_Jobs A1= new Add_Jobs();
	  
	   A1.OpenChromeBroser();
	   A1.OpenOrangeHRMURL(URL);
	   A1.Login(Username,Password );
	   A1.AddJobs(JobTitle, JobDicription );
	   
  }
  
  public void OpenChromeBroser() throws Exception {
	  
	  driver=TestBrowser.OpenChromeBrowser();
	  Reporter.log("Pass-Open Chrome Browser");
  
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
			 
			 driver.close();
			 

	
		  
	  }

  
}
