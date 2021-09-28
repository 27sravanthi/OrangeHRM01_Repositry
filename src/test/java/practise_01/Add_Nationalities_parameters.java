package practise_01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Add_Nationalities_parameters {
	WebDriver driver;
	String URL="https://opensource-demo.orangehrmlive.com/";
	String Username="Admin", Password="admin123";
	String Nationality="Indian123";
	
	public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
  @Test
  public void Add_Nationalitie() throws Exception  {
	  
	  Add_Nationalities_parameters N1 = new Add_Nationalities_parameters();
	  
	  N1.OpenChromeBrowser();
	  N1.OpenOrangeHRMURL(URL);
	  N1.Login(Username,Password);
	  N1.AddNationalities(Nationality);
	
  }
  
  public void OpenChromeBrowser() throws Exception  {
	    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
	    
  }
  
  public void OpenOrangeHRMURL(String URL) throws Exception  {
	  
	  driver.get(URL);
  }
  

  
  public void Login(String Username,String Password ) throws Exception  {
	  
	    findElement(By.id("txtUsername")).sendKeys(Username);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
  }
  
  public void AddNationalities(String Nationality) throws Exception  {
	  
	  findElement(By.id("menu_admin_viewAdminModule")).click();
	  findElement(By.id("menu_admin_nationality")).click();
	  findElement(By.id("btnAdd")).click();
	  findElement(By.id("nationality_name")).sendKeys(Nationality);
	  findElement(By.id("btnSave")).click();
	  
	
  }
  
  
  
  
  
  
  
  
}
