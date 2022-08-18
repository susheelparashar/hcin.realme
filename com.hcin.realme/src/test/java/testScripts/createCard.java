package testScripts;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import base.baseClass;
import pages.POS;
import pages.additionalDetails;
import pages.address;
import pages.addressDigilocker;
import pages.cappSms;
import pages.clientDetails;
import pages.consent;
import pages.dashboard;
import pages.digilocker;
import pages.login;
import pages.pan;
import pages.photo;
import pages.photoDigilocker;
import utilities.testdataGenerator;

public class createCard extends baseClass{
	@Test
	public void test() throws InterruptedException, IOException, ClassNotFoundException, SQLException
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
		
		//capp sms 
		cappSms cs=new cappSms(driver, pr);
		cs.clickCappPopup();
		
		//capture photo
		photoDigilocker ph=new photoDigilocker(driver, pr);
		ph.capturePhoto();
		
		//cancel digilocker
		digilocker digi=new digilocker(driver, pr);
		digi.cancelDigilocker();
		
		//capture pan
		pan	p=new pan(driver, pr);
		p.capturePan(panNo, fathername, mothername);
		
		//capture address
		address	ad=new address(driver, pr);
		ad.captureAddress();
		
		//capture additional details
		additionalDetails addi=new additionalDetails(driver, pr);
		addi.captureAdditionalDetails(refMobile1, refMobile2);
				
	}

}
