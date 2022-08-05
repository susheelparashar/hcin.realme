package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.explicitWait;
import utilities.scrollPage;

public class invoiceDetails {
	
	Properties pr;
	ChromeDriver driver;

	public invoiceDetails(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}
	
	public void captureInvoice() throws InterruptedException {
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		explicitWait w = new explicitWait(driver, pr);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("shareDetails"))));
		driver.findElement(By.xpath(pr.getProperty("invoiceNumber"))).sendKeys("664564");
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("invoiceDate"))));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("currentDate"))));
		
		//invoice capture
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("invoicePhoto"))));
		w.invisibilityOfElementLocated(driver.findElement(By.xpath(pr.getProperty("loader"))));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("capture_Photo"))));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("confirm_photo"))));
		
		//continue 
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));
		w.invisibilityOfElementLocated(driver.findElement(By.xpath(pr.getProperty("loader"))));
		System.out.println("invoice details captured sucessfully");

	}

}
