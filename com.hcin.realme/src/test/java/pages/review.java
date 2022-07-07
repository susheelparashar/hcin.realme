package pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class review {
	Properties pr;
	ChromeDriver driver;
	
	public review(ChromeDriver driver, Properties pr)
	{
		this.driver=driver;
		this.pr=pr;
	}
	
	public void reviewPage() throws InterruptedException
	{
		
		driver.findElement(By.xpath(pr.getProperty("review"))).click();
		driver.findElement(By.xpath(pr.getProperty("writeReview"))).click();
			
		Thread.sleep(500);
		//switche to iframe
		driver.switchTo().frame("goog-reviews-write-widget");
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(500);
		
		WebElement oneStar=  (WebElement) jse.executeScript("return document.querySelector(\"#yDmH0d > c-wiz > div > div > div > div > div.O51MUd > div.l5dc7b > div > div.euWHWd.aUVumf > div > div:nth-child(1)\")");
		WebElement twoStar=  (WebElement) jse.executeScript("return document.querySelector(\"#yDmH0d > c-wiz > div > div > div > div > div.O51MUd > div.l5dc7b > div > div.euWHWd.aUVumf > div > div:nth-child(2)\")");
		WebElement threeStar=(WebElement) jse.executeScript("return document.querySelector(\"#yDmH0d > c-wiz > div > div > div > div > div.O51MUd > div.l5dc7b > div > div.euWHWd.aUVumf > div > div:nth-child(3)\")");
		WebElement fourStar= (WebElement) jse.executeScript("return document.querySelector(\"#yDmH0d > c-wiz > div > div > div > div > div.O51MUd > div.l5dc7b > div > div.euWHWd.aUVumf > div > div:nth-child(4)\")");
		WebElement fiveStar= (WebElement) jse.executeScript("return document.querySelector(\"#yDmH0d > c-wiz > div > div > div > div > div.O51MUd > div.l5dc7b > div > div.euWHWd.aUVumf > div > div:nth-child(5)\")");
		
		
		jse.executeScript("arguments[0].click();", fourStar);
				
		WebElement comment=(WebElement) jse.executeScript("return document.querySelector(\"#Yc71gb\")");
		comment.sendKeys("good location");
		
		WebElement submit=(WebElement) jse.executeScript("return document.querySelector(\"#ZRGZAf > div.VfPpkd-RLmnJb\")");
		jse.executeScript("arguments[0].click();", submit);
		
		
	}


}
