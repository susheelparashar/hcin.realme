package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.scrollPage;

public class VAS {

	Properties pr;
	ChromeDriver driver;
	

	public VAS(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}

	
	public void selectOnsiteGoScreenProtection() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("VAS"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("onsiteGoScreenProtection"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("addVas"))));
		System.out.println("onsiteGoScreenProtection selected");
	}	
	
	public void selectOnsiteGoExtendedWarrantyMobile() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("offer"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));
		System.out.println("offer selected successfully from standard offers");
	}	
	public void selectOnsiteGoSpillDrop() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("offer"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));
		System.out.println("offer selected successfully from standard offers");
	}	
	

}
