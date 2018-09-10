package TroopMessengerApp;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Trpmsngr_TC09_GetMessage extends Troopbase {
	
	@Test(dataProvider="returnData_Login",priority=0)
	public void login(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
		System.out.println(ref.get("UserId"));
		extentTest=extentReport.createTest("LOGIN");
		TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
		login.login(ref.get("UserId"), ref.get("Password"));
		
	}
	
	
	@Test(dataProvider="returnData_SendMsg",priority=1)
	public void getMsg(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
		extentTest=extentReport.createTest("GET MESSAGE FROM CHAT");
		login.searchUser(ref.get("Sender"));
		String formatdate=login.sendMsg(ref.get("Message"));
		login.getMsg(ref.get("Message"),formatdate);
		
			}                                                                                                             
	
	@DataProvider
	public Object[][] returnData_Login() throws InvalidFormatException, IOException{
		return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","ReceiverData");
	}
	@DataProvider
	public Object[][] returnData_SendMsg() throws InvalidFormatException, IOException{
		return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","Login");
	}

}
