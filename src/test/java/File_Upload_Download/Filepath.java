package File_Upload_Download;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;


public class Filepath {
	
	WebDriver driver;
	
  @Test
  public void File_Upload() throws Exception {
	
	  Filepath F1= new Filepath();
	  
	  F1.OpenChromeBroser();
	  F1.OpenOrangeHRMURL();
	  F1.Login();
	  F1.Add_Jobs();
	 
		
  }
public void OpenChromeBroser() throws Exception{
	
	    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ; 

  }
public void OpenOrangeHRMURL() throws Exception {
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get("https://opensource-demo.orangehrmlive.com/");
	  
  }
  public void Login() throws Exception {
	  
  
	      findElement(By.id("txtUsername")).sendKeys("Admin");
		  findElement(By.id("txtPassword")).sendKeys("admin123");
		  findElement(By.id("btnLogin")).click();
		
		
	  
  }
  public void Add_Jobs() throws Exception {
	  
	  WebElement Admin=findElement(By.id("menu_admin_viewAdminModule"));
	  WebElement Job=findElement(By.id("menu_admin_Job"));
	  WebElement JobTitile=findElement(By.id("menu_admin_viewJobTitleList"));

	  
	  Actions actions= new Actions(driver);
	  
      actions.moveToElement(Admin);
      actions.moveToElement(Job);
      actions.moveToElement(JobTitile).click().build().perform();
  
      findElement(By.id("btnAdd")).click();
      findElement(By.id("jobTitle_jobTitle")).sendKeys("Java1");
      findElement(By.id("jobTitle_jobDescription")).sendKeys("Java Discription1");
      
	  Thread.sleep(3000);
	  
	  String str1="C:\\HTML Report\\EMP_Photos\\bsnl.txt";
	  FileUpload(str1); 
     
	  
  }
  public void FileUpload(String PhotoPath) throws Exception {
	  
	  WebElement ChooseFile=findElement(By.id("jobTitle_jobSpec"));
	  Actions actions= new Actions(driver);
	  actions.moveToElement(ChooseFile).click().build().perform();
	  
	
	  StringSelection sel = new StringSelection(PhotoPath);
	  
	   // Copy to clipboard
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
	 System.out.println("selection" +sel);
	 
	 // Create object of Robot class
	 Robot robot = new Robot();
	 Thread.sleep(2000);
	      
	 
	  // Press CTRL+V
	 robot.keyPress(KeyEvent.VK_CONTROL);
	 robot.keyPress(KeyEvent.VK_V);
	 
	// Release CTRL+V
	 robot.keyRelease(KeyEvent.VK_CONTROL);
	 robot.keyRelease(KeyEvent.VK_V);
	 Thread.sleep(2000);
	        

      //  Press Enter 
	 robot.keyPress(KeyEvent.VK_ENTER);
	 robot.keyRelease(KeyEvent.VK_ENTER);
	 
	 Thread.sleep(8000);


      findElement(By.id("jobTitle_note")).sendKeys("Java Note1");
	  findElement(By.id("btnSave")).click();

      
  }
public  WebElement findElement(By by) throws Exception {
	
    WebElement elem = driver.findElement(by);
    
    if (driver instanceof JavascriptExecutor) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
       
    }
    return elem; 
}
}
