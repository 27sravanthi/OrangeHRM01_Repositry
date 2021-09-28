package Page_Objest_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddLocations {
	
	 WebDriver driver;
	
   
	String LocationName="KPHB600",LocationState="Telangana",LocationCity="Hyderabad";
	
	
 
  
  public  WebElement findElement(By by) throws Exception {
		
	    WebElement elem = driver.findElement(by);
	    
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	       
	    }
	    return elem; 
	} 
  @Test
 
  public void AddLocations(String LocationName, String LocationCity,String LocationaState) throws Exception{
	  
	  findElement(By.id("menu_admin_viewAdminModule")).click();
	  findElement(By.id("menu_admin_Organization")).click();
	  findElement(By.id("menu_admin_viewLocations")).click();
	  findElement(By.id("btnAdd")).click();
	  findElement(By.id("location_name")).sendKeys(LocationName);
	  
	  
	 // Select dropdown1 = new Select(findElement(By.id("location_country")));
	 // dropdown1.selectByVisibleText(LocationCountry);
	  
	  //Select dropdown1 = new Select(findElement(By.id("location_country")));
	  //dropdown1.selectByIndex(120);
	  
	 Select dropdown1 = new Select(findElement(By.id("location_country")));
	  dropdown1.selectByValue("IN");
	  
		
	  findElement(By.id("location_province")).sendKeys(LocationaState);
	  findElement(By.id("location_city")).sendKeys(LocationCity);
	  findElement(By.id("btnSave")).click();


  }
 
}



