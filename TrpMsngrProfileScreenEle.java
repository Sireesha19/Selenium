package TroopMessengerApp;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class TrpMsngrProfileScreenEle {
	AndroidDriver driver;
	
	@FindBy(id="com.tvisha.troopmessenger:id/options")
	//@FindBy(xpath="//android.widget.TextView[@id='com.tvisha.troopmessenger:id/options'][2index='3']")
	//@FindBy(xpath="//android.widget.TextView[@id='com.tvisha.troopmessenger:id/options']")
	public AndroidElement opt;
	
	@FindBy(className="android.widget.LinearLayout")
	public List<AndroidElement> optList;
	
	
	
	@FindBy(xpath="//android.widget.TextView[@text='Add users')]")//0th index
	public AndroidElement addUsers;
	
	@FindBy(xpath="//android.widget.TextView[@text='New Group')]")
	public AndroidElement newGrp;
	
	@FindBy(xpath="//android.widget.TextView[@text='Profile')]")
	public AndroidElement profile;
	
	@FindBy(id="com.tvisha.troopmessenger:id/snackbar_text')]")
	public AndroidElement feedBack;
	
	@FindBy(xpath="//android.widget.TextView[@text='Logout')]")
	public AndroidElement logout;
	
	@FindBy(id="com.tvisha.troopmessenger:id/change_profile_pic")
	public AndroidElement profilebIcon;
	
	@FindBy(id="com.tvisha.troopmessenger:id/user_status")
	public AndroidElement userStatus;
	
	
	@FindBy(xpath="//android.widget.TextView[@text='Personal Details')]")
	public AndroidElement detailTxt;
	
	@FindBy(id="com.tvisha.troopmessenger:id/userName")
	public AndroidElement name;
	
	@FindBy(id="com.tvisha.troopmessenger:id/userMobile")
	public AndroidElement mobile;
	
	@FindBy(id="com.tvisha.troopmessenger:id/userEmail")
	public AndroidElement mail;
	
	@FindBy(xpath="//android.widget.TextView[@text='Business Details')]")
	public AndroidElement businessDetails;
	
	@FindBy(id="com.tvisha.troopmessenger:id/businessDesignation")
	public AndroidElement designation;
	
	@FindBy(id="com.tvisha.troopmessenger:id/businessCompany")
	public AndroidElement bCompany;
	
	@FindBy(id="com.tvisha.troopmessenger:id/businessLocation")
	public AndroidElement location;
	
	@FindBy(className="android.support.v7.app.ActionBar$Tab")
	public List<AndroidElement> tabs;
	
	@FindBy(xpath="//android.widget.TextView[contains(text(),'Security')]")
	public AndroidElement securitytab;
	
	@FindBy(xpath="//android.widget.TextView[@text='Info')]")
	public AndroidElement infotab;
	
	
	//password ele
	@FindBy(xpath="//android.widget.TextView[contains(@text(),'Password')]")
	public AndroidElement pwdtab;
	
	@FindBy(id="com.tvisha.troopmessenger:id/old_password")
	public AndroidElement oldpwd;
	
	@FindBy(id="com.tvisha.troopmessenger:id/new_password")
	public AndroidElement newpwd;
	
	@FindBy(id="com.tvisha.troopmessenger:id/confirm_password")
	public AndroidElement conpwd;
	
	@FindBy(id="com.tvisha.troopmessenger:id/password_save")
	public AndroidElement pwdSav;

	
	//activity devices
	
	@FindBy(xpath="//android.widget.TextView[@(text='Activity')]")
	public AndroidElement activitytab;
	
	
	
	@FindBy(xpath="//android.widget.TextView[contains(text(),'Active Devices')]")
	public AndroidElement activitydet;
	
	@FindBy(id="com.tvisha.troopmessenger:id/platform_name")
	public List<AndroidElement> actdetail;
	
	@FindBy(id="com.tvisha.troopmessenger:id/platform_logout")
	public List<AndroidElement> actdetailIcons;//Icons to get msg space
	
	@FindBy(id="com.tvisha.troopmessenger:id/total_usage")
	public AndroidElement tmuse;
	
	@FindBy(id="com.tvisha.troopmessenger:id/messages_count")
	public AndroidElement msgCount;
	
	@FindBy(id="com.tvisha.troopmessenger:id/message_data_usages")
	public AndroidElement dataUse;
	
	@FindBy(id="com.tvisha.troopmessenger:id/image_video_count")
	public AndroidElement videoCount;
	
	@FindBy(id="com.tvisha.troopmessenger:id/image_video_data_usages")
	public AndroidElement vdataUse;
	
	@FindBy(id="com.tvisha.troopmessenger:id/files_count")
	public AndroidElement fileCount;
	
	@FindBy(id="com.tvisha.troopmessenger:id/file_data_usages")
	public AndroidElement fdataUse;
	
	// file tab ele
	@FindBy(xpath="//android.widget.TextView[@text='Files')]")
	public AndroidElement filestab;
	
	@FindBy(id="com.tvisha.troopmessenger:id/media_view")
	public AndroidElement media;
	
	@FindBy(id="com.tvisha.troopmessenger:id/doc_view")
	public AndroidElement doc;
	
	@FindBy(id="com.tvisha.troopmessenger:id/link_view")
	public AndroidElement link;
	
	
	@FindBy(id="com.tvisha.troopmessenger:id/link")
	public List<AndroidElement> linkCount;
	
	
	//preferance tab ele
	
	@FindBy(xpath="//android.widget.TextView[contains(@text(),'Preferences')]")
	public AndroidElement preferenceTab;
	
	
	//Addusers Screen ele
	@FindBy(id="com.tvisha.troopmessenger:id/add_user_tab")
	public AndroidElement addUserTab;
	
	@FindBy(id="com.tvisha.troopmessenger:id/suggest_user_tab")
	public AndroidElement suggestUserTab;
	
	@FindBy(id="com.tvisha.troopmessenger:id/et_user_name")
	public List<AndroidElement> uName;
	
	@FindBy(id="com.tvisha.troopmessenger:id/et_email")
	public List<AndroidElement> uEmail;
	
	@FindBy(id="com.tvisha.troopmessenger:id/tv_add_more")
	public AndroidElement AddAnotherbtn;
	
	@FindBy(id="com.tvisha.troopmessenger:id/tv_add_button")
	public AndroidElement AddBtn;
	
	@FindBy(id="com.tvisha.troopmessenger:id/close_view")
	public List<AndroidElement> closeBtn;
	
	// create group ele
	
	@FindBy(id="com.tvisha.troopmessenger:id/searchContact")
	//@FindBy(xpath="//android.widget.EditText[@text='Search']")
	public AndroidElement search;
	
	@FindBy(id="com.tvisha.troopmessenger:id/userName")
	public List<AndroidElement> predictedRows;
	
	@FindBy(id="com.tvisha.troopmessenger:id/cancle_user")
	public List<AndroidElement> cancel_user;
	
	//@FindBy(id="com.tvisha.troopmessenger:id/actionNext")
	//@FindBy(xpath="//android.widget.Button[@index='3']")
	@FindBy(xpath="//android.widget.Button[@text='Next']")
	public AndroidElement act_next;
	
	//profile pic
	@FindBy(id="com.tvisha.troopmessenger:id/groupPic")
	public AndroidElement gpic;
	
	@FindBy(id="com.tvisha.troopmessenger:id/groupName")
	public AndroidElement grpName;
	
	@FindBy(id="com.tvisha.troopmessenger:id/actionNext")
	public AndroidElement createGrp;
	
	@FindBy(id="com.tvisha.troopmessenger:id/cancle_group")
	public AndroidElement canel_grp;
	
	@FindBy(id="com.tvisha.troopmessenger:id/snackbar_text")
	public AndroidElement feedback;
	
	
	@FindBy(id="com.tvisha.troopmessenger:id/pinSecurityStatus")
	public AndroidElement pin;
	
	//@FindBy(id="com.tvisha.troopmessenger:id/add_member_count")
	//@FindBy(xpath="//android.widget.TextView[@id='com.tvisha.troopmessenger:id/add_member_count']")
	@FindBy(xpath="//android.widget.TextView[@index='2']")
	public AndroidElement members_count;
	
	@FindBy(id="com.tvisha.troopmessenger:id/pic_gallary")
	public AndroidElement gallary;
	
	@FindBy(className="android.widget.FrameLayout")
	public List<AndroidElement> images;
	
	@FindBy(xpath="//android.widget.FrameLayout[@index='0']")
		public AndroidElement ii;
	
	
	@FindBy(id="com.tvisha.troopmessenger:id/btn_done")
	public AndroidElement img_done;
											
	@FindBy(id="com.tvisha.troopmessenger:id/userName")
	public AndroidElement grpnme;

	@FindBy(id="com.tvisha.troopmessenger:id/remove_image")
	public AndroidElement rmvIcon;
	
	@FindBy(id="com.tvisha.troopmessenger:id/actionLable")
	public AndroidElement logo;
			

	
											public TrpMsngrProfileScreenEle(AndroidDriver driver)throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
												this.driver=driver;
												PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
												
											}
											
											public void profileclk() throws InterruptedException {
												try {
												Thread.sleep(1000);
												opt.click();
												Thread.sleep(2000);
												//profile.click();
												optList.get(2).click();
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(optList.get(2).getText()+"   Option from dropdown selected", Troopbase.color.BLUE));
												
											}catch(Exception e) { }
											}
											
											public void profileInfo(String uId) throws InterruptedException
											{
												try {
												
													Thread.sleep(1500);
													tabs.get(0).click();
													Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(tabs.get(0).getText()+"   Option from tabs selected", Troopbase.color.BLUE));
												System.out.println("Status============="+userStatus.getText());
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel(" Profile Information  ", Troopbase.color.BROWN));
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel(userStatus.getText(), Troopbase.color.TEAL));
												Thread.sleep(1500);
												//System.out.println(detailTxt.getText());
												System.out.println("Name=============="+name.getText());
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Name->"+name.getText(), Troopbase.color.TEAL));
												
												System.out.println("MobileNumber==============="+mobile.getText());
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("MobileNumber->"+mobile.getText(), Troopbase.color.TEAL));
												
												System.out.println("Email==============="+mail.getText());
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Email->"+mail.getText(), Troopbase.color.TEAL));
												Assert.assertEquals(mail.getText(), uId, "Email not verified");
												
												System.out.println("=========Email Verified with login credential========");
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Email Verified with login credential", Troopbase.color.BLUE));
												swipeVertical((AppiumDriver)driver,0.9,0.1,0.5,3000);
												
												
												System.out.println("Designation==============="+designation.getText());
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Designation->"+designation.getText(), Troopbase.color.TEAL));
												
												System.out.println("Company==============="+bCompany.getText());
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Company->"+bCompany.getText(), Troopbase.color.TEAL));
												
												System.out.println("Location=============="+location.getText());
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Location->"+location.getText(), Troopbase.color.TEAL));
												
												}catch(Exception e) { }
												
											}
											
											@SuppressWarnings("rawtypes")
											public static void swipeHorizontal(AndroidDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
										        Dimension size = driver.manage().window().getSize();
										        int anchor = (int) (size.height * anchorPercentage);
										        int startPoint = (int) (size.width * startPercentage);
										        int endPoint = (int) (size.width * finalPercentage);
										        new TouchAction(driver).press(startPoint, anchor).waitAction(Duration.ofMillis(duration)).moveTo(endPoint, anchor).release().perform();
										    }


											@SuppressWarnings("rawtypes")
											public static void swipeVertical(AppiumDriver driver2, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
										        Dimension size = driver2.manage().window().getSize();
										        int anchor = (int) (size.width * anchorPercentage);
										        int startPoint = (int) (size.height * startPercentage);
										        int endPoint = (int) (size.height * finalPercentage);
										        new TouchAction(driver2).press(anchor, startPoint).waitAction(Duration.ofMillis(duration)).moveTo(anchor, endPoint).release().perform();
										    }
											
											public void changePwdTabClk() throws InterruptedException {
												Thread.sleep(3000);
												tabs.get(1).click();
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(tabs.get(1).getText()+"   Option from tabs selected", Troopbase.color.BLUE));
												
											}
											public void changePwd(String op,String np,String cp,String check) throws InterruptedException
											{
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("GivenData  :  OldPassword--"+op+"\nNewPassword--"+np+"\nConfirmPassword--"+cp+"\nStatus--"+check , Troopbase.color.BLUE));
												String val=null;
												String val1=null;
												
												//pwdtab.click();
												oldpwd.sendKeys(op);
												newpwd.sendKeys(np);
												conpwd.sendKeys(cp);
												pwdSav.click();
												try
												{
													val=verifyToast(driver);
													System.out.println("============>"+val);
													Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Toast message is :"+val, Troopbase.color.BROWN));
													verifyPwd(np,val,check);
													
													
												}catch(Exception e) {
													//Thread.sleep(300);
													Thread.sleep(2500);
													System.out.println(feedBack.getText());
													Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Feedback message is :"+feedBack.getText(), Troopbase.color.TEAL));
													
												
												}
											
												
											}
											
											public void verifyPwd(String pwd,String ocrmsg,String validval)
											{
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Toast message on extracting Feedback Message", Troopbase.color.TEAL));
												String msg1="Invalid old password";
												String msg2="please enter new password";
												String msg3="please enter confirm password";
												String msg4="Please enter old password";
												String msg6="conﬁrm password not match!";
												String msg5="Password changed successfully";
												String result=null;
												String res=null;

												if(validval.contentEquals("Invalid")) {
													
													Assert.assertEquals(validval, "Invalid", "Msgnot Valid");
													if(ocrmsg.contains(msg1)||ocrmsg.contains(msg2)||ocrmsg.contains(msg3)||ocrmsg.contains(msg4)||ocrmsg.contains(msg6)) {
														Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenData :"+validval+" ,"+"should get message : "+msg1+"  or\n"+msg2+" or\n"+msg3+" or\n"+msg4+" or\n"+msg6,  Troopbase.color.TEAL));
														
													result="get Invalid message result";
													res=msg1+"  or   "+msg2+"	or	"+msg3+"	or	"+msg4+"	or	"+msg6;
													System.out.println("Successfully get the message======>"+result);
													Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(" Message  :  "+res+" \nSuccessfully get the Invalid message",    Troopbase.color.RED));
													Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Changed Password :"+pwd+"---- Change password is Unsuccessful",    Troopbase.color.BLUE));
													}
												}
												else {
													Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenData :"+validval+" ,"+"should get message  :"+msg5,    Troopbase.color.TEAL));	
													Assert.assertEquals(validval, "Valid", "Msg not Invalid");
													result="get valid msg result";
													if(ocrmsg.contains(msg5)) {
														System.out.println("get the ocr msg======>"+result);	
														res=msg5;
														Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(" Message  : "+res+" Successfully get the message",    Troopbase.color.BLUE));
														Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Changed Password :"+pwd+"---- Successfully Done",    Troopbase.color.BLUE));
													}
													
														
													}
												System.out.println("======******=======");
												
												
											}
											
											
											
											public static String verifyToast(AndroidDriver driver) {
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Verifying Toast message\n", Troopbase.color.BROWN));
												String result = null;
												File scrFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
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
											
											public void security() throws InterruptedException {
												Thread.sleep(3000);
												String sts="OFF";
												tabs.get(2).click();
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(tabs.get(2).getText()+"   Option from tabs selected", Troopbase.color.BLUE));
												/*String pinStatus=pin.getText();
												if(sts.contentEquals(pinStatus)) {
													pin.click();
													System.out.println("Pin status is on ON");
													
												}
												else {
													pin.click();
													System.out.println("Pin status is on OFF");
												}*/
												
											}
											public void activity() throws InterruptedException {
												try {
												Thread.sleep(3000);
												tabs.get(3).click();
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(tabs.get(3).getText()+"   Option from tabs selected", Troopbase.color.BLUE));
												//activitytab.click();
												//Thread.sleep(1500);
												//System.out.println(activitydet.getText());
												//System.out.println("Active devces========>");
												//System.out.println("act=====>"+actdetail.get(0).getText());
												//System.out.println(actdetail.get(1).getText());
												Thread.sleep(1500);
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Data Usage :-\n", Troopbase.color.BROWN));
												System.out.println("Usage===========>"+tmuse.getText());
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Total Message Usage  :"+tmuse.getText(), Troopbase.color.TEAL));
												Thread.sleep(1500);
												System.out.println("Messages====msgsCount====="+msgCount.getText()+"=====DataUsage===="+dataUse.getText());
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Message Usage  :"+msgCount.getText(), Troopbase.color.TEAL));
												
												System.out.println("Images/Videos=====VideosCount===="+videoCount.getText()+"====DataUsage====="+vdataUse.getText());
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("TImages/Videos Usage  :"+vdataUse.getText(), Troopbase.color.TEAL));
												
												System.out.println("Files=====FilesCount====="+fileCount.getText()+"=====DataUsage====="+fdataUse.getText());
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Files Usage  :"+fdataUse.getText(), Troopbase.color.TEAL));
												}catch(Exception e) { }
											}
											
											public void fileTab() throws InterruptedException {
												
												Thread.sleep(3000);
												tabs.get(4).click();
												
												
											//	filestab.click();
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(tabs.get(4).getText()+"   Option from tabs selected", Troopbase.color.BLUE));
												Thread.sleep(3000);
											//tabs.get(3).click();
												doc.click();
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(doc.getText()+"  is clicked", Troopbase.color.BLUE));
												media.click();
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(media.getText()+" is clicked", Troopbase.color.BLUE));
												link.click();
												System.out.println("========No of links="+linkCount.size());
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(link.getText()+" is clicked", Troopbase.color.BLUE));
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(" No of linkes in File tab --"+linkCount.size(), Troopbase.color.BLUE));
												
											//}catch(Exception e) { }
											}
											/*public void prefernce() throws InterruptedException {
												Thread.sleep(3000);
												tabs.get(5).click();
												
											}*/
											
											
											
											public void newGrp_btnClk() throws InterruptedException
											{
												
												opt.click();
												optList.get(1).click();
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(optList.get(1).getText()+" is selected", Troopbase.color.BLUE));
												
																				
											}
											
											public void addUsers_Grp(String uname) throws InterruptedException 
											{
												
												//Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel(optList.get(1).getText()+" is selected", Troopbase.color.BLUE));
												Thread.sleep(1000);
												driver.findElementById("com.tvisha.troopmessenger:id/searchContact").sendKeys(uname);
												/*WebElement e= driver.findElement(By.id("com.tvisha.troopmessenger:id/searchContact"));
												e.sendKeys(uname);*/
												List<AndroidElement> l=driver.findElementsById("com.tvisha.troopmessenger:id/userName");
												System.err.println("members = "+l.size());
												l.get(0).click();
												//a.sendKeys(e, uname);
												//predictedRows.get(0).click();
												System.err.println("predicted rows==="+predictedRows.size());
											} 
											int c;
											public void newGrpCreate() throws InterruptedException {
												Thread.sleep(2000);
												driver.findElementById("com.tvisha.troopmessenger:id/options").click();
												WebElement e=driver.findElementByXPath("//android.widget.TextView[@text='New Group']");
												driver.findElementByXPath("//android.widget.TextView[@text='New Group']").click();
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(e.getText()+" is selected", Troopbase.color.BLUE));
												
												String a[] = { "sabya", "sanju", "khasim", "nagnath" ,"kranthi","sailaja","sravan"};//take data f excel here
												for (String string : a) {
													Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("1st predicted  row selected", Troopbase.color.TEAL));
													Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenData  :"+string+" added to NewGroup", Troopbase.color.TEAL));
												driver.findElementById("com.tvisha.troopmessenger:id/searchContact").sendKeys(string);
												List<AndroidElement> l=driver.findElementsById("com.tvisha.troopmessenger:id/userName");
												c=l.size();
												System.err.println("members = "+c);
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("No of users added to new group--"+l.size(), Troopbase.color.TEAL));
												l.get(0).click();
											

												}
												Thread.sleep(2000);
												((WebElement) driver.findElementsById("com.tvisha.troopmessenger:id/cancle_user").get(1)).click();
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("1st index user cancelled--cancel option verified", Troopbase.color.BLUE));
												driver.findElementById("com.tvisha.troopmessenger:id/actionNext").click();
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Group members count is :"+c, Troopbase.color.TEAL));
												
												}

											
											
												
											public void cancel_user() throws InterruptedException
											{
												//System.out.println("cancel user=== "+cancel_user.size());
												cancel_user.get(0).click();
												String mc=driver.findElementById("com.tvisha.troopmessenger:id/add_member_count").getText();
												
												Thread.sleep(1000);
												act_next.click();
												System.out.println("=======Group members count is"+mc);
											}
											
											
											public void prof_pic() throws InterruptedException {
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Next arrow clicked to upload profile pic", Troopbase.color.BLUE));
												Thread.sleep(500);
												gpic.click();
												gallary.click();
												Thread.sleep(2000);
												List<AndroidElement> lst= driver.findElementsByXPath("//android.widget.GridView/android.widget.FrameLayout/android.widget.LinearLayout");
												Random rnd = new Random();
												int rndInt = rnd.nextInt(lst.size());
												lst.get(rndInt).click();
												System.out.println("=====>"+lst.size());
												
												Thread.sleep(2000);
												//images.get(1).click();
												img_done.click();
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Done button clicked ,After profile pic uploading ", Troopbase.color.TEAL));
												if(rmvIcon.isDisplayed()) {
													System.out.println("====>profile pic updated");
													Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Remove Icon is displaying so Profile pic updated successfully", Troopbase.color.BLUE));
												}
												else {
													Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Remove Icon is not displaying so Profile pic not updated", Troopbase.color.RED));
												}
											}
											
											
											public void GrpName(String gname) throws InterruptedException
											{
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenGroupName  :- "+gname, Troopbase.color.TEAL));
												
												String val=null;
												String validval=null;
												grpName.sendKeys(gname);
												//Thread.sleep(2000);
												createGrp.click();
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Create Group button clicked", Troopbase.color.TEAL));
												WebDriverWait wt=new WebDriverWait(driver, 20);
													try {
													Thread.sleep(3000);
												
														wt.until(ExpectedConditions.invisibilityOf(feedBack));
													System.out.println("========message>"+feedBack.getText());
													Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Feedback message --- "+feedBack.getText(), Troopbase.color.BLUE));
													
													
													}catch(Exception e) {
														
														wt.until(ExpectedConditions.visibilityOf(grpnme));
														System.out.println("=============GrpNAme"+grpnme.getText());
														boolean b=grpnme.isDisplayed();
														if(b) 
														{
															System.out.println("======Group is created======");
														Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(grpnme.getText()+"  is displaying ,Group created successfully", Troopbase.color.BLUE));
														}
														else{
															System.out.println("======Group is not created======");
															Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(grpnme.getText()+"  is not displaying ,Group is not created ", Troopbase.color.RED));
														}
													}
											}
												
											
											
											
	
	
											public void addUserClk() {
												opt.click();
												optList.get(0).click();
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel(optList.get(0).getText()+"option is selected", Troopbase.color.TEAL));
											}
	
											public void addUsers(String uname,String email,int i) throws Exception {
												int r=uName.size();
												String val=null;
												System.out.println("===========>rows-"+r);
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("No of rows present --"+r, Troopbase.color.BROWN));
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenData :- UserName--"+uname+"Email--"+email, Troopbase.color.TEAL));
												try 
												{
												uName.get(i).sendKeys(uname);
												uEmail.get(i).sendKeys(email);
												Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel(i+" th User added successfully", Troopbase.color.TEAL));
												}catch(Exception e) {
													if(r<4) {
													Thread.sleep(1500);	
													AddAnotherbtn.click();
													AddAnotherbtn.click();
													uName.get(i).sendKeys(uname);
													uEmail.get(i).sendKeys(email);
													Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Add another button clicked", Troopbase.color.BLUE));
													Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(i+" th User added successfully", Troopbase.color.BLUE));
													swipeVertical((AppiumDriver)driver,0.9,0.1,0.5,3000);
													}
													
													Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Scrolling...", Troopbase.color.BROWN));
									
													}
												Thread.sleep(1200);
												closeBtn.get(0).click();
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("0 th index row is closed,close(X) Icon is verified ", Troopbase.color.BLUE));
												AddBtn.click();
												Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("After adding users ,ADD button clicked", Troopbase.color.BLUE));
												try {
												val=verifyToast(driver);
												addUserVerify(email,val);
												/*WebDriverWait wt=new WebDriverWait(driver, 10);
												wt.until(ExpectedConditions.visibilityOf(feedback));
												System.out.println("========message>"+feedBack.getText());
												Troopbase.extentTest.log(Status.FAIL, MarkupHelper.createLabel("Feedback Message :-"+feedBack.getText(), Troopbase.color.RED));*/
												}catch(Exception e) { }
																				
												}
											
											
											public void addUserVerify(String mail,String ocrmsg) {
												String msg1="Please enter user name";
												String msg2="Email is "+mail+" already existed";
													//if(validval.contentEquals("Invalid")) {
													
													//Assert.assertEquals(validval, "Invalid", "Msgnot Valid");
													if(ocrmsg.contains(msg1)||ocrmsg.contains(msg2)) {
														Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenData : "+"should get message : "+msg1+"  or\n"+msg2,  Troopbase.color.TEAL));
													
													System.out.println("get the invalid message======>"+msg1 +"or"+msg2);
													Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(" Feedback ocr message contains   :"+msg1+" or"+ msg2,    Troopbase.color.RED));
													Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel(" Users are not added",    Troopbase.color.RED));
													}
												
													else {
													/*Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenData :"+validval+" ,"+"should get message  :"+msg5,    Troopbase.color.TEAL));	
													Assert.assertEquals(validval, "Valid", "Msg not Invalid");
													result="get valid msg result";
													if(ocrmsg.contains(msg5)) {
														System.out.println("get the ocr msg======>"+result);	
														res=msg5;*/
														WebElement e=driver.findElementById("com.tvisha.troopmessenger:id/unread_message");
														boolean b=e.isDisplayed();
														System.out.println("====>"+b);
														if(true) {
														Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Successfully Users added",    Troopbase.color.BLUE));
													
													}
													
														
													}
												System.out.println("======******=======");
												
												
												
												
											}
											}

											
	


