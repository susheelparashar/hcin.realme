package utilities;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class click {
	Properties pr;
	ChromeDriver driver;
		
	public click(ChromeDriver driver, Properties pr)
	{
		this.driver=driver;
		this.pr=pr;
	}
	
	public void clickStale(WebElement element)
	{
		try {
		    element.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			 element.click();
		}
		
	}
	
	

}
