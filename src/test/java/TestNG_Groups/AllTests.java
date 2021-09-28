package  TestNG_Groups;
import CommonUtil.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;
public class AllTests
{
	WebDriver driver;
	
	@Test(groups = { "Login" })
	
	 public void Login1( ) throws Exception { 
	
		driver = TestBrowser.OpenChromeBrowser();
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click(); 
		  
	  }
	  
	
	@Test(groups = { "AddSkills" })
public void Add_Skills() throws Exception {
	  
	
		driver = TestBrowser.OpenChromeBrowser();
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();
	   
		  
		
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys("Autocad2");
		findElement(By.id("skill_description")).sendKeys("Autocad discriptio2");
		findElement(By.id("btnSave")).click();
		
		
	
		  
  }
	
	
	@Test(groups = { "AddNationalities" })
	 public void Add_Nationalities() throws Exception  {
		
		driver = TestBrowser.OpenChromeBrowser();
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();
	    
		  
		  findElement(By.id("menu_admin_viewAdminModule")).click();
		  findElement(By.id("menu_admin_nationality")).click();
		  findElement(By.id("btnAdd")).click();
		  findElement(By.id("nationality_name")).sendKeys("Indian");
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












