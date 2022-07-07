package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class logout {
	
	Properties pr;
	ChromeDriver driver;
	
	public logout(ChromeDriver driver, Properties pr)
	{
		this.driver=driver;
		this.pr=pr;
	}
	
	public void signout() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@id='avatar-btn']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='/logout']")).click();
		Thread.sleep(2000);
	}

}
