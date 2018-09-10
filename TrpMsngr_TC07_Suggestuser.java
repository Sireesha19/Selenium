package TroopMessengerApp;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TrpMsngr_TC07_Suggestuser extends Troopbase {

	@Test(dataProvider="returnData_Login",priority=0)
	public void login(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
		System.out.println(ref.get("UserId"));
		extentTest=extentReport.createTest("LOGIN");
		TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
		login.login(ref.get("UserId"), ref.get("Password"));
		
	}
	
	@Test(priority=1)
	public void addUserBtn() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		extentTest=extentReport.createTest("ADD USERS SCENARIO");
		
		TrpMsngrProfileScreenEle a=new TrpMsngrProfileScreenEle(driver);
		a.addUserClk();
		Thread.sleep(3000);
	}
	int n=0;
	@Test(dataProvider="returnData_addUser",priority=2)
			public void adduser(HashMap<String, String>ref) throws Exception {
				TrpMsngrProfileScreenEle a=new TrpMsngrProfileScreenEle(driver);
				System.out.println("=======>n val"+n+"=====>name is"+ref.get("Uname"));
				a.addUsers(ref.get("Uname"), ref.get("Email"),n);
		
		n=n+1;

	}
	/*@Test(priority=3)
	public void add() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		TrpMsngrProfileScreenEle a=new TrpMsngrProfileScreenEle(driver);
		
		
	}*/
	
	@DataProvider
	public Object[][] returnData_Login() throws InvalidFormatException, IOException{
		return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","Login");
	}
	
	@DataProvider
	public Object[][] returnData_addUser() throws InvalidFormatException, IOException{
		return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","adduser");
	}

}
