package pages;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DBManager;
import utilities.explicitWait;
import utilities.scrollPage;

public class address {

	Properties pr;
	ChromeDriver driver;

	public address(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}

	public void captureAddress() throws InterruptedException, ClassNotFoundException, SQLException, IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		explicitWait w=new explicitWait(driver, pr);

		// address verification
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("addressVerification"))));
		driver.navigate().refresh();
		
		// zoom out
		System.out.println("star zooming out");
		js.executeScript("document.body.style.zoom = '70%'");
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("drivingLicense"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));
		System.out.println("driver license selected successfully");

		// capture front address proof
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("capture_Front_address"))));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("confirm_front_address"))));
		System.out.println("captured front side of DL");
		Thread.sleep(2000);

		// capture back address proof
		WebElement checkAddress=  (WebElement) js.executeScript("return document.querySelector(\"#mat-checkbox-1 > label > span.mat-checkbox-label\")");
		System.out.println(checkAddress);
		js.executeScript("arguments[0].click();", checkAddress);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("capture_back_address"))));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("confirm_back_adress"))));
		System.out.println("captured back side of DL");
		Thread.sleep(5000);

		// address details
		Thread.sleep(500);
		driver.findElement(By.xpath(pr.getProperty("drivingLicenseNo"))).sendKeys("DL-1420110012345");
		driver.findElement(By.xpath(pr.getProperty("DLexpirydate"))).sendKeys("01/01/2033");
		driver.findElement(By.xpath(pr.getProperty("building"))).sendKeys("building");
		driver.findElement(By.xpath(pr.getProperty("street"))).sendKeys("street");
		driver.findElement(By.xpath(pr.getProperty("locality"))).sendKeys("locality");
		driver.findElement(By.xpath(pr.getProperty("pincode"))).sendKeys("201301");
		driver.findElement(By.xpath(pr.getProperty("floor"))).sendKeys("11");
		driver.findElement(By.xpath(pr.getProperty("landmark"))).sendKeys("landmark");
		System.out.println("captured address details successfully");

		// Correspondence address no
		Thread.sleep(2000);
		WebElement corress_address_no= driver.findElement(By.xpath(pr.getProperty("corress_address_no")));
		scrollPage sp=new scrollPage(driver, pr);
		w.visibilityOf(corress_address_no);
		js.executeScript("arguments[0].click();", corress_address_no);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue_Res_address"))));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue_Res_address"))));

		// housing type
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("owned"))));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));
		System.out.println("res address details captured successfully");
	}
}
