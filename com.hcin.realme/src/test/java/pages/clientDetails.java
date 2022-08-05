package pages;

import java.time.Duration;
import java.util.Locale;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;

public class clientDetails {

	Properties pr;
	ChromeDriver driver;

	public clientDetails(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}

	public void personalDetails(String mobile, String dob, String fullname, String email) throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		
		driver.findElement(By.xpath(pr.getProperty("mobileNumber"))).sendKeys(mobile);
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));
		System.out.println("mobile number entered successfully");

		// details
		driver.findElement(By.xpath(pr.getProperty("name"))).sendKeys(fullname);
		driver.findElement(By.xpath(pr.getProperty("email"))).sendKeys(email);
		System.out.println(dob);
		driver.findElement(By.xpath(pr.getProperty("dob"))).sendKeys(dob);

		// mobile number linked with Aadhaar
		WebElement no = (WebElement) js.executeScript("return document.querySelector(\"#mat-radio-3 > label\")");
		js.executeScript("arguments[0].click();", no);
		Thread.sleep(500);

		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("bank"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("hdfc"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("language"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("eng"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("tick"))));
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue"))));
		System.out.println("personal details captured successfully");
	}
}
