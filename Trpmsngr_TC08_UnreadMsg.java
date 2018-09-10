package TroopMessengerApp;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class Trpmsngr_TC08_UnreadMsg extends Troopbase{
	@Test(dataProvider="returnData_Login")
	public void login(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
		System.out.println(ref.get("UserId"));
		extentTest=extentReport.createTest("LOGIN");
		TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
		login.login(ref.get("UserId"), ref.get("Password"));
	
	}
	@Test
	public void unread() throws Exception {
		extentTest=extentReport.createTest("UNREAD MESSAGES SCENARIO");
		TrpMsngrLoginScreenEle obj=new TrpMsngrLoginScreenEle(driver);
	
		int c1=obj.scrolling();
		int c2=obj.unreadmsgs();
		
		if(c1==c2) {
			System.out.println("==========>Unread msgs count is equal"+c1+"     "+c2);
			Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("unread messages count in userChat--"+c1+" Actual Unread messages count--"+c2 +" Equals ,Unread messages count get successfully", Troopbase.color.BLUE));
		}
		else {
			System.out.println("==========>Unread msgs count is not equal"+c1+"     "+c2);
			Troopbase.extentTest.log(Status.FAIL, MarkupHelper.createLabel("unread messages count in userChat--"+c1+" Actual Unread messages count--"+c2 +" NotEquals, Unread messages count not get ", Troopbase.color.RED));
		}
		
		
		
	}
	
	
	
	@DataProvider
	public Object[][] returnData_Login() throws InvalidFormatException, IOException{
		return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","Login");
	}

}
