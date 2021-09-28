package TestNG_Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class Add_Jobs_TestNG_Parameter {

	static WebDriver driver;
	public static int iRow = 0;
	
	@Parameters({"Browser1"})
	@BeforeTest
	public void OpenchromeBrowser(String Browser) throws Exception {

		if (Browser.equalsIgnoreCase("Chrome")) {
			driver = TestBrowser.OpenChromeBrowser();
		}

		else if (Browser.equalsIgnoreCase("FireFox")) {
			driver = TestBrowser.OpenFirefoxBrowser();
		}

		else if (Browser.equalsIgnoreCase("IE")) {
			driver = TestBrowser.OpenIEBrowser();
		}
		else {
			driver = TestBrowser.OpenChromeBrowser();
			System.out.println("Chrome Browser started :" + Browser);
		}

	}
	@DataProvider(name ="AddJobs")
	public static Object[][] Authentication1() throws Exception {
	
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C:\\HTML Report\\OrangeHRM6\\Add_jobs.xlsx", "Sheet2");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
@Test(dataProvider="AddJobs")
	public void Login(String URL, String Username, String Password,String JobTitle, String JobDiscription ) throws Exception {
		
	if (iRow==0)
	{
		
		iRow=iRow+1;
		Login(URL,Username,Password);
		AddJobDetails(JobTitle,JobDiscription );
		
	}
	
	else
	{
	
		iRow=iRow+1;
		AddJobDetails(JobTitle,JobDiscription );
	}
	
  }
  @AfterTest
	public  void CloseBrowser() throws Exception {

		driver.close();
	}
  public void Login(String URL, String Username,String Password) throws Exception {
		
	    driver.get(URL);
	    findElement(By.id("txtUsername")).sendKeys(Username);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
	
	}
  
  public void AddJobDetails(String JobTitle ,String JobDiscription) throws Exception {
		

	   findElement(By.linkText("Admin")).click();
       findElement(By.linkText("Job")).click();
       findElement(By.linkText("Job Titles")).click();
       findElement(By.id("btnAdd")).click();
       findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle);
       findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDiscription);
       findElement(By.id("btnSave")).click();

	}
	
	public static WebElement findElement(By by) throws Exception {

		WebElement elem = driver.findElement(by);

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);

		}
		return elem;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
