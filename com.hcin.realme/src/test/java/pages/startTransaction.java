package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class startTransaction {
	
	Properties pr;
	ChromeDriver driver;

	public startTransaction(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}
	
	public void verifyContract() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//enter mobile no
		driver.findElement(By.xpath(pr.getProperty("mobileNumber"))).sendKeys("9911234005");
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue1"))));
		System.out.println("mobile number entered successfully");
		
		//enter contract code
		driver.findElement(By.xpath(pr.getProperty("contractCode"))).sendKeys("4200081127");
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue_contract"))));
		System.out.println("contract code entered successfully");
	}

}
