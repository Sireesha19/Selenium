package package1;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Registration extends AppStart{
	
	
	@Test(dataProvider="text",dataProviderClass = ExcelsheetData.class)
	 public void testcase1(HashMap<String,String> hash) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
		System.out.println(hash.get("PhoneNumber"));
		PageElements obj=new PageElements(driver);
		
			 obj.phonenumber(hash.get("PhoneNumber"));
			 obj.nextButton();
			 logger.info("PhoneNumber field filled Successfully");
			 try {
				 obj.otp(hash.get("Otp"));
				 obj.otpNext();
				 obj.email(hash.get("Email"));
				 obj.nextButton();
				 Thread.sleep(1200);
				 obj.emailpwd(hash.get("EmailPassword"));
				 obj.nextButton();
				 Thread.sleep(2000);
				 obj.firstName(hash.get("Fname"));
				 obj.lastName(hash.get("Lname"));
				 obj.nextButton();
				 obj.selectDropdown();
				 obj.countrySearch(hash.get("Country"));
				 Thread.sleep(1000);
				 obj.country();
				 obj.nextButton();
				 Thread.sleep(2000);
				 obj.gender();
				 obj.nextButton();
				 Thread.sleep(2000);
				 obj.done();
				 obj.setStyle(hash.get("Nationality"));
				 Thread.sleep(1500);
				 obj.setGender();
				 obj.setPayment();
				 obj.terms();
				 logger.warn("terms accepted");
				 obj.nextButton();
				 obj.allow();
				 obj.currentLocation();
			 }
			 catch(Exception e){
			 e.printStackTrace();
			 }
	
	 }

}
