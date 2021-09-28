package Priority;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Priority2 {
	WebDriver driver;
	
  @Test
  public void Test1_Open_chrome_browser()throws Exception  {
	  
	    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
	    
  }
  @Test
  public void Test2_Open_OrangeHRM_URL()throws Exception  {
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	    
  }
  @Test
  public void Test3_Login()throws Exception  {
	  
	    findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();
  } 
  @Test
  public void Test4_Admin()throws Exception  {
	  
	    findElement(By.id("menu_admin_viewAdminModule")).click();
  }
  @Test
  public void Test5_Qualification()throws Exception  {    
	    	
	
		findElement(By.id("menu_admin_Qualifications")).click();
}
  @Test
public void Test6_Add_skills()throws Exception  {    
	
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys("Autocad3");
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
