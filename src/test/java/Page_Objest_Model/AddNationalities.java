package Page_Objest_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AddNationalities {
	WebDriver driver;
	
	public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
	
	public void AddNationalities(WebDriver driver)
	{
		this.driver = driver;
	}
  @Test
  
  
  public void Add_Nationalities() throws Exception  {
	  
	  findElement(By.id("menu_admin_viewAdminModule")).click();
	  findElement(By.id("menu_admin_nationality")).click();
	  findElement(By.id("btnAdd")).click();
	  findElement(By.id("nationality_name")).sendKeys("Indian");
	  findElement(By.id("btnSave")).click();
	  
	
  }
  
  
  
  
  
  
  
  
}
