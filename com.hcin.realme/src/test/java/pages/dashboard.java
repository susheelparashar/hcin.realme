package pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dashboard {
	
	Properties pr;
	ChromeDriver driver;
	
	public dashboard(ChromeDriver driver, Properties pr)
	{
		this.driver=driver;
		this.pr=pr;
	}
	public void ApplyUjjwalCard() throws InterruptedException
	{
		//select apply for ujjwal card
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(pr.getProperty("applyForUjjwalCard")))));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("applyForUjjwalCard"))));
		System.out.println("select apply for ujjwal card");	
	}
	
	public void initiatePurchase() throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
			
		//select initiatePurchase
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(pr.getProperty("initiatePurchase")))));
		
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("initiatePurchase"))));
		System.out.println("select initiate Purchase");	
	
	}
}
