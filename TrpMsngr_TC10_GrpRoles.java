package TroopMessengerApp;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TrpMsngr_TC10_GrpRoles extends Troopbase{
	
		@Test(dataProvider="returnData_Login",priority='0')
		public void login(HashMap<String, String>ref) throws EncryptedDocumentException, IOException, InterruptedException, InvalidFormatException{
			
			System.out.println(ref.get("UserId"));
			extentTest=extentReport.createTest("LOGIN");
			TrpMsngrLoginScreenEle login=new TrpMsngrLoginScreenEle(driver);
			login.login(ref.get("UserId"), ref.get("Password"));
			Thread.sleep(30000);
				
		}
		
		@Test(dataProvider="returnData_Login",priority='1')
		public void searchgrp(HashMap<String, String>ref) throws Exception
		{
			extentTest=extentReport.createTest("SEARCH GROUP WITH NAME");
			GroupRoleEle grp =new GroupRoleEle(driver);
			grp.GroupRole(ref.get("GrpName"));
		}
		@Test(priority='2')
		public void profPicClk() throws InterruptedException
		{
			GroupRoleEle grp =new GroupRoleEle(driver);
			grp.profPicClk();
		}
		
		/*@Test(dataProvider="returnData_Login",priority='3')
			public void editGrpName(HashMap<String, String>ref) throws InterruptedException
		{
			extentTest=extentReport.createTest("EDIT GROUP NAME");
			GroupRoleEle grp =new GroupRoleEle(driver);
			grp.editNme(ref.get("EgrpName"));
		}*/
		
		@Test(dataProvider="returnData_Login" ,priority='4')
		public void members(HashMap<String, String>ref) throws Exception
		{
			GroupRoleEle grp =new GroupRoleEle(driver);
			extentTest=extentReport.createTest("Group_Members");
			grp.memebersCount();
			grp.member_CountValidation();
			grp.back();
			Thread.sleep(1000);
			grp.profPicClk();
			extentTest=extentReport.createTest("Admin opt validations");
			grp.adminOpt(ref.get("UserId"));
			
		}
		@Test(priority='5')
		public void roles() throws Exception {
			GroupRoleEle grp =new GroupRoleEle(driver);
			extentTest=extentReport.createTest(" Assigning Group_Members roles");
			grp.assgning();
		}

		
	@DataProvider
	public Object[][] returnData_Login() throws InvalidFormatException, IOException{
		return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","Login");
	}
}
