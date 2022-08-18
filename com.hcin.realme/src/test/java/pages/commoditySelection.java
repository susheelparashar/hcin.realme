package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.explicitWait;
import utilities.scrollPage;

public class commoditySelection {

	Properties pr;
	ChromeDriver driver;
	

	public commoditySelection(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}

	
	public void selectMobile() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("commodityCategory"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("mobiles"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("commodityType"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("mobilePhone"))));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("model"))));
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("otherModel"))));
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("SKU"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("NA"))));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));
		System.out.println("commodity details captured");
		explicitWait w = new explicitWait(driver, pr);
		w.invisibilityOfElementLocated(driver.findElement(By.xpath(pr.getProperty("loader"))));

	}	
	
	public void selectHomeAppliance() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("commodityCategory"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("homeAppliance"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("commodityType"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("ledTv"))));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("model"))));
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("43''"))));
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("SKU"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("6941399013186"))));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));
		System.out.println("commodity details captured");
		explicitWait w = new explicitWait(driver, pr);
		w.invisibilityOfElementLocated(driver.findElement(By.xpath(pr.getProperty("loader"))));

	}	
	
	public void verifyCommodity() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//driver.findElement(By.xpath(pr.getProperty("commodityPrice"))).sendKeys("10000");
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));
		System.out.println("commodity price captured");
		explicitWait w = new explicitWait(driver, pr);
		w.invisibilityOfElementLocated(driver.findElement(By.xpath(pr.getProperty("loader"))));

	}	

}
