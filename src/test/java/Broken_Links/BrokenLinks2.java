package  Broken_Links;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.testng.annotations.*;

/*Let’s see some of the HTTP status codes.

200 – Valid Link
404 – Link not found
400 – Bad request
401 – Unauthorized
500 – Internal Error*/


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;

public class BrokenLinks2
{
	static WebDriver driver;
	
	@Test
	public void Open_OrangeHRM() throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.get("http://www.bhavasri.com/Frames/AllContacts.html");
		
		Thread.sleep(5000);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));	
		System.out.println("Total links are :"+links.size());	
			
			
		for(int i=0; i<links.size(); i++) {
				WebElement element = links.get(i);
				
				String url=element.getAttribute("href");
				verifyLink(url);			
		}	
		driver.close();
	
	}
	
	
	
	   
		public static void verifyLink(String urlLink) throws Exception {
	     
	       
				URL link = new URL(urlLink);
				
				HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
				
				httpConn.setConnectTimeout(2000);
				
				httpConn.connect();
				
					if(httpConn.getResponseCode()== 200) {	
						System.out.println(urlLink+" - "+httpConn.getResponseMessage());
					}
					if(httpConn.getResponseCode()== 404) {
						System.out.println(urlLink+" - "+httpConn.getResponseMessage());
					}
					
			}
				
			

 
}	

		
		
		
		
		
		
		
	
                                                  












