package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class POS {
	
	Properties pr;
	ChromeDriver driver;
	
	public POS(ChromeDriver driver, Properties pr)
	{
		this.driver=driver;
		this.pr=pr;
	}
	public void selectPOS() throws InterruptedException
	{
		//select POS
		driver.findElement(By.xpath(pr.getProperty("selectPos"))).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(pr.getProperty("continue"))).click();
		System.out.println("select test salesroom POS ");	
	}
}
