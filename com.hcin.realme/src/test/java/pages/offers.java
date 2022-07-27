package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.scrollPage;

public class offers {

	Properties pr;
	ChromeDriver driver;
	

	public offers(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}

	
	public void selectOffer() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("offer"))));
		
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue_offers"))));
		System.out.println("offer selected successfully from standard offers");
	}	
	

}
