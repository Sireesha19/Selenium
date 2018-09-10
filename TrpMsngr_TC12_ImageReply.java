package TroopMessengerApp;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TrpMsngr_TC12_ImageReply extends Troopbase {
	
		@Test(dataProvider="returnData_Login",priority=0)
		public void login(HashMap<String, String>ref) throws EncryptedDocumentException, IOException, InterruptedException, InvalidFormatException {
			extentTest=extentReport.createTest("LOGIN");
			System.out.println(ref.get("UserId"));
			TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
			login.login(ref.get("UserId"), ref.get("Password"));
			Thread.sleep(4000);
					
		}
		
		@Test(dataProvider="returnData_Login",priority=1)
		public void imgReply(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
			extentTest=extentReport.createTest("IMAGE_REPLY WITH MESSAGE AND VERIFY");
			try {
			TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
			Thread.sleep(4000);
			login.searchUser(ref.get("GrpName"));
			GroupRoleEle grp=new GroupRoleEle(driver);
			
			grp.fstImg();
			grp.reply(ref.get("Message"));
			grp.sendMsgBtn.click();
			String formatdate=grp.systemTime();
			login.getMsg(ref.get("Message"),formatdate);
			}catch(Exception e) {}
			
		}
		@Test(dataProvider="returnData_Login",priority=2)
		public void messageFrwd(HashMap<String, String>ref) throws Exception {
			extentTest=extentReport.createTest("IMAGE_FORWARD TO USER AND VERIFY");
			//try {
			GroupRoleEle grp=new GroupRoleEle(driver);
			TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
			//login.searchUser(ref.get("MsgOpter"));
			grp.fstImg();
			grp.forward();
			Thread.sleep(2000);
			Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Given User to search while forward message----"+ref.get("msgFrwdOpter"), Troopbase.color.TEAL));
			driver.findElementById("com.tvisha.troopmessenger:id/searchContact").sendKeys(ref.get("msgFrwdOpter"));
			login.prediction(ref.get("msgFrwdOpter"));
			driver.findElementById("com.tvisha.troopmessenger:id/actionSend").click();
			String formatdate=grp.systemTime();
			Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("System date after send button clicked----"+formatdate, Troopbase.color.BROWN));
			try {
			grp.back();
			}catch(Exception e) { }
			Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Given User to search while forward message for verification----"+ref.get("msgFrwdOpter"), Troopbase.color.TEAL));
			login.searchUser(ref.get("msgFrwdOpter"));
			login.getMsg(ref.get("Message"),formatdate);
		//}catch(Exception e1) { }
		}
		
		@DataProvider                                                                  
		public Object[][] returnData_Login() throws InvalidFormatException, IOException{
			return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","Login");
		}
	}                        

