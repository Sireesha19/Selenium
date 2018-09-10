package TroopMessengerApp;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TrpMsngr_TC06_NewGrp extends Troopbase {

	
		@Test(dataProvider="returnData_Login",priority=0)
		public void login(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
			
			System.out.println(ref.get("UserId"));
			extentTest=extentReport.createTest("LOGIN");
			TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
			login.login(ref.get("UserId"), ref.get("Password"));
			
		}
	
		@Test(priority=1)
		public void createGrp() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
			extentTest=extentReport.createTest("ADD USERS TO NEW GROUP");
			TrpMsngrProfileScreenEle grp=new TrpMsngrProfileScreenEle(driver);
			System.out.println("===============>new group creation");
			grp.newGrpCreate();
		
			
		}
		
		@Test(dataProvider="returnData_Login",priority=2)
			public void profpic(HashMap<String , String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
			TrpMsngrProfileScreenEle grp=new TrpMsngrProfileScreenEle(driver);
			extentTest=extentReport.createTest("PROFILE PIC UPDATION");
			grp.prof_pic();
			extentTest=extentReport.createTest("NAMING NEW GROUP");
			grp.GrpName(ref.get("GrpName"));
		
			
		}
		
		
		@DataProvider
		public Object[][] returnData_Login() throws InvalidFormatException, IOException{
			return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","Login");
		}
		
		@DataProvider
		public Object[][] returnData_NewGrp() throws InvalidFormatException, IOException{
			return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","NewGroupData");
		}

}
