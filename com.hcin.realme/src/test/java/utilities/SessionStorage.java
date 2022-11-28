package utilities;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionStorage {
	
	Properties pr;
	ChromeDriver driver;
		
	public SessionStorage(ChromeDriver driver, Properties pr)
	{
		this.driver=driver;
		this.pr=pr;
	}
	
	 public void getItem()
	 {
		
		 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		 //Session storage
		 String sessionStorage= (String) jsExecutor.executeScript(String.format("return window.sessionStorage.getItem('%s');", "customerName"));
		 System.out.println(sessionStorage);

		 
	 }
}
