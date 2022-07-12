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

public class cappSms {

	Properties pr;
	ChromeDriver driver;

	public cappSms(ChromeDriver driver, Properties pr)
	{
		this.driver=driver;
		this.pr=pr;
	}
	public void elementToBeClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		wait.until(ExpectedConditions.elementToBeClickable(element));
				
	}

	public void clickCappPopup() throws InterruptedException, ClassNotFoundException, SQLException, IOException {
		// click capp sms popup
		Thread.sleep(500);
		WebElement cappPopup = driver.findElement(By.xpath(pr.getProperty("cappPopup")));
		elementToBeClickable(cappPopup);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", cappPopup);
		System.out.println("capp popup clicked ");
	}
}
