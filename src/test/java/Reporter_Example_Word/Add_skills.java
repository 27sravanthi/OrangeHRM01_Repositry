package Reporter_Example_Word;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Reporter_Example_Word.ImageAttachmentInDocument1;
import Reporter_Example_Word.Reporter1;
import Reporter_Example_Word.WordConvertPDF;

public class Add_skills {
	
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
  @Test
  public void Add_Skills() throws Exception {
	  
	  ImageAttachmentInDocument1 IA = new ImageAttachmentInDocument1();
		IA.CreateHeader("Daily Status Report");
		
		SimpleDateFormat sdfDate1 = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_a");
		Date now1 = new Date();
		String strDate1 = sdfDate1.format(now1);
		System.out.print(strDate1);
		
		String TestName="AddSkills"+strDate1; 
		
		Reporter1 R1= new Reporter1(driver, "AddSkills");
		
	    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String str=R1.getScreenShotPath(driver);
		IA.PasteImage("Pass- open Orangehrm",str);
	
		findElement(By.id("txtUsername")).sendKeys("Admin");
		str=R1.getScreenShotPath(driver);
	    IA.PasteImage("Pass- Enter User Name",str);
	    
		findElement(By.id("txtPassword")).sendKeys("admin123");
		str=R1.getScreenShotPath(driver);
	    IA.PasteImage("Pass- Enter Password",str);
	    
		findElement(By.id("btnLogin")).click();
		str=R1.getScreenShotPath(driver);
	    IA.PasteImage("Pass- Clicl on Login",str);
	    
		
		findElement(By.id("menu_admin_viewAdminModule")).click();
		str=R1.getScreenShotPath(driver);
	    IA.PasteImage("Pass- Click on Admin",str);
	    
		
		findElement(By.id("menu_admin_Qualifications")).click();
		str=R1.getScreenShotPath(driver);
	    IA.PasteImage("Pass- Click on Qualifications",str);
	    
		
		findElement(By.id("menu_admin_viewSkills")).click();
		str=R1.getScreenShotPath(driver);
	    IA.PasteImage("Pass- Click on skills",str);
	    
		
		findElement(By.id("btnAdd")).click();
		str=R1.getScreenShotPath(driver);
	    IA.PasteImage("Pass- Click on Add",str);
	    
		
		findElement(By.id("skill_name")).sendKeys("Autocad2");
		str=R1.getScreenShotPath(driver);
	    IA.PasteImage("Pass- Enter Skill name",str);
	    
		
		findElement(By.id("skill_description")).sendKeys("Autocad discriptio2");
		str=R1.getScreenShotPath(driver);
	    IA.PasteImage("Pass- Enter Skill Discription",str);
	    
		
		findElement(By.id("btnSave")).click();
		str=R1.getScreenShotPath(driver);
	    IA.PasteImage("Pass- Click on Save",str);
	    
	    driver.close();
	    String Filename=IA.WordOutput_File(TestName);
	    WordConvertPDF.main(Filename);
	    
		
		
	
		  
  }
}
