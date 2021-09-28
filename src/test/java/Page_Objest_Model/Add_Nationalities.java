package Page_Objest_Model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Add_Nationalities {
	
	
	WebDriver driver;
	
	
	@BeforeTest 
	public void  TestSetup()throws Exception {
		
		driver = TestBrowser.OpenChromeBrowser();
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
	}
	
	
	@Test
	public void AddingNatinality(String Username, String Password) throws Exception {
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		Login L1 = new Login();
		L1.Loginpage(driver);
		L1.Login1(Username, Password);
		
		AddNationalities N1= new AddNationalities();
		N1.AddNationalities(driver);
		N1.Add_Nationalities();
		
		Logout H1= new Logout();
		H1.Logout(driver);
		H1.Logout1();
	}
	
	@AfterTest 
	public void  TestCloser()throws Exception {	
		driver.quit();
	}
	
	
	
	
  
  
  
  
  
  
}
