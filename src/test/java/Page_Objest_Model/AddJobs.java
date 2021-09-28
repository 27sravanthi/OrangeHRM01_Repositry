package Page_Objest_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddJobs {
	
	  WebDriver driver;
	  
			
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
