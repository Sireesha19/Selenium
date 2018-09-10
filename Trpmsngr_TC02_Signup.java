package TroopMessengerApp;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Trpmsngr_TC02_Signup extends Troopbase {
	
	String val,val1;

	@Test(dataProvider="returnData_SignUp",priority=0)
		public void signUp(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		TrpMsngrSignUpScreenEle  obj=new TrpMsngrSignUpScreenEle(driver);
		extentTest=extentReport.createTest("SignUp-CompanyDetails");
		val=obj.signUpForm1(ref.get("Company"), ref.get("YourName"),ref.get("PhoneNumber"),ref.get("Email") , ref.get("Country"));
		System.out.println("Gotta msg is ==========="+val);
		extentTest.log(Status.PASS,MarkupHelper.createLabel("Feedback Message is :"+val, color.BLUE));
		
		
}
	@Test(dataProvider="returnData_SignUp",priority=1)
	public void signUpForm2(HashMap<String, String>ref) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{

		extentTest=extentReport.createTest("SignUp-PasswordSet");
		TrpMsngrSignUpScreenEle  obj=new TrpMsngrSignUpScreenEle(driver);
		val1=obj.signupForm2(ref.get("Password"), ref.get("Cpassword"));
		System.out.println("Gotta msg is ==========="+val1);
		extentTest.log(Status.PASS,MarkupHelper.createLabel("Feedback Message is :"+val1, color.BLUE));
		
	}
	@DataProvider
	public Object[][] returnData_SignUp() throws  IOException, InvalidFormatException{
		return TrpMsngrExcelFile.getData("/home/sireesha/TrpMsngripData.xlsx","Signup");
	}
}
