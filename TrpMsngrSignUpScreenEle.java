package TroopMessengerApp;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class TrpMsngrSignUpScreenEle {
	AndroidDriver driver;
	
	//Aftear launched
	
	@FindBy(id="com.tvisha.troopmessenger:id/iconWhyNoSignUp")
	public AndroidElement signUpBtn;
	
	@FindBy(id="com.tvisha.troopmessenger:id/iconForgotPassword")
	public AndroidElement forgotPwdBtn;
	
	//signup elements
	
	@FindBy(id="com.tvisha.troopmessenger:id/companyName")
	public AndroidElement companyName;
	
	@FindBy(id="com.tvisha.troopmessenger:id/userName")
	public AndroidElement yourName;
	
	@FindBy(id="com.tvisha.troopmessenger:id/userMobile")
	public AndroidElement mobileNumber;
	
	@FindBy(id="com.tvisha.troopmessenger:id/userEmail")
	public AndroidElement email;
	
	@FindBy(id="com.tvisha.troopmessenger:id/submitForm")
	public AndroidElement submitFm;
	
	@FindBy(id="com.tvisha.troopmessenger:id/actionLogin")
	public AndroidElement login;
	
	@FindBy(id="com.tvisha.troopmessenger:id/snackbar_text")
	public AndroidElement feedback;
	
	@FindBy(id="com.tvisha.troopmessenger:id/companyPassword")
	public AndroidElement pwd;
	
	@FindBy(id="com.tvisha.troopmessenger:id/companyConfirmPassword")
	public AndroidElement cpwd;
	
	@FindBy(id="com.tvisha.troopmessenger:id/agree_check_box")
	public AndroidElement termsChkbx;
	
	@FindBy(id="com.tvisha.troopmessenger:id/legal_policy_text")
	public AndroidElement policy;
	
	@FindBy(id="com.tvisha.troopmessenger:id/docView")
	public AndroidElement docview;
	
	@FindBy(id="com.tvisha.troopmessenger:id/actionBack")
	public AndroidElement backBtn;
	
	@FindBy(id="com.tvisha.troopmessenger:id/actionSignup")
	public AndroidElement signupBtn2;
	
	@FindBy(id="com.tvisha.troopmessenger:id/top_Ofview")
	public AndroidElement verify;
	
	@FindBy(id="com.tvisha.troopmessenger:id/imageView_arrow")
	public AndroidElement countryDD;
	
	@FindBy(id="com.tvisha.troopmessenger:id/editText_search")
	public AndroidElement countrySearch;
	
	@FindBy(id="com.tvisha.troopmessenger:id/textView_countryName")
	public List<AndroidElement> countryList;
	
	
	// Forgot-password screen elements
	
	@FindBy(id="com.tvisha.troopmessenger:id/userId")
	public AndroidElement forgotEmail;
	
	@FindBy(id="com.tvisha.troopmessenger:id/send")
	public AndroidElement forgotSendBtn;
	
	@FindBy(xpath="//android.widget.TextView[@text='Feedback')]")
	public AndroidElement feedBack;
		
	
					public TrpMsngrSignUpScreenEle(AndroidDriver driver) {
						this.driver=driver;
						PageFactory.initElements(new AppiumFieldDecorator(driver,6,TimeUnit.SECONDS), this);
					}
					
					
					public String signUpForm1(String cmpny,String name,String number,String mail,String country) throws InterruptedException
					{
						Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenData :\n"+cmpny+" ,"+name+","+mail+","+country,Troopbase.color.TEAL));
						String msg=null;
						try {
							Thread.sleep(2000);
						signUpBtn.click();
						companyName.sendKeys(cmpny);
						yourName.sendKeys(name);
						mobileNumber.sendKeys(number);
						countryDD.click();
						countrySearch.sendKeys(country);
						countryList.get(0).click();
						
						email.sendKeys(mail);
						submitFm.click();
						msg=feedback.getText();
						System.out.println(feedback.getText());
						Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Feedback message  :-"+msg,Troopbase.color.BLUE));
						}catch(Exception e) { }
						return msg;
					}
					public String signupForm2(String password,String cpassword) throws InterruptedException
					{	
						Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenData :"+password+"  ,"+cpassword,Troopbase.color.TEAL));
						String msg=null;
						try {
						Thread.sleep(2000);
						pwd.sendKeys(password);
						Thread.sleep(500);
						cpwd.sendKeys(cpassword);
						/*policy.click();
						if(docview.isDisplayed()) {
							System.out.println("policy page opened");
						}
						else {
							System.out.println("Not opened");
						}
						backBtn.click();*/
						//Thread.sleep(500);
						
						if(!termsChkbx.isSelected()) {
							termsChkbx.click();
						}
						//termsChkbx.click();
						
						
						signupBtn2.click();	
						Thread.sleep(2000);
						msg=feedback.getText();
						System.out.println(feedback.getText());
						Thread.sleep(4000);
						WebDriverWait wt=new WebDriverWait(driver, 20);
						wt.until(ExpectedConditions.visibilityOf(verify));
						boolean b=verify.isDisplayed();
						if(true) {
							Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Sign Up is successful",Troopbase.color.BLUE));
							System.out.println("SignUp is successful");
						}
						else {
							Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Sign Up is Unsuccessful",Troopbase.color.RED));
							System.out.println("SignUp is Unsuccessful");
						}
						
						}catch(Exception e) { }
						
						return msg;
					}
					
					public void forgotBtn() throws InterruptedException {
						Thread.sleep(2000);
						forgotPwdBtn.click();
					}
					
					public String forgotPasswd(String email,String check) throws InterruptedException {
						Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenData :"+email+","+check, Troopbase.color.TEAL));
						String val = null;
						String formattedDate=null;
						try {
					
						forgotEmail.sendKeys(email);
						forgotSendBtn.click();
					
							//Thread.sleep(950);
							val=verifyToast(driver);
							Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Get ToastMessage is :"+val , Troopbase.color.BROWN));
							System.out.println("============>"+val);
							val=validation(email,val,check);
	
					/*	}catch(Exception e) {
							Thread.sleep(2000);
							System.out.println(feedBack.getText());*/
							
						
						SimpleDateFormat dateFormat = new SimpleDateFormat("HH.mm");
						formattedDate = dateFormat.format(new Date()).toString();
						System.out.println(formattedDate);
					
						}catch(Exception e) { }
						return val+" ,"+formattedDate;
					}
					
					
					public static String verifyToast(AndroidDriver driver) throws IOException {

						String result = null;
						/*WebElement toastView = driver.findElement(By.xpath("//android.widget.Toast[1]"));
						String text = toastView.getAttribute("name");
						System.out.println("==============>"+text);*/
						File scrFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
						//FileUtils.copyFile(scrFile, new File("/home/sireesha/Desktop/sample"+System.currentTimeMillis()+".png"));
						ITesseract instance = new Tesseract();
						System.out.println("entered===>");
						instance.setDatapath("/home/sireesha/eclipse-workspace/Troopmanage/tessdata");
						instance.setLanguage("eng");
						try {
							result = instance.doOCR(scrFile);
						} catch (Exception e) {
							System.err.println(e.getMessage());
						}
						
						return result;
					}
					
					
					public String validation(String email,String ocrmsg, String validval) {
						Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Toast message on extracting Feedback Message", Troopbase.color.TEAL));
					
						
						String msg1="Email does not exists";
						String msg2="Enter Email";
						String msg3="Mail Sent Successfully!";
						String result=null;
						String res=null;
						try {						
						if(validval.contentEquals("Valid")) {
							Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenData :"+validval+" ,"+email+" ,"+"should get message  :"+msg3,    Troopbase.color.TEAL));
							Assert.assertEquals(validval, "Valid", "Msg valid");
							if(ocrmsg.contains(msg3)) {
								result="Successfully get the valid message";
								res=msg3;
								System.out.println("Message======>"+result);
								Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(" Message  :  "+res+" Successfully get the message",    Troopbase.color.BLUE));
							}
						}
						else {
							Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenData :"+validval+" ,"+email+" ,"+"should get message : "+msg1+"  or"+msg2,    Troopbase.color.TEAL));
							Assert.assertEquals(validval, "Invalid", "Msg Invalid");
							if(ocrmsg.contains(msg1)|| ocrmsg.contains(msg2)) {
								result="successfully get the invalid message";
								res=msg1+"  or   "+msg2;
							System.out.println("Message======>"+result);
							Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(" Message  : "+res+" Successfully get the invalid message",    Troopbase.color.RED));
							}
							
						}
						}catch(Exception e) { }
						return result;
						
					}
					

}
