package package1;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

public class Login extends AppStart {
	
	@Test(dataProvider="text",dataProviderClass= ExcelsheetData.class)
	public void mrandmrsLogin(HashMap<String, String> hash) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		PageElements login=new PageElements(driver);
		
		 login.phonenumber(hash.get("PhoneNumber"));
		 login.nextButton();
		 logger.info("PhoneNumber field filled Successfully");
		 Thread.sleep(1500);
		 login.emailpwd(hash.get("EmailPassword"));
		 login.nextButton();
		 logger.info("Login successfully");
		 
		 login.allow();
		 logger.info("App allowed permissions");
		 Thread.sleep(500);
		 Thread.sleep(4000);
		 login.clickInMap();
		 Thread.sleep(500);
		 login.whereTo(hash.get("Location"));
		 Thread.sleep(500);
		 login.locationDone();
		 logger.info("Location searched");
		 System.out.println("Home Location==> "+hash.get("HomeLocation"));
		 Thread.sleep(1000);
		 login.clickInMap();
		 Thread.sleep(1000);
		 login.home();
		 Thread.sleep(2000);
		 try {
				 addDetails(hash.get("HomeLocation"));
				 Thread.sleep(2000);
		 }
		 catch(Exception e) {
			 System.out.println("Home Location Exception");
			 e.printStackTrace();
		 }
		 Thread.sleep(2000);
		 login.clickInMap();
		 Thread.sleep(1000);
		 login.addWork();
		 Thread.sleep(1000);
		 try{
			 
			 addDetails(hash.get("AddLocation"));
			 logger.info("Added work in"+hash.get("AddLocation")+"Location ");
			 Thread.sleep(1000);
		    }catch(Exception e) {
				e.printStackTrace();
			}
		 Thread.sleep(1000);
		 login.clickInMap();
		 Thread.sleep(2000);
		 login.savedPlaces();
				
		 try {
			 
			 addDetails(hash.get("Location"));
			 logger.info("Added work in"+hash.get("Location")+"Location ");
			 }catch(Exception e) {
				 e.printStackTrace();
				 
			 }
	}
	
		public void addDetails(String loc) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
			PageElements login2=new PageElements(driver);
			Thread.sleep(1000);
			login2.whereTo(loc);
			
			try {
				 Thread.sleep(1000);		
			     login2.locationDone();
			     Thread.sleep(1000);
			     login2 .additionalDetails();
			
			}catch(Exception e) {
					 e.printStackTrace();
					 
				 }

	}

	 
	
}


	
	


