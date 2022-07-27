package pages;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DBManager;

public class pan {

	Properties pr;
	ChromeDriver driver;

	public pan(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}

	public void visibilityOfElementLocated(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void elementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void capturePan(String panNo, String fathername, String mothername) throws InterruptedException, ClassNotFoundException, SQLException, IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// zoom out
		System.out.println("star zooming out");
		js.executeScript("document.body.style.zoom = '70%'");

		// pan
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("pan"))));
		Thread.sleep(2000);
		
		WebElement checkBoxPan=  (WebElement) js.executeScript("return document.querySelector(\"#mat-checkbox-1 > label > span.mat-checkbox-label > p\")");
		js.executeScript("arguments[0].click();", checkBoxPan);
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("capture_pan"))));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("confirm_pan"))));
		System.out.println("pan photo captured");
		Thread.sleep(2000);

		// retry 1
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("retry1"))));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("capture_pan"))));
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("confirm_pan"))));
		System.out.println("retry 1 done");

		// retry 2
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("retry2"))));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("capture_pan"))));
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("confirm_pan"))));
		System.out.println("retry 2 done");

		// retry 3
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("retry3"))));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("capture_pan"))));
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("confirm_pan"))));
		System.out.println("retry 3 done");

		// Pan details
		Thread.sleep(500);
		driver.findElement(By.xpath(pr.getProperty("panNo"))).sendKeys(panNo);
		driver.findElement(By.xpath(pr.getProperty("fatherName"))).sendKeys(fathername);

		// gender
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("gender"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("male"))));

		// maritalStatus
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("maritalStatus"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("married"))));

		// mother name 
		Thread.sleep(500);
		driver.findElement(By.xpath(pr.getProperty("motherName"))).sendKeys(mothername);
		
		//click on continue
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue_pan_details"))));
		System.out.println("pan details captured successfully");
	}
}
