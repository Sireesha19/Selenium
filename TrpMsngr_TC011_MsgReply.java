package TroopMessengerApp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TrpMsngr_TC011_MsgReply extends Troopbase  {
	
		@Test(dataProvider="returnData_Login",priority=0)
		public void login(HashMap<String, String>ref) throws EncryptedDocumentException, IOException, InterruptedException, InvalidFormatException {
			extentTest=extentReport.createTest("LOGIN");
			System.out.println(ref.get("UserId"));
			TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
			login.login(ref.get("UserId"), ref.get("Password"));
					
		}
		
		@Test(dataProvider="returnData_Login",priority=1)
		public void messagReply(HashMap<String, String>ref) throws Exception {
			extentTest=extentReport.createTest("MESSAGE_REPLY AND VERIFY");
			TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
			login.searchUser(ref.get("GrpName"));
			GroupRoleEle grp=new GroupRoleEle(driver);
			grp.fstMesg();
			grp.reply(ref.get("Message"));
			grp.sendMsgBtn.click();
			String formatdate=grp.systemTime();
			login.getMsg(ref.get("Message"),formatdate);
			
			
			
		}
		@Test(dataProvider="returnData_Login",priority=2)
		public void messageFrwd(HashMap<String, String>ref) throws Exception {
			extentTest=extentReport.createTest("MESSAGE_FORWARD AND VERIFY");
			GroupRoleEle grp=new GroupRoleEle(driver);
			TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
			//login.searchUser(ref.get("MsgOpter"));
			grp.fstMesg();
			grp.forward();
			Thread.sleep(2000);
			Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Given User to search while forward message----"+ref.get("msgFrwdOpter"), Troopbase.color.TEAL));
			driver.findElementById("com.tvisha.troopmessenger:id/searchContact").sendKeys(ref.get("msgFrwdOpter"));
			login.prediction(ref.get("msgFrwdOpter"));
			driver.findElementById("com.tvisha.troopmessenger:id/actionSend").click();
			String formatdate=grp.systemTime();
			Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("System date after send button clicked----"+formatdate, Troopbase.color.BROWN));
			grp.back();
			Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Given User to search while forward message for verification----"+ref.get("msgFrwdOpter"), Troopbase.color.TEAL));
			login.searchUser(ref.get("msgFrwdOpter"));
			login.getMsg(ref.get("Message"),formatdate);
		}
		
		/*@Test(dataProvider="returnData_Login",priority=3)
		public void copy(HashMap<String, String>ref) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
			extentTest=extentReport.createTest("MESSAGE_COPY AND VERIFY");
			GroupRoleEle grp=new GroupRoleEle(driver);
			TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
			login.searchUser(ref.get("MsgOpter"));
			grp.fstMesg();
			grp.copy();
			
			
		}*/
	
		
		
		@DataProvider
		public Object[][] returnData_Login() throws InvalidFormatException, IOException{
			return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","Login");
		}

}
