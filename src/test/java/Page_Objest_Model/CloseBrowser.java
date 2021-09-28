package Page_Objest_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CloseBrowser {
	
	WebDriver driver;
	
	public void CloseBrowserpage(WebDriver driver)
	{
		this.driver = driver;
	}
	
  @Test
  public void Close_Browser() throws Exception{
	  
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
