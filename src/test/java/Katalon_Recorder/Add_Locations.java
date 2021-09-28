package Katalon_Recorder;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Add_Locations {
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
  @Test
  public void AddLocations() throws Exception {
	  
		    driver=TestBrowser.OpenChromeBrowser();
		    driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		    
		    driver.findElement(By.xpath("//div[@id='divUsername']/span")).click();
		    driver.findElement(By.id("txtUsername")).clear();
		    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		    
		    driver.findElement(By.id("txtPassword")).click();
		    driver.findElement(By.id("txtPassword")).clear();
		    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		    
		    driver.findElement(By.id("btnLogin")).click();
		    
		    driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
		    driver.findElement(By.id("menu_admin_Organization")).click();
		    driver.findElement(By.id("menu_admin_viewLocations")).click();
		    driver.findElement(By.id("btnAdd")).click();
		    
		    driver.findElement(By.id("location_name")).click();
		    driver.findElement(By.id("location_name")).clear();
		    driver.findElement(By.id("location_name")).sendKeys("BHEL1");
		    
		    driver.findElement(By.id("location_country")).click();
		    new Select(driver.findElement(By.id("location_country"))).selectByVisibleText("India");
		    driver.findElement(By.id("location_country")).click();
		    
		    driver.findElement(By.id("location_province")).clear();
		    driver.findElement(By.id("location_province")).sendKeys("Telangana");
		    
		    driver.findElement(By.id("location_city")).click();
		    driver.findElement(By.id("location_city")).clear();
		    driver.findElement(By.id("location_city")).sendKeys("Hyderbad");
		    
		    driver.findElement(By.id("btnSave")).click();
		


  }
  
  
  
  
  
}
