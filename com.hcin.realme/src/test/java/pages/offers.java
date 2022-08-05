package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.explicitWait;
import utilities.scrollPage;

public class offers {

	Properties pr;
	ChromeDriver driver;

	public offers(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}

	public void selectStandardOffers() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("standardOffer"))));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));
		System.out.println("offer selected successfully from standard offers");
		explicitWait w = new explicitWait(driver, pr);
		w.invisibilityOfElementLocated(driver.findElement(By.xpath(pr.getProperty("loader"))));

		
		Thread.sleep(1000); 
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath(pr.getProperty("changedOfferOK"))));
		System.out.println("offer changed from cabus");
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("cabusOffer"))));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));
		System.out.println("offer selected successfully from standard offers");
		w.invisibilityOfElementLocated(driver.findElement(By.xpath(pr.getProperty("loader"))));


	}

}
