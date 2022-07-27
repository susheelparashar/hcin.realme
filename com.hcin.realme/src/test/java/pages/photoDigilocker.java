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

public class photoDigilocker {

	Properties pr;
	ChromeDriver driver;

	public photoDigilocker(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}

	public void visibilityOfElementLocated(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		wait.until(ExpectedConditions.visibilityOf(element));
				
	}

	public void elementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void capturePhoto() throws InterruptedException, ClassNotFoundException, SQLException, IOException {

		// photo
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("photo_digilocker"))));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("cont_photo"))));
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("capture_Photo"))));
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("confirm_photo"))));
		System.out.println("photo captured successfully");
		Thread.sleep(2000);

	}
}
