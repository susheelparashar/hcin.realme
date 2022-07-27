package pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POS {

	Properties pr;
	ChromeDriver driver;

	public POS(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}
	
	public void elementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void selectPOS() throws InterruptedException {
		// zoom out
		System.out.println("star zooming out");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '70%'");

		// select POS
		WebElement selectTestSalesroom=driver.findElement(By.xpath(pr.getProperty("selectTestSalesroom")));
		js.executeScript("arguments[0].click();", selectTestSalesroom);
		
		WebElement continue_pos=driver.findElement(By.xpath(pr.getProperty("continue_pos")));
		js.executeScript("arguments[0].click();", continue_pos);
		System.out.println("select test salesroom POS ");
	}
}
