package practise_01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Add_Nationalities_xpath {
	WebDriver driver;
	
	  String usernme="//*[@id='txtUsername']";
	  String password="//*[@id=\'txtPassword\']" ;
	  String login="//*[@id='btnLogin']";
	  String admin="//*[@id='menu_admin_viewAdminModule']/b";
	  String Nationality="//*[@id='menu_admin_nationality']" ; 
	  String Add="//*[@id='btnAdd']";
	  String Nationality_name="//*[@id='nationality_name']";
	  String Save="	//*[@id='btnSave']";
	
	
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
	  
	  Add_Nationalities_xpath N1 = new Add_Nationalities_xpath();
	  
	  N1.OpenChromeBrowser();
	  N1.OpenOrangeHRMURL();
	  N1.Login(usernme,password,login);
	  N1.AddNationalities(admin,Nationality,Add,Nationality_name,Save);
	  
	  
		  
		  
  }
  
  
  public void OpenChromeBrowser() throws Exception  {
	    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
	    
  }
  
  public void OpenOrangeHRMURL() throws Exception  {
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  
  
  
  public void Login(String username, String password, String login) throws Exception  {

	  
	    findElement(By.xpath(username)).sendKeys("Admin");
		findElement(By.xpath(password)).sendKeys("admin123");
		findElement(By.xpath(login)).click();
  }
  
  
  public void AddNationalities(String admin, String Nationality, String Add, String Nationality_name, String Save  ) throws Exception  {
	  
	  
	  
	  findElement(By.xpath(admin)).click();
	  findElement(By.xpath(Nationality)).click();
	  findElement(By.xpath(Add)).click();
	  findElement(By.xpath(Nationality_name)).sendKeys("Indian243");
	  findElement(By.xpath(Save)).click();
	  
	
  }
  
  
  
  
  
  
  
  
}
