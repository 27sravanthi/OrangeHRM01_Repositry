package Priority;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Priority1 {
	WebDriver driver;
	
  @Test(priority=1)
  public void Open_chrome_browser()throws Exception  {
	  
	    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
	    
  }
  @Test(priority=2)
  public void Open_OrangeHRM_URL()throws Exception  {
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	    
  }
  @Test(priority=3)
  public void Login()throws Exception  {
	  
	    findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();
  } 
  @Test(priority=4)
  public void Admin()throws Exception  {
	  
	    findElement(By.id("menu_admin_viewAdminModule")).click();
  }
  @Test(priority=5)
  public void Qualification()throws Exception  {    
	    	
	
		findElement(By.id("menu_admin_Qualifications")).click();
}
  @Test(priority=6)
public void Add_skills()throws Exception  {    
	
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys("Autocad4");
		findElement(By.id("skill_description")).sendKeys("Autocad discriptio3");
		findElement(By.id("btnSave")).click();
		
	  
  }

  public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
		
	}
}
