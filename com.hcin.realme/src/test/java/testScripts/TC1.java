package testScripts;

import java.io.IOException;
import java.sql.SQLException;

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

public class TC1 extends baseClass{
	@Test
	public void test() throws InterruptedException, IOException, ClassNotFoundException, SQLException
	{
			
		//login
		login li=new login(driver, pr);
		li.signin("homerselect", "homerselect");
		
		
		
	}

}
