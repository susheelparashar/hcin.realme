package testScripts;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import base.baseClass;
import pages.POS;
import pages.clientDetails;
import pages.consent;
import pages.dashboard;
import pages.login;
import utilities.testdataGenerator;

public class test extends baseClass {
	
	@Test
	 public void TestSessionStorage() throws IOException, ClassNotFoundException, InterruptedException, SQLException
	 {
		
		Faker faker = new Faker(new Locale("en-IND"));
		String fullname=faker.name().firstName()+" "+faker.name().lastName();
		String email=faker.name().firstName()+faker.name().lastName()+"@gmail.com";
		String fathername=faker.name().firstName()+" "+faker.name().lastName();
		String mothername=faker.name().firstName()+" "+faker.name().lastName();
		String building=faker.address().cityPrefix();
		String street=faker.address().streetName();
		String locality=faker.address().streetSuffix();
		String pincode=faker.address().zipCode();
		String floor=faker.address().buildingNumber();
		String landmark=faker.address().lastName();
		
		
		testdataGenerator tdg=new testdataGenerator();
		String mobile=tdg.generateMobNum();
		String refMobile1=tdg.generateMobNum();
		String refMobile2=tdg.generateMobNum();
		String dob=tdg.generateDOB();
		String panNo=tdg.generatePANno();
		
			
		//login
		login li=new login(driver, pr);
		li.signin("susheel.parashar", "Bbcl@123");
		
		//pos selection
		POS po=new POS(driver, pr);
		po.selectPOS();
		
		//select apply for ujjwal card
		dashboard d=new dashboard(driver, pr);
		d.ApplyUjjwalCard();
		
		//client details
		clientDetails cd=new clientDetails(driver, pr);
		cd.personalDetails(mobile, dob, fullname, email);
		
		//consent
		consent c=new consent(driver, pr);
		c.verifyOtp(mobile);
		
		//get session storage data
		SessionStorage s=new SessionStorage(driver, pr);
	 }
}
