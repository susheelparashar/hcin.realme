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

	public void personalDetails() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Faker faker = new Faker(new Locale("en-IND"));
		
		// enter mobile number
		//String mobile=faker.phoneNumber().cellPhone();
		driver.findElement(By.xpath(pr.getProperty("mobileNumber"))).sendKeys("6646541321");
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue1"))));
		System.out.println("mobile number entered successfully");

		// zoom out
		System.out.println("star zooming out");
		js.executeScript("document.body.style.zoom = '80%'");

		// details
		String fullname=faker.name().firstName()+" "+faker.name().lastName();
		driver.findElement(By.xpath(pr.getProperty("name"))).sendKeys(fullname);
		String email=faker.name().firstName()+faker.name().lastName()+"@gmail.com";
		driver.findElement(By.xpath(pr.getProperty("email"))).sendKeys(email);
		driver.findElement(By.xpath(pr.getProperty("dob"))).sendKeys("22/11/2000");

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
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("cont_details"))));
		System.out.println("personal details captured successfully");
	}
}
