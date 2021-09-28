package ExcelUtil_Apache_POI;
import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.testng.annotations.Test;

public class Add_Nationalities_Xlsx {
	
	    public FileInputStream fis = null;
	    public XSSFWorkbook workbook = null;
	    public XSSFSheet sheet = null;
	    public XSSFRow row = null;
	    public XSSFCell cell = null;
	  
	    String TestURL,UserName,Password,Nationality_text;
	    WebDriver driver;
	    
  @Test
  public void AddNationalities() throws Exception {
	  
	  Add_Nationalities_Xlsx  eat=new Add_Nationalities_Xlsx();
  	
	 TestURL=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet1",1,0);
     UserName=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet1",1,1);
 	 Password=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet1",1,2);
     Nationality_text=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet1",1,3);

		// eat.readinputdata();
		 
         System.out.println("TestURL Cell Value is :"+TestURL);
		 System.out.println("UserName Cell Value is :"+UserName);
		 System.out.println("Password Cell Value is :"+Password);
		 System.out.println("NationalityText Cell Value is :"+Nationality_text);

		 System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
         driver =new ChromeDriver();
		 driver.manage().window().maximize() ;
		 driver.get(TestURL);
				
		 findElement(By.name("txtUsername")).sendKeys(UserName);
		 findElement(By.name("txtPassword")).sendKeys(Password);
		 findElement(By.id("btnLogin")).click();
		 findElement(By.id("menu_admin_viewAdminModule")).click();
		 findElement(By.id("menu_admin_nationality")).click();
		 findElement(By.id("btnAdd")).click();
		 findElement(By.id("nationality_name")).sendKeys(Nationality_text);
		 findElement(By.id("btnSave")).click();
		 driver.quit();
		
  }
  public String getCellData(String xlFilePath, String sheetName,int rowNum,int column) throws Exception
  {
	  fis = new FileInputStream(xlFilePath);  //excel File path
      workbook = new XSSFWorkbook(fis);   // workbook open
      sheet = workbook.getSheet(sheetName); //Sheet1 open
      row = sheet.getRow(rowNum); // 1st row will be highlighted
      cell = row.getCell(column); // 1th column will be highlited
      
      if(cell.getCellTypeEnum() == CellType.STRING)
      {	
      	String str6=cell.getStringCellValue();
      	System.out.println("Cell Value is :"+str6);
      	workbook.close();
      	fis.close();
        return str6;
      }
      
      else if(cell.getCellTypeEnum() == CellType.NUMERIC)
      {	
      	
      	int i = (int)cell.getNumericCellValue(); 
      	String str6 = String.valueOf(i); 
      	workbook.close();
      	fis.close();
        return str6;
      }
      else 
      {
      	String str6=cell.getStringCellValue();
      	workbook.close();
      	fis.close();
        return str6;
      }
  }
      public  WebElement findElement(By by) throws Exception 
  	{
  				
  		 WebElement elem = driver.findElement(by);    	    
  		
  		 
  		if (driver instanceof JavascriptExecutor) 
  		{
  		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
  	 
  		}
  		
  		return elem;
  	}
      
  } 
  
 
  
  
  
  
  
  
  
  
  
  
  
  

