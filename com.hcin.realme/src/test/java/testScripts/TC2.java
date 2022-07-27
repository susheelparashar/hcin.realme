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
import utilities.testdataGenerator;

public class TC2 extends baseClass{
	@Test
	public void test() throws InterruptedException, IOException, ClassNotFoundException, SQLException
	{
		
		testdataGenerator tdg=new testdataGenerator();
        tdg.generateMobNum();
        tdg.generatePANno();
        tdg.generatePassportNo();
        tdg.generateDrivingLicense();
        tdg.generateDOB();
        
	}

}
