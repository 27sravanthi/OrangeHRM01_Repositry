package  DAY045_CSS_Selectors;
import CommonUtil.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

public class TC03_Attribute
{
	static WebDriver driver;

	@Test
	public void Test2() throws Exception {
	
		driver = TestBrowser.OpenChromeBrowser();
		
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		//css=<HTML tag><[attribute=Value of attribute]>
		//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
		
		findElement(By.cssSelector("input[id='txtUsername']")).sendKeys("Admin");
		findElement(By.cssSelector("input[id='txtPassword']")).sendKeys("admin123");
		findElement(By.cssSelector("input[id='btnLogin']")).click();
		
	
		
	}
	
	
	

public  WebElement findElement(By by) throws Exception 
{

	WebElement elem = driver.findElement(by);  
	
	if (driver instanceof JavascriptExecutor) 
	{
	 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
 
	}
	return elem;
}

	
	
}











