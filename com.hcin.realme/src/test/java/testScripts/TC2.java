package testScripts;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.baseClass;
import pages.POS;
import pages.additionalDetails;
import pages.address;
import pages.cappSms;
import pages.clientDetails;
import pages.consent;
import pages.dashboard;
import pages.login;
import pages.pan;
import pages.photo;

public class TC2 extends baseClass{
	@Test
	public void test() throws InterruptedException, IOException, ClassNotFoundException, SQLException
	{
		driver.get("https://www.google.com/search?q=virat+kohli+cricbuzz&rlz=1C1GCEA_enIN1012IN1012&oq=virat&aqs=chrome.0.69i59j46i131i433i512j69i57j46i131i433i512j0i131i433i512l2j0i433i512j0i512j0i131i433.45382j0j7&sourceid=chrome&ie=UTF-8");
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/div[3]/div/div/div")).click();
		
	}

}
