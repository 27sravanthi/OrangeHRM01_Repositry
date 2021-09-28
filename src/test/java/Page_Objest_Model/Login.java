package Page_Objest_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login {
	
	WebDriver driver;
	
	String Username="admin", Password="admin123";
	
	public void Loginpage(WebDriver driver)
	{
		this.driver = driver;
	}
	
  @Test
 public void Login1(String Username, String Password ) throws Exception {
	  
	  findElement(By.id("txtUsername")).sendKeys(Username);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
	  
	 
	  
  }
  


public  WebElement findElement(By by) throws Exception {
	
    WebElement elem = driver.findElement(by);
    
    if (driver instanceof JavascriptExecutor) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
       
    }
    return elem;   
	  
	  
}  
	  
  
}
