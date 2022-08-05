package pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.explicitWait;

public class startTransaction {
	
	Properties pr;
	ChromeDriver driver;

	public startTransaction(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}
	
	public void verifyContract(String mobile, String contractCode) throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//enter mobile no
		driver.findElement(By.xpath(pr.getProperty("mobileNumber"))).sendKeys(mobile);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));
		System.out.println("mobile number entered successfully");
		
		//enter contract code
		Thread.sleep(1000);
		driver.findElement(By.xpath(pr.getProperty("contractCode"))).sendKeys(contractCode);
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));
		System.out.println("contract code entered successfully");
		explicitWait w = new explicitWait(driver, pr);
		w.invisibilityOfElementLocated(driver.findElement(By.xpath(pr.getProperty("loader"))));
		

	}

}
