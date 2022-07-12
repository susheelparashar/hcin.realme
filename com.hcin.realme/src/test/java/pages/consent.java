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

public class consent {

	Properties pr;
	ChromeDriver driver;

	public consent(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}
	
	public void scrollIntoView(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
	}
	public void elementToBeClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		wait.until(ExpectedConditions.elementToBeClickable(element));
				
	}

	public void verifyOtp() throws InterruptedException, ClassNotFoundException, SQLException, IOException {
		String mobile = "6646541321";

		// consent form
		WebElement requestOtp = driver.findElement(By.xpath(pr.getProperty("requestOtp")));
		scrollIntoView(requestOtp);
		elementToBeClickable(requestOtp);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestOtp);

		// enter consent otp
		DBManager dm = new DBManager(driver, pr);
		String otp = dm.getOtp(mobile);
		driver.findElement(By.xpath(pr.getProperty("enterOtp"))).sendKeys(otp);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("verifyOtp"))));
		System.out.println("otp verified successfully");
	}
}
