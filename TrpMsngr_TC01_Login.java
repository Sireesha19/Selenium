package TroopMessengerApp;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import TroopMessengerApp.TrpMsngrExcelFile;
import TroopMessengerApp.TrpMsngrLoginScreenEle;
import io.appium.java_client.android.AndroidElement;

public class TrpMsngr_TC01_Login extends Troopbase {
	@Test(dataProvider="returnData_Login")
	public void login(HashMap<String, String>ref) throws EncryptedDocumentException, IOException, InterruptedException, InvalidFormatException{
		extentTest=extentReport.createTest("LOGIN");
		System.out.println(ref.get("UserId"));
		TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
		
		login.login(ref.get("UserId"), ref.get("Password"));
		
	}
	@Test(dataProvider="returnData_Login")
	public void sendMsg(HashMap<String, String>ref) throws Exception {
		extentTest=extentReport.createTest("SEARCHING USER");
		TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
			login.searchUser(ref.get("Receiver"));
			login.sendMsg(ref.get("Message"));
		}
	

	@DataProvider
	public Object[][] returnData_Login() throws InvalidFormatException, IOException{
		return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","Login");
	}
	

}
