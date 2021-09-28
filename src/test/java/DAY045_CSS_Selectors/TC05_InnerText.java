package  DAY045_CSS_Selectors;
import CommonUtil.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

public class TC05_InnerText
{
	static WebDriver driver;
	
	

	@Test
	public void Test2() throws Exception {
	
		driver = TestBrowser.OpenChromeBrowser();
		
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
	
		//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
		//css=<HTML tag><:><contains><(text)>
		//WebElement cell = driver.findElement(By.cssSelector("td:contains('Item 1')"));
		
		//WebElement cell = driver.findElement(By.cssSelector("td[innerText='Item 1']"));
		//WebElement cell = driver.findElement(By.cssSelector("td[textContent='Item 1']"));
		//css=a[text='Log Out'] or a[innertext='Log Out']
		
		findElement(By.cssSelector("input[id^='txtUser']"));
		findElement(By.cssSelector("input[id$='Password']"));
		//findElement(By.cssSelector("a[innerText='Forgot your password?'] "));
		
		//String str="#forgotPasswordLink > a";
		
		//findElement(By.cssSelector(str));
		
		
		//https://subscription.packtpub.com/book/web_development/9781849515740/1/ch01lvl1sec16/locating-elements-using-text
		//WebElement cell = driver.findElement(By.cssSelector("td[innerText='Item 1']"));
		//WebElement cell = driver.findElement(By.cssSelector("td[textContent='Item 1']"));
		
		String s1="a:contains('Forgot your password?')";
		String str="a[innerText='Forgot your password?']";
		String str1="a[textContent='Forgot your password?']";
		String str2="a[text='Forgot your password?']";
		String str3="a[innertext='Forgot your password?']";
		String str4="a:contains(Forgot your password?)";
		
		String css1="a:contains('Forgot your password?')";
		
	  String str5="a:(*'Forgot your password?'*)";
	  
	  //css=a[text='Log Out'] or a[innertext='Log Out']
		
		findElement(By.cssSelector(css1));
		
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











