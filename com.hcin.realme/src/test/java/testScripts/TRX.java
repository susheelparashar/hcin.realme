package testScripts;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import base.baseClass;
import pages.POS;
import pages.VAS;
import pages.additionalDetails;
import pages.address;
import pages.cappSms;
import pages.clientDetails;
import pages.commoditySelection;
import pages.consent;
import pages.dashboard;
import pages.login;
import pages.offers;
import pages.pan;
import pages.photo;
import pages.startTransaction;
import pages.verifyCustomerDetails;

public class TRX extends baseClass{
	@Test
	public void test() throws InterruptedException, IOException, ClassNotFoundException, SQLException
	{
			
		//login
		login li=new login(driver, pr);
		li.signin("homerselect", "homerselect");
		
		//pos selection
		POS po=new POS(driver, pr);
		po.selectPOS();
		
		//select initiate Purchase
		dashboard d=new dashboard(driver, pr);
		d.initiatePurchase();
		
		//start transaction
		startTransaction st=new startTransaction(driver, pr);
		st.verifyContract();
		
		//verify customer details
		verifyCustomerDetails vcd= new verifyCustomerDetails(driver, pr);
		vcd.verifyDetails();
		
		//commodity selection
		commoditySelection cs=new commoditySelection(driver, pr);
		cs.selectCommodity();
		cs.verifyCommodity();		
		
		//commodity selection
		offers o=new offers(driver, pr);
		o.selectOffer();
		
		//select VAS
		VAS v=new VAS(driver, pr);
		v.selectOnsiteGoScreenProtection();
	}

}
