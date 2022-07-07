package pages;

import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import utilities.scrollPage;

public class signup {
	
	Properties pr;
	ChromeDriver driver;
	
	public signup(ChromeDriver driver, Properties pr)
	{
		this.driver=driver;
		this.pr=pr;
	}
	
	public void click() {
		boolean staleElement = true; 
		while(staleElement){
	    try{
	   	  driver.findElement(By.xpath(pr.getProperty("mobile_next"))).click();
   	      staleElement = false;
		  } 
	    catch(StaleElementReferenceException e){
		    staleElement = true;
		  }

		}
	}
	public void creatAccount() throws InterruptedException
	{
		//random user data creator
		Faker faker = new Faker();
		String firstname= faker.name().firstName();
		String lastname= faker.name().lastName();
		String username=faker.superhero().prefix()+faker.name().firstName()+faker.address().buildingNumber();
		String password="bbcl@123";
		String mobileNo="9205019755";
		
		//open url and provide data
		driver.get(pr.getProperty("url"));
		driver.findElement(By.xpath(pr.getProperty("firstname"))).sendKeys(firstname);
		driver.findElement(By.xpath(pr.getProperty("lastname"))).sendKeys(lastname);
		driver.findElement(By.xpath(pr.getProperty("username"))).sendKeys(username);
		driver.findElement(By.xpath(pr.getProperty("passwd"))).sendKeys(password);
		driver.findElement(By.xpath(pr.getProperty("confirm-passwd"))).sendKeys(password);
		driver.findElement(By.xpath(pr.getProperty("next"))).click();
		
		//enter mobile no
		driver.findElement(By.xpath(pr.getProperty("mobileNumber"))).sendKeys(mobileNo);
		
		//click next
		click();		
			
		//enter verification code
		Scanner s = new Scanner(System.in); 
		System.out.println("enter the verification code: ");
		String code=s.nextLine();
		driver.findElement(By.xpath(pr.getProperty("verificationCode"))).sendKeys(code);
		driver.findElement(By.xpath(pr.getProperty("verify"))).click();
		
		//enter DOB
		driver.findElement(By.xpath(pr.getProperty("day"))).sendKeys("01");
		Select drpMonth=new Select(driver.findElement(By.xpath(pr.getProperty("month"))));
		drpMonth.selectByVisibleText("January");
		driver.findElement(By.xpath(pr.getProperty("year"))).sendKeys("2000");
		
		//select gender
		Select drpGender=new Select(driver.findElement(By.xpath(pr.getProperty("gender"))));
		drpGender.selectByVisibleText("Male");
		
		//click next
		click();	
		
		//click
		driver.findElement(By.xpath(pr.getProperty("YesIamIn"))).click();
		Thread.sleep(5000);
		//scrollDown till i agree button and click on i agree
		WebElement ele=driver.findElement(By.xpath(pr.getProperty("Iaggree")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);
		
        //scrollPage sp=new scrollPage(driver, pr);
		
		/*sp.scrollIntoView(ele);
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele)); 
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
		
		*/
	}
	

}
