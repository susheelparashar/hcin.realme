package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.click;
import utilities.explicitWait;

public class cutsomerWishes {
	
	Properties pr;
	ChromeDriver driver;
	
	public cutsomerWishes(ChromeDriver driver, Properties pr)
	{
		this.driver=driver;
		this.pr=pr;
	}
	
	public void onlyCommodity() throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("OK"))));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));
		
		explicitWait w = new explicitWait(driver, pr);
		w.invisibilityOfElementLocated(driver.findElement(By.xpath(pr.getProperty("loader"))));

	}	
		
}
	


