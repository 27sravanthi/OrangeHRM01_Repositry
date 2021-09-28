package File_Upload_Download;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class File_Download {
	
	WebDriver driver;
	private String fname;
  @Test
  public void f() throws Exception {
	  
	    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		 findElement(By.id("txtUsername")).sendKeys("Admin");
		 findElement(By.id("txtPassword")).sendKeys("admin123");
		 findElement(By.id("btnLogin")).click();
		 
		 findElement(By.id("menu_pim_viewPimModule")).click();
		  findElement(By.id("menu_pim_viewEmployeeList")).click();
		  
		  Thread.sleep(100);
		  findElement(By.linkText("0007")).click();
		  
		  findElement(By.name("chkattdel[]")).click();
		  
		  WebElement DownloadFile=findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[2]/a"));
		  Actions actions= new Actions(driver);
		  actions.moveToElement(DownloadFile).click().build().perform();
		
				  
		  String SrcFile="C:\\Users\\admin\\Downloads\\"+fname;
		  String DestinationFile="C:\\HTML Report\\"+fname;
	
	
		 Thread.sleep(6000);
		 moveFile(SrcFile, DestinationFile);

		  

	  
  }
  public static void moveFile(String src, String dest ) throws InterruptedException {
      Path result = null;
      try {
         result =  Files.move(Paths.get(src), Paths.get(dest));
         
         
         Thread.sleep(5000);
      } catch (IOException e) {
         System.out.println("Exception while moving file: " + e.getMessage());
      }
      if(result != null) {
         System.out.println("File moved successfully.");
      }else{
         System.out.println("File movement failed.");
      }  
   }
  
  public  WebElement findElement(By by) throws Exception {
		
	    WebElement elem = driver.findElement(by);
	    
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	       
	    }
	    return elem; 
	}
}
