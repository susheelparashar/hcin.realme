package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.scrollPage;

public class commoditySelection {

	Properties pr;
	ChromeDriver driver;
	

	public commoditySelection(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}

	
	public void selectCommodity() throws InterruptedException {
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("commodityCategory"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("mobiles"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("commodityType"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("mobilePhone"))));
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("model"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("otherModel"))));
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("SKU"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("NA"))));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue_commoditySelection"))));
		System.out.println("commodity details captured");
	}	
	
	public void verifyCommodity() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath(pr.getProperty("commodityPrice"))).sendKeys("10000");
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue_verifyCommodity"))));
		System.out.println("commodity price captured");
	}	

}
