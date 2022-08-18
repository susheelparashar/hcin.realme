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
import pages.cutsomerWishes;
import pages.dashboard;
import pages.imeiSerialNumber;
import pages.invoiceDetails;
import pages.login;
import pages.offers;
import pages.pan;
import pages.photo;
import pages.reviewTransaction;
import pages.signLoanDocuments;
import pages.startTransaction;
import pages.verifyCustomerDetails;

public class TRX_CD extends baseClass {
	@Test
	public void test() throws InterruptedException, IOException, ClassNotFoundException, SQLException {
		String mobile = "9205755416";
		String contractCode = "4200081127";

		// login
		login li = new login(driver, pr);
		li.signin("susheel.parashar", "Bbcl@123");

		// pos selection
		POS po = new POS(driver, pr);
		po.selectPOS();

		// select initiate Purchase
		dashboard d = new dashboard(driver, pr);
		d.initiatePurchase();

		// start transaction
		startTransaction st = new startTransaction(driver, pr);
		st.verifyContract(mobile, contractCode);

		
		//verify customer details 
		verifyCustomerDetails vcd= new verifyCustomerDetails(driver, pr); 
		vcd.verifyDetails();
		  
		//commodity selection 
		commoditySelection cs=new commoditySelection(driver,pr); 
		cs.selectMobile(); 
		cs.verifyCommodity();
		  
		//commodity selection 
		offers o=new offers(driver, pr);
		o.selectStandardOffers();
		  
		//only commodity 
		cutsomerWishes cw=new cutsomerWishes(driver, pr);
		cw.onlyCommodity();
		  
		//review transaction 
		reviewTransaction rt=new reviewTransaction(driver, pr);
		rt.review();
		  
		//imei screen
		imeiSerialNumber is=new imeiSerialNumber(driver, pr);
		is.captureImeiSn();
		 
		// invoice screen
		invoiceDetails invoice=new invoiceDetails(driver, pr);
		invoice.captureInvoice();
		  
		//signLoanDocuments
		signLoanDocuments sign=new signLoanDocuments(driver, pr);
		sign.pushForCappSigningCD();

	}

}
