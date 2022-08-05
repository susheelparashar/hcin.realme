package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.explicitWait;
import utilities.scrollPage;

public class verifyCustomerDetails {
	
	Properties pr;
	ChromeDriver driver;

	public verifyCustomerDetails(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}
	
	public void verifyDetails() throws InterruptedException {
		
		// zoom out
		System.out.println("star zooming out");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '70%'");
		
		explicitWait w = new explicitWait(driver, pr);
		w.invisibilityOfElementLocated(driver.findElement(By.xpath(pr.getProperty("loader"))));
	
		//scroll into view 
		WebElement checkBoxCustomerDetails=driver.findElement(By.xpath(pr.getProperty("checkBoxCustomerDetails")));
		scrollPage sp=new scrollPage(driver, pr);
		sp.scrollIntoView(checkBoxCustomerDetails);
		
		//checkBox customer details 
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", checkBoxCustomerDetails);
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));
		System.out.println("customer details verified successfully");

		w.invisibilityOfElementLocated(driver.findElement(By.xpath(pr.getProperty("loader"))));

	}

}
