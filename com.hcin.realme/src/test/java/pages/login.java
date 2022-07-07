package pages;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DBManager;

public class login {
	
	Properties pr;
	ChromeDriver driver;
	
	public login(ChromeDriver driver, Properties pr)
	{
		this.driver=driver;
		this.pr=pr;
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
	public void visibilityOfElementLocated(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		wait.until(ExpectedConditions.visibilityOf(element));
				
	}
	public void visibilityOfAllElements(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
				
	}
			
	public void signin(String username, String password) throws InterruptedException, ClassNotFoundException, SQLException, IOException
	{
		String mobile="6774667576";
		driver.get(pr.getProperty("urluat"));
		//login
		driver.findElement(By.xpath(pr.getProperty("username"))).sendKeys(username);
		driver.findElement(By.xpath(pr.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(pr.getProperty("login"))).click();
		driver.findElement(By.xpath(pr.getProperty("redirect"))).click();
		
		//select POS
		driver.findElement(By.xpath(pr.getProperty("selectPos"))).click();
		driver.findElement(By.xpath(pr.getProperty("continue"))).click();
		
		//select apply for ujjwal card
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(pr.getProperty("applyForUjjwalCard"))))).click();
		
		//enter mobile number
		driver.findElement(By.xpath(pr.getProperty("mobileNumber"))).sendKeys(mobile);
		driver.findElement(By.xpath(pr.getProperty("continue1"))).click();
		
		//details
		driver.findElement(By.xpath(pr.getProperty("name"))).sendKeys("ram");
		driver.findElement(By.xpath(pr.getProperty("email"))).sendKeys("susheel.parashar@homecredit.co.in");
		driver.findElement(By.xpath(pr.getProperty("dob"))).sendKeys("22/11/2000");
		Thread.sleep(5000);
		
		//scrolldown
		WebElement mobileLinkedNo=driver.findElement(By.xpath(pr.getProperty("mobileLinkedNo")));
		scrollIntoView(mobileLinkedNo);
		mobileLinkedNo.click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(pr.getProperty("bank"))).click();
		driver.findElement(By.xpath(pr.getProperty("hdfc"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(pr.getProperty("language"))).click();
		driver.findElement(By.xpath(pr.getProperty("eng"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(pr.getProperty("tick"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(pr.getProperty("cont_details"))).click();
		
		//consent form
		WebElement requestOtp=driver.findElement(By.xpath(pr.getProperty("requestOtp")));
		scrollIntoView(requestOtp);
		elementToBeClickable(requestOtp);
		requestOtp.click();
		
		//enter consent otp
		DBManager dm=new DBManager(driver, pr);
		dm.getOtp(mobile);
		driver.findElement(By.xpath(pr.getProperty("enterOtp"))).sendKeys(dm.getOtp(mobile));
		Thread.sleep(1000);
		driver.findElement(By.xpath(pr.getProperty("verifyOtp"))).click();
		 
		//click capp otp popup
		WebElement cappPopup=driver.findElement(By.xpath(pr.getProperty("cappPopup")));
		elementToBeClickable(cappPopup);
		cappPopup.click();
		
		//photo
		driver.findElement(By.xpath(pr.getProperty("photo"))).click();
		Thread.sleep(5000);
		WebElement cont_photo=driver.findElement(By.xpath(pr.getProperty("cont_photo")));
		elementToBeClickable(cont_photo);
		visibilityOfElementLocated(cont_photo);
		cont_photo.click();
		driver.findElement(By.xpath(pr.getProperty("capturePhoto"))).click();
		WebElement confirm_photo=driver.findElement(By.xpath(pr.getProperty("confirm_photo")));
		elementToBeClickable(confirm_photo);
		confirm_photo.click();
		
		//pan
		driver.findElement(By.xpath(pr.getProperty("pan"))).click();
		Thread.sleep(5000);
		WebElement capture_pan=driver.findElement(By.xpath(pr.getProperty("capture_pan")));
		scrollIntoView(capture_pan);
		driver.findElement(By.xpath(pr.getProperty("checkBoxPan"))).click();
		capture_pan.click();
		
	}

	
}
