package utilities;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdownSelect {
	
	Properties pr;
	ChromeDriver driver;
		
	public dropdownSelect(ChromeDriver driver, Properties pr)
	{
		this.driver=driver;
		this.pr=pr;
	}
	
	public void selectByIndex(int i, String locator)
	{
		Select drpMonth=new Select(driver.findElement(By.xpath(pr.getProperty(locator))));
		drpMonth.selectByIndex(i);
	}
	public void selectByValue(String i)
	{
		Select drpMonth=new Select(driver.findElement(By.xpath(pr.getProperty("month"))));
		drpMonth.selectByValue(i);
	}
	public void selectByVisibleText(String i)
	{
		Select drpMonth=new Select(driver.findElement(By.xpath(pr.getProperty("month"))));
		drpMonth.selectByVisibleText(i);
	}
}
