package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.explicitWait;
import utilities.scrollPage;

public class reviewTransaction {
	
	Properties pr;
	ChromeDriver driver;
	
	public reviewTransaction(ChromeDriver driver, Properties pr)
	{
		this.driver=driver;
		this.pr=pr;
	}
	
	public void review() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		scrollPage sp=new scrollPage(driver, pr);
		WebElement tick=driver.findElement(By.xpath(pr.getProperty("tickReviewTransaction")));
		sp.scrollIntoView(tick);
		js.executeScript("arguments[0].click();",tick );
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));
		
		explicitWait w = new explicitWait(driver, pr);
		w.invisibilityOfElementLocated(driver.findElement(By.xpath(pr.getProperty("loader"))));
	
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));



	}
	
}

