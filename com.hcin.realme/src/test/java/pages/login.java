package pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
	
	Properties pr;
	ChromeDriver driver;
	
	public login(ChromeDriver driver, Properties pr)
	{
		this.driver=driver;
		this.pr=pr;
	}
			
	public void signin(String username, String password) throws InterruptedException, ClassNotFoundException, SQLException, IOException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		driver.get(pr.getProperty("urluat"));
		//login
		driver.findElement(By.xpath(pr.getProperty("username"))).sendKeys(username);
		driver.findElement(By.xpath(pr.getProperty("password"))).sendKeys(password);
		Thread.sleep(500);
		driver.findElement(By.xpath(pr.getProperty("login"))).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(pr.getProperty("redirect"))).click();
		
	}

	
}
