package  DAY045_CSS_Selectors;
import CommonUtil.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

public class TC04_Sub_string
{
	static WebDriver driver;

	@Test
	public void Test2() throws Exception {
	
		driver = TestBrowser.OpenChromeBrowser();
		
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
	
		//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
		//css=<HTML tag><[attribute^=prefix of the string]>
		//css=<HTML tag><[attribute$=suffix of the string]>
		//css=<HTML tag><[attribute*=sub string]>

		//css=input#Passwd[name^='Pass']
		//css=input#Passwd[name$='wd']
		//css=input#Passwd[name*='wd']
		
		

		
		findElement(By.cssSelector("input[id^='txtUser']")).sendKeys("Admin");
		findElement(By.cssSelector("input[id$='Password']")).sendKeys("admin123");
		findElement(By.cssSelector("input[id*='Login']")).click();
		
	
		
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











