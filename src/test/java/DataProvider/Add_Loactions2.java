package DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Add_Loactions2 {
	
	 WebDriver driver;
	
	 @DataProvider(name = "Locations1")
	  public static Object Test1() throws Exception {
		 Object[][] data = new Object[2][7];

			// 1st row
			data[0][0] ="https://opensource-demo.orangehrmlive.com/";
			data[0][1] = "Admin";
			data[0][2] = "admin123";
			data[0][3] = "Kukatpalli2";
			data[0][4] = "India";
			data[0][5] = "Telanana";
			data[0][6] = "Hyderabad";
	
			// 2nd row
			data[1][0] ="https://opensource-demo.orangehrmlive.com/";
			data[1][1] = "Admin";
			data[1][2] = "admin123";
			data[1][3] = "Washingtone1";
			data[1][4] = "United States";
			data[1][5] = "Florida";
			data[1][6]= "USA";
			
		
			return data;
	 
	       
	  }
	 
 
  
  public  WebElement findElement(By by) throws Exception {
		
	    WebElement elem = driver.findElement(by);
	    
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	       
	    }
	    return elem; 
	} 
  @Test(dataProvider="Locations1")
  public void Add_Locations(String URL,String UserName,String Password,String LocationName,String LocationCountry,String LocationCity,String LocationState ) throws Exception {
	  
	  Add_Loactions2 L1= new  Add_Loactions2();
	  
	  L1.OpenChromeBroser();
	  L1.OpenOrangeHRMURL(URL);
	  L1.Login(UserName,Password);
	  L1.AddLocations(LocationName,LocationCountry,LocationState,LocationCity);
	  
	  
  }
  
  public void OpenChromeBroser() throws Exception{
	  
	    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
  }
 
  public void OpenOrangeHRMURL(String URL) throws Exception{
	  
	  driver.get(URL);
	  
  }
  
  public void Login(String UserName, String Password) throws Exception{
	  
	    findElement(By.id("txtUsername")).sendKeys(UserName);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
	
  }
  public void AddLocations(String LocationName,String LocationCountry, String LocationCity,String LocationState) throws Exception{
	  
	  findElement(By.id("menu_admin_viewAdminModule")).click();
	  findElement(By.id("menu_admin_Organization")).click();
	  findElement(By.id("menu_admin_viewLocations")).click();
	  findElement(By.id("btnAdd")).click();
	  findElement(By.id("location_name")).sendKeys(LocationName);
	  
	  
	  Select dropdown1 = new Select(findElement(By.id("location_country")));
	  dropdown1.selectByVisibleText(LocationCountry);
	  
	  if(LocationCountry.equalsIgnoreCase("India"))
		{
		  findElement(By.id("location_province")).sendKeys(LocationState); 		
		}
	  if(LocationCountry.equalsIgnoreCase("United States"))
		{
		
		  Select dropdown2 = new Select(findElement(By.id("location_state")));
		  dropdown2.selectByVisibleText(LocationState);
		  
		}
	  
		 
	
	  
	  //Select dropdown1 = new Select(findElement(By.id("location_country")));
	 //dropdown1.selectByIndex(120);
	  
	 // Select dropdown1 = new Select(findElement(By.id("location_country")));
	 // dropdown1.selectByValue("IN");
	  
	 
	 
	  findElement(By.id("location_city")).sendKeys(LocationCity);
	  findElement(By.id("btnSave")).click();


  }
 
}



