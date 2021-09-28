package DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;


public class Add_Loactions_Excel {
	
	 static WebDriver driver;
	
	 @DataProvider(name = "Locations1")
		public static Object[][] Authentication1() throws Exception {
		
		
		    ExcelApiTest4 eat = new ExcelApiTest4();
			Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//Locations.xlsx", "Sheet1");
			System.out.println(testObjArray.length);
			return (testObjArray);
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
	  
	  Add_Loactions_Excel L1= new  Add_Loactions_Excel();
	  
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
	  
		//  Select dropdown2 = new Select(findElement(By.id("location_state")));
		//  dropdown2.selectByVisibleText(LocationState);
		   
	  //Select dropdown1 = new Select(findElement(By.id("location_country")));
	 //dropdown1.selectByIndex(120);
	  
	 // Select dropdown1 = new Select(findElement(By.id("location_country")));
	 // dropdown1.selectByValue("IN");
	  
	  findElement(By.id("location_province")).sendKeys(LocationState);
	 
	  findElement(By.id("location_city")).sendKeys(LocationCity);
	  findElement(By.id("btnSave")).click();


  }
 
}



