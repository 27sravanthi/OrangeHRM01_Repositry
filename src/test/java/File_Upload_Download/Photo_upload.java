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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Photo_upload {
	
	WebDriver driver;
	
  @Test
  public void PhotoUpload() throws Exception{
	  
	  Photo_upload F1= new Photo_upload();
	  
	  F1.OpenChromeBrowser();
	  F1.OpenOrangeHRMURL();
	  F1.Login();
	  F1.EmployeeDetails();
  }
  public void OpenChromeBrowser()throws Exception {
	  
	 System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize() ; 

  }
  public void OpenOrangeHRMURL()throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://opensource-demo.orangehrmlive.com/");
		  
  }
  public void Login()throws Exception {
	  
	  findElement(By.id("txtUsername")).sendKeys("Admin");
	  findElement(By.id("txtPassword")).sendKeys("admin123");
	  findElement(By.id("btnLogin")).click();
	
  }
  public void EmployeeDetails() throws Exception {
	  
	  findElement(By.id("menu_pim_viewPimModule")).click();
	  findElement(By.id("menu_pim_viewEmployeeList")).click();
	  
	  Thread.sleep(100);
	  findElement(By.linkText("0007")).click();
	  
	
	  String str1="C:\\HTML Report\\EMP_Photos\\image1.jpg";
      PhotoUpload(str1); 
  }
		  
public void PhotoUpload(String PhotoPath) throws Exception {	
	
	      findElement(By.id("empPic")).click();
	  
	      WebElement Choosephoto=  findElement(By.id("photofile"));
	      Actions actions = new Actions(driver);
	      actions.moveToElement(Choosephoto).click().build().perform();
		 
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
