package Page_Objest_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Logout {
	
	WebDriver driver;
	
	
	public void Logout(WebDriver driver)
	{
		this.driver = driver;
	}
  @Test
  public void Logout1() throws Exception{
	  
	  findElement(By.id("welcome")).click();
	  
	  WebDriverWait wait=  new WebDriverWait(driver,60);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout"))) ;
	
	  findElement(By.linkText("Logout")).click();
	 	  
	  
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

