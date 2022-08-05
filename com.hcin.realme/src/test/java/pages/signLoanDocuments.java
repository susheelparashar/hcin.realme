package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.explicitWait;
import utilities.scrollPage;

public class signLoanDocuments {
	
	Properties pr;
	ChromeDriver driver;

	public signLoanDocuments(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}
	
	public void pushForCappSigning() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("sendLinkToCustomer"))));
		
		explicitWait w = new explicitWait(driver, pr);
		w.invisibilityOfElementLocated(driver.findElement(By.xpath(pr.getProperty("loader"))));
		
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("OK"))));

		w.invisibilityOfElementLocated(driver.findElement(By.xpath(pr.getProperty("loader"))));
		System.out.println("pushed transaction to CAPP sucessfully");

	}

}
