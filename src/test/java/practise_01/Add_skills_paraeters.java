package practise_01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Add_skills_paraeters {
	
	WebDriver driver;
	String URL="https://opensource-demo.orangehrmlive.com/";
	String Username="Admin", Password="admin123";
	String skillname="selenium", skilldescription="seleniumdiscription";
	
	
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
  public void Add_Skills()throws Exception  {
	  
	  Add_skills_paraeters S12= new Add_skills_paraeters();
	  
	  S12.Open_chrome_browser();
	  S12.Open_OrangeHRM_URL(URL);
	  S12.Login(Username,Password);
      S12.Add_skills(skillname,skilldescription);
      
  }
  public void Open_chrome_browser()throws Exception  {
	  
	    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
	    
  }
  public void Open_OrangeHRM_URL(String URL)throws Exception  {
	  
	  driver.get(URL);
	    
  }
  public void Login(String Username,String Password)throws Exception  {
	  
	    findElement(By.id("txtUsername")).sendKeys(Username);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
	    
  }
  public void Add_skills(String skillname,String skilldescription )throws Exception  {
	  
	    findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys(skillname);
		findElement(By.id("skill_description")).sendKeys(skilldescription);
		findElement(By.id("btnSave")).click();
		
	  
	  
	    
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
