package Frames;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Swith_Into_Frame_By_Index {
	
	static WebDriver driver;
	
	
	
	
  @Test
  public void f() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
		driver.get("http://www.bhavasri.com/Frames/AllContacts.html");

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Numnber of frames: " + frames.size());
		
		//int count=frames.size();
		
		driver.switchTo().frame(frames.get(0));
		findElement(By.name("firstname")).sendKeys("Selenium");
		findElement(By.name("lastname")).sendKeys("Sudhakar");
		findElement(By.name("subject1")).sendKeys("Selenium Sudhakar");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(frames.get(1));
		findElement(By.name("firstname")).sendKeys("Ramu");
		findElement(By.name("lastname")).sendKeys("TCS");
		findElement(By.name("subject")).sendKeys("Ramu TCS");
		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
		
		driver.switchTo().frame(frames.get(0));
		findElement(By.name("firstname")).clear();
		findElement(By.name("firstname")).sendKeys("Dharmaja");
		
		findElement(By.name("lastname")).clear();
		findElement(By.name("lastname")).sendKeys("Selenium Trainer");
		
		findElement(By.name("subject1")).clear();
		findElement(By.name("subject1")).sendKeys("Dharamja - Selenium Trainer");
		
		driver.quit();
		
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


