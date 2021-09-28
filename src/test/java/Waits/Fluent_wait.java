package Waits;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Fluent_wait {
	
	WebDriver driver;
	
  @Test
  public void Implicit_Login_logout() throws Exception {
	  
	
	  Fluent_wait IW = new Fluent_wait();
	  IW.OprnChromeBrowser();
	  IW.OpenOrangeHRMURL();
	  IW.Login();
	  IW.Logout();
	  IW.CloseBrowser();
	  
  }
 public void OprnChromeBrowser() throws Exception {
	  
	  
	 driver=TestBrowser.OpenChromeBrowser();
	 
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	  
  }
 public void OpenOrangeHRMURL() throws Exception {
	  
	 String TestURL = "https://opensource-demo.orangehrmlive.com/";
	 driver.get(TestURL);
	  
	  
 }
 public void Login() throws Exception{
	 
	 findElement(By.id("txtUsername")).sendKeys("Admin");
	 findElement(By.id("txtPassword")).sendKeys("admin123");
	 findElement(By.id("btnLogin")).click();

 }
 public void Logout() throws Exception{
	  
	  findElement(By.id("welcome")).click();
	  
	  @SuppressWarnings("deprecation")
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(120, TimeUnit.SECONDS)
		       .pollingEvery(40, TimeUnit.SECONDS)
		       .ignoring(NoSuchElementException.class);
		   
		   WebElement Logout1 = wait.until(new Function<WebDriver,WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a"));
			     }
			   });
		
		findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a"));
		//*[@id="welcome-menu"]/ul/li[3]/a
		Logout1.click();
		//findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[2]/a")).click();
	
	 	  
	  
 }
 public void CloseBrowser() throws Exception{
	  
	 driver.quit();  
	  
	  
 }
 public  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		// draw a border around the found element
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
}
