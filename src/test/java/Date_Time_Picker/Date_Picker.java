package Date_Time_Picker;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Date_Picker {
	
	 static WebDriver driver;
  @Test
  public void Leaves() throws Exception  {
	  
	  driver = TestBrowser.OpenChromeBrowser();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		
		findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();
		
		findElement(By.linkText("Leave")).click();
		findElement(By.linkText("Leave List")).click();
		
		driver.findElement(By.xpath("//*[@id='frmFilterLeave']/fieldset/ol/li[1]/img")).click();
		
		Select dropdown1 = new Select(findElement(By.className("ui-datepicker-month")));
		 dropdown1.selectByVisibleText("Oct");
		 
		 Select listbox6 =new Select(driver.findElement(By.className("ui-datepicker-year")));
	 	 listbox6.selectByVisibleText("2019");
		
	 	String str2="//*[text()='" + 25 +"']";
	 	
	 	findElement(By.xpath(str2)).click();
		
		//String str2="//*[contains(@href,'#') and text()='" + 25 +"']";
	 	
	 	//Actions act1 = new Actions(driver);
	 //	WebElement date2=findElement(By.xpath(str2));
	 	//act1.moveToElement(date2).click().build().perform();
	 
	 	
	 	driver.findElement(By.xpath("//*[@id=\'frmFilterLeave\']/fieldset/ol/li[2]/img")).click();
		
	 	Select dropdown = new Select(findElement(By.className("ui-datepicker-month")));
		 dropdown.selectByVisibleText("Nov");
		 
		 Select listbox =new Select(driver.findElement(By.className("ui-datepicker-year")));
	 	 listbox.selectByVisibleText("2019");
	 	 

	 	 String str3="//*[text()='" + 26 +"']";
	 	findElement(By.xpath(str3)).click();
	 	
	 	findElement(By.id("btnSearch")).click();
		
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
