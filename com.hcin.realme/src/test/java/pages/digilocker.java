package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class digilocker {
	Properties pr;
	ChromeDriver driver;

	public digilocker(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}

	public void cancelDigilocker() throws InterruptedException {
		// address verification
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",
				driver.findElement(By.xpath(pr.getProperty("addressVerificationDigilocker"))));
		Thread.sleep(1000);
		driver.get("https://invx-np-realme01.in.nonprod:8443/realme/newCustomer");
		
		/*
		// click on online KYC
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("onlineKyc"))));
		// click on consent
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("onlineKycConsent"))));
		// click on continue
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("continue_onlineKyc"))));
		// click on cancel
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("cancelOnlineKyc"))));
		// click on confirm cancel
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(pr.getProperty("confirmCancellation"))));
		*/
	}

}
