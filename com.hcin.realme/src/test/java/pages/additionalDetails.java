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

public class additionalDetails {

	Properties pr;
	ChromeDriver driver;

	public additionalDetails(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}

	public void captureAdditionalDetails() throws InterruptedException, ClassNotFoundException, SQLException, IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// additional details
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("additionalDetails"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("salaried"))));

		//montly income
		WebElement monthlyHouseholdIncome= driver.findElement(By.xpath(pr.getProperty("monthlyHouseholdIncome")));
		monthlyHouseholdIncome.sendKeys("40000");
		
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("profession"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("finance"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("cpcOpted"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("cpcNo"))));
		
		//cash payment
		WebElement cashPayment= driver.findElement(By.xpath(pr.getProperty("cashPayment")));
		cashPayment.sendKeys("500");
		
		//monthly debt
		WebElement debt= driver.findElement(By.xpath(pr.getProperty("debt")));
		debt.sendKeys("1000");
		
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("internalCode"))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("internalCode0"))));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue_additional_details"))));
		
		//education
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("bachelors"))));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue_education"))));
		Thread.sleep(2000);
		
		//joining fee
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("joiningFeeYes"))));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue_joiningFee"))));
		Thread.sleep(1000);
		
		//continue review screen
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue_review"))));
		
		
		
	}
}
