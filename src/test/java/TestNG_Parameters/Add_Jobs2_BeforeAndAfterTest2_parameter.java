package TestNG_Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Add_Jobs2_BeforeAndAfterTest2_parameter {
	
	  WebDriver driver;
	  
			
			
			 public   WebElement findElement(By by) throws Exception 
				{

					WebElement elem = driver.findElement(by);  
					
					if (driver instanceof JavascriptExecutor) 
					{
					 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
				 
					}
					return elem;
					
				}
			@Parameters({"Browser1"})
			 @BeforeTest	
			 
			 public void OpenChromeBroser(String Browser) throws Exception {
				  
				 if(Browser.equalsIgnoreCase("Chrome"))
					{
						driver = TestBrowser.OpenChromeBrowser();
				    }

					if(Browser.equalsIgnoreCase("FireFox"))
					{
						driver = TestBrowser.OpenFirefoxBrowser();
					}
					
			 }
		 @Parameters({"Username","Password","JobTitle","JobDiscription"})
        @Test		
  public void Add_jobs(String Username, String Password, String JobTitle, String JobDiscription) throws Exception {
	  
	 
	        driver.get("https://opensource-demo.orangehrmlive.com/");
	        Reporter.log("Pass-Open OrangeHRM URL");

  
		    findElement(By.id("txtUsername")).sendKeys(Username);
			Reporter.log("Pass-Enter User Nmae");

			findElement(By.id("txtPassword")).sendKeys(Password);
			Reporter.log("Pass-Enter Password");

			findElement(By.id("btnLogin")).click();
			Reporter.log("Pass-Login");

	
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

	        findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDiscription);
		    Reporter.log("Pass-Enter job title dicription");

	        findElement(By.id("btnSave")).click();
		    Reporter.log("Pass-Save");
		
	  }
 
 @AfterTest	
 
 public void CloseBrowser() throws Exception {
	  
	 driver.close();
	 Reporter.log("Pass-Close Chrome Browser");
  
 }

  
}
