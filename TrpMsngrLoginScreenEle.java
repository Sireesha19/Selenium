package TroopMessengerApp;

import java.awt.Color;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TrpMsngrLoginScreenEle {
	AndroidDriver driver;
	
	@FindBy(id="com.tvisha.troopmessenger:id/userId")
	public AndroidElement userId;
	
	@FindBy(id="com.tvisha.troopmessenger:id/password")
	public AndroidElement pwd;
	
	@FindBy(id="com.tvisha.troopmessenger:id/submitImg")
	public AndroidElement submitBtn;;
	
	//@FindBy(xpath="//android.widget.ImageButton[@index='1']")
	@FindBy(id="com.tvisha.troopmessenger:id/actionSearch")
	public AndroidElement searchIcon;
	

	@FindBy(id="com.tvisha.troopmessenger:id/search")
	public AndroidElement search;
	
	@FindBy(id="com.tvisha.troopmessenger:id/userName")
	public AndroidElement usrName; 

	@FindBy(id="com.tvisha.troopmessenger:id/newMesg")
	public AndroidElement newMsg;

	@FindBy(id="com.tvisha.troopmessenger:id/sendMessage")
	public AndroidElement sendMsgBtn;

	@FindBy(xpath="//android.widget.TextView[@text='Rakesh Adupa ']")
	public AndroidElement viewuser;
	
	@FindBy(id="com.tvisha.troopmessenger:id/item")
	public List<AndroidElement> predictedrows;

	@FindBy(id="com.tvisha.troopmessenger:id/txtMsg")
	public List<AndroidElement> msglist; 

	@FindBy(id="com.tvisha.troopmessenger:id/timeStamp")
	public List<AndroidElement> timelist; 
	
	@FindBy(id="com.tvisha.troopmessenger:id/actionLable")
	public AndroidElement label;
	
	@FindBy(id="com.tvisha.troopmessenger:id/msgSentStatus")
	public AndroidElement msgSts;
	
	@FindBy(xpath="//android.widget.ImageView[@index='1']")
	public AndroidElement image;

										
	//unread message elements
	
	@FindBy(id="com.tvisha.troopmessenger:id/unreadMesgCount")
	 public List<AndroidElement> unreadmsgCount;
	
	@FindBy(id="com.tvisha.troopmessenger:id/unreadMesgCount")
	public List<AndroidElement> unread_Count;
	
	
	@FindBy(id="com.tvisha.troopmessenger:id/userName")
	public List<AndroidElement> msgCount;
	
	@FindBy(id="com.tvisha.troopmessenger:id/unread_message")
	public AndroidElement unreadMsgBtn;
	
	@FindBy(xpath="//android.widget.LinearLayout[@index='1']")
	public List<AndroidElement> rows;
	
	@FindBy(id="com.tvisha.troopmessenger:id/item")
	public List<AndroidElement> total;
	
			

				public TrpMsngrLoginScreenEle(AndroidDriver driver)throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
				{
						this.driver=driver;
						PageFactory.initElements(new AppiumFieldDecorator(driver, 6, TimeUnit.SECONDS), this);
										
				}
				
				public void login(String userid,String passwd) throws InterruptedException
				{
					Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenData  :UserName --"+userid+"   Password --"+passwd, Troopbase.color.TEAL));
					Thread.sleep(1000);
					userId.sendKeys(userid);
					pwd.sendKeys(passwd);
					submitBtn.click();
					String result=null;
					Thread.sleep(5800);
					WebDriverWait wt=new WebDriverWait(driver, 40);
					WebElement lab=wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.tvisha.troopmessenger:id/actionLable")));
					if(lab.isDisplayed()) {
						Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("SignIn Successful", Troopbase.color.BLUE));
					System.out.println("Login is successfull");
			
					}
					else {
						Troopbase.extentTest.log(Status.FAIL, MarkupHelper.createLabel("SignIn UnSuccessful", Troopbase.color.RED));
						System.out.println("Login is Unsuccessfull");
					
					}
					
				}
				
				
				public void searchUser(String receive) throws Exception
				{   
					Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenUser to search :			"+receive+"			",Troopbase.color.TEAL));
						try {
						//Thread.sleep(2000);
						WebDriverWait t=new WebDriverWait(driver, 10);
						WebElement ele=t.until(ExpectedConditions.visibilityOf(driver.findElementById("com.tvisha.troopmessenger:id/actionSearch")));
						ele.click();
						//driver.findElementById("com.tvisha.troopmessenger:id/actionSearch").click();
						search.sendKeys(receive);
						}catch(Exception e) { 
							//Thread.sleep(1000);
							//search.sendKeys(receive);
						}
					prediction(receive);
				}
				
				
				
				
				public void prediction(String receive) throws Exception {
					List<WebElement> rowsList=driver.findElements(By.id("com.tvisha.troopmessenger:id/userName"));
					System.out.println("=====predictedrows "+rowsList.size());
					Thread.sleep(3000);
					int c=rowsList.size();
					System.out.println("Total rows=====>"+c);
					Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("No of rows predicted --"+c, Troopbase.color.BLUE));
					for(int i=0;i<c;i++)
					{
						Thread.sleep(2000);
						String txt=rowsList.get(i).getText();
						/*WebElement ele1;
						try {
							Thread.sleep(500);
							
							ele1=driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index="+i+"]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
						}catch(Exception e) {
							Thread.sleep(500);
							ele1=driver.findElementByXPath("//android.support.v7.widget.RecyclerView[@index='2']/android.widget.LinearLayout[@index="+i+"]/android.widget.RelativeLayout/android.widget.RelativeLayout[@index='2']/android.widget.TextView");
						}
					
							String txt=ele1.getText();*/
							//System.out.println(i+"th row text =======>" +txt);
							Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel(i+" th row text -" +txt, Troopbase.color.TEAL));
							try
							{
								String withoutspacestr = txt.replaceAll("\\s", "");
								receive=receive.replaceAll("\\s", "");
								System.out.println("Modified text---"+withoutspacestr+"\n modified username :"+receive);
								
							if(receive.equalsIgnoreCase(withoutspacestr)) {
								System.out.println("====>User name found");
								Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("User Name  :"+receive+"--"+txt+"  Found successfully", Troopbase.color.BLUE));
								rowsList.get(i).click();
								break;
							}
							else {
								Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("User Name  :"+receive+"--"+txt+" not  Found", Troopbase.color.RED));
							}
							}catch(Exception e) { }
						}
					swipeVertical((AppiumDriver)driver,0.9,0.1,0.5,1099);
				}

				public String sendMsg(String msg) 
				{
					Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenMessage :			"+msg+"			", Troopbase.color.TEAL));
					System.out.println("===========TestCase: sending message==========");
					newMsg.sendKeys(msg );
					SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm aa");
					String formattedDate = dateFormat.format(new Date()).toString();
					System.out.println(formattedDate);
					Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("SystemDate :   "+formattedDate, Troopbase.color.TEAL));
					sendMsgBtn.click();
					
					System.out.println(msglist.size()+"time"+timelist.size());
					
					int a1=msglist.size()-1;
					//System.out.println(a1);
					int b1=timelist.size()-1;
					String mtxt=msglist.get(a1).getText();
					String ttxt=timelist.get(b1).getText();
					if(msg.contentEquals(mtxt)) 
					{	
						if(formattedDate.contentEquals(ttxt)) {
						System.out.println("sent msg equals");
						Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("SentMessage is:   "+msg+"			,Message is:		"+mtxt+"======>Both Messages Equals ", Troopbase.color.BLUE));	
						Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("SystemTime is:   "+formattedDate+"			,Time is:		"+ttxt+"======>Equals	so Message sent successfully", Troopbase.color.BLUE));	
					}
					}
					else {
						Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("SentMessage is:   "+msg+"			,Message is:		"+mtxt+"======>NotEquals so Message not sent", Troopbase.color.RED));	
					}
					//Assert.assertEquals(msg, mtxt, Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("SentMessage is:   "+msg+"			Message is:		"+mtxt+"======>NotEquals", Troopbase.color.BLUE)));
					
					
					//Assert.assertEquals(formattedDate, ttxt, "Notequals");
					System.out.println("sent msg=======>"+mtxt   +"Time equals======>"+ttxt);
					System.out.println("Message status is==========>"+msgSts.getText());
					//System.out.println("======>image status is "+image.getText());
					return formattedDate;
					
				}
				
				
				public void getMsg(String msg,String time) {
					Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenMessage :			"+msg+"			", Troopbase.color.TEAL));
					System.out.println("===========TestCase: getting message==========");
					System.out.println(msglist.size()+"time"+timelist.size());
					
					int a1=msglist.size()-1;
					int b1=timelist.size()-1;
					String ttxt=timelist.get(b1).getText();
					
							try {
								
								String mtxt=msglist.get(a1).getText();
								System.out.println("sent msg=======>"+mtxt     +" on Time======>"+ttxt);
								Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Sent msg=======>"+mtxt     +" on Time======>"+ttxt, Troopbase.color.TEAL));
							if(msg.contentEquals(mtxt) && time.contentEquals(ttxt)) 
							{	
								System.out.println("sent msg equals");
								System.out.println("sent msg=======>"+mtxt   +"Time equals======>"+ttxt);
								Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("MsgRow number --"+a1+"=======TimeRow number---"+b1+" \nSentMessage is:   "+msg+"			,Message is:		"+mtxt+"======>Both Messages Equals ", Troopbase.color.BLUE));	
								Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("SentMessage on time is:   "+time+"			,Time is:		"+ttxt+"======>Both Messages Equals ", Troopbase.color.BLUE));	
							}
							else {
								System.out.println("sent msg=======>"+mtxt   +"Time not equals======>"+ttxt);
								Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("MsgRow number --"+a1+"=======TimeRow number---"+b1+" \nSentMessage on time is:   "+time+"			,Time is:		"+ttxt+"======>Both Messages not Equals ", Troopbase.color.RED));	
								Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("SentMessage time  is:   "+time+"			,Time is:		"+ttxt+"======>NotEquals so Message not sent", Troopbase.color.RED));	
							}
							
							//System.out.println("Message status is==========>"+msgSts.getText());
							
						}catch(Exception e) {
							System.out.println("forwarded image on time :-"+ttxt);
							Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Sent Image on Time======>"+ttxt, Troopbase.color.TEAL));
							if(time.contentEquals(ttxt)) {
								System.out.println("sent image on Time equals======>"+ttxt+"====="+time);
								Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("ImageRow number --"+a1+"=======TimeRow number---"+b1, Troopbase.color.BLUE));	
								Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("SenImage at time :   "+time+"			,Time is:		"+ttxt+"======>Time Equals ,so Image sent", Troopbase.color.BLUE));	
							}
							else {
								System.out.println("sent image on Time ======>"+ttxt+"=====not equals with"+time);
								Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("MsgRow number --"+a1+"=======TimeRow number---"+b1, Troopbase.color.RED));	
								Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("SentImage at  time:   "+time+"			,Time is:		"+ttxt+"======>NotEquals so Image not sent", Troopbase.color.RED));	
							}
								
							}
				}
					
				
				
				public void getMssg(String msg) {
					Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenMessage :			"+msg+"			", Troopbase.color.TEAL));
					System.out.println("===========TestCase: getting message==========");
					System.out.println(msglist.size()+"time"+timelist.size());
					
					int a1=msglist.size()-1;
					int b1=timelist.size()-1;
					String ttxt=timelist.get(b1).getText();
					
							try {
								
								String mtxt=msglist.get(a1).getText();
								System.out.println("sent msg=======>"+mtxt     +" on Time======>"+ttxt);
								Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Sent msg=======>"+mtxt     +" on Time======>"+ttxt, Troopbase.color.TEAL));
							if(msg.contentEquals(mtxt)) 
							{	
								System.out.println("sent msg equals");
								System.out.println("sent msg=======>"+mtxt   +"Message equals======>"+ttxt);
								Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("MsgRow number --"+a1+"=======TimeRow number---"+b1+" \nSentMessage is:   "+msg+"			,Message is:		"+mtxt+"======>Both Messages Equals ", Troopbase.color.BLUE));	
								//Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("SentMessage on time is:   "+time+"			,Time is:		"+ttxt+"======>Both Messages Equals ", Troopbase.color.BLUE));	
							}
							else {
								System.out.println("sent msg=======>"+mtxt   +"Mesage not equals======>"+msg);
								Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("MsgRow number --"+a1+"=======TimeRow number---"+b1+" \nSentMessage on time is:   "+time+"			,Time is:		"+ttxt+"======>Both Messages not Equals ", Troopbase.color.RED));	
								//Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("SentMessage time  is:   "+time+"			,Time is:		"+ttxt+"======>NotEquals so Message not sent", Troopbase.color.RED));	
							}
							
							//System.out.println("Message status is==========>"+msgSts.getText());
							
						}catch(Exception e) { }
														
				}
				
				
				
				
				int index=0;
				int sum=0;
				int totall=0;
				
				public int scrolling() throws Exception {
					int m=msgCount.size();
					int	s=unreadmsgCount.size();
					Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Unread messages count in screen of users chat : "+s, Troopbase.color.TEAL));
					index=index+s;
					totall=totall+m;
					String txt=msgCount.get(m-1).getText();
					for(int u=0;u<s;u++) {
						Thread.sleep(1000);
						String a=unreadmsgCount.get(u).getText();
						System.out.println(u +"th index message count is:   "+a);
						int count=Integer.parseInt(a);
						sum=sum+count;
					}
					Thread.sleep(2000);
					swipeVertical((AppiumDriver)driver,0.9,0.1,0.5,1099);
					int m1=msgCount.size();
					System.out.println("after scroll=======>"+m1);
					Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("After scrolling....rows..."+m1, Troopbase.color.TEAL));
					if(txt.equals(msgCount.get(m1-1).getText())) 
					{
							System.out.println("==========>rows are not repeating");
							Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Rows are not repeating.... ", Troopbase.color.TEAL));
					}
					else {
						scrolling();
						}
						System.out.println("-------->Sum is"+sum+"\n========index count is :"+index+"\n========total messages are :"+totall);
						Troopbase.extentTest.log(Status.INFO,MarkupHelper.createLabel("-------->Sum is"+sum+"\n========unread messages count :-"+index+"\n========total messages are :"+totall, Troopbase.color.TEAL));
						return index;
				}
					
				
				
				int index1=0;
				int sum1=0;
				int totall1=0;
				public int unreadmsgs() throws Exception 
				{
					
					unreadMsgBtn.click();
					Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Unreadmessage button clicked", Troopbase.color.BROWN));
						int m=msgCount.size();
						int	s=unreadmsgCount.size();
						Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Unread messages count in screen after unreadmessages icon clicked  : "+s, Troopbase.color.TEAL));
						index1=index1+s;
						totall1=totall1+m;
						String txt=msgCount.get(m-1).getText();
						for(int u=0;u<s;u++) {
							Thread.sleep(1000);
							String a=unreadmsgCount.get(u).getText();
							System.out.println(u +"th index message count is:   "+a);
							int count=Integer.parseInt(a);
							sum1=sum1+count;
						}
							Thread.sleep(2000);
							swipeVertical((AppiumDriver)driver,0.9,0.1,0.5,1099);
							int m1=msgCount.size();
							System.out.println("after scroll=======>"+m1);
							Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("After scrolling....rows..."+m1, Troopbase.color.TEAL));
							if(txt.equals(msgCount.get(m1-1).getText())) {
								System.out.println("==========>rows are not repeating");
								Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Rows are not repeating.... ", Troopbase.color.TEAL));
								}
							else {
								scrolling();
							}
							
						System.out.println("-------->Sum1 is"+sum1+"\n========index1 count is :"+index1+"\n========total1 messages are :"+totall1);
						Troopbase.extentTest.log(Status.INFO,MarkupHelper.createLabel("-------->Sum is"+sum1+"\n========unread messages count :-"+index1+"\n========total messages are :"+totall1, Troopbase.color.TEAL));
						return index1;
				}
	
					
				
				
				

		@SuppressWarnings("rawtypes")
		public static void swipeVertical(AppiumDriver driver2, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
		    Dimension size = driver2.manage().window().getSize();
		    int anchor = (int) (size.width * anchorPercentage);
		    int startPoint = (int) (size.height * startPercentage);
		    int endPoint = (int) (size.height * finalPercentage);
		    new TouchAction(driver2).press(anchor, startPoint).waitAction(Duration.ofMillis(duration)).moveTo(anchor, endPoint).release().perform();
		}
		
		
		public void searchIconClk(String receive) {
			searchIcon.click();
			search.sendKeys(receive);
		}
		/*public void searchVerify(String receive) throws Exception{
			int c=msgCount.size();
			System.out.println("=====>NO of matched rows predicted :"+c);
			//1st screen 
			for(int i=0;i<c;i++)
			{
				HashMap<String, String> chat=new HashMap<>();
				String txt=msgCount.get(i).getText();
				System.out.println("===Row Text is :"+txt);
				String[] arr=txt.split(" ");
				System.out.println("              ===============string splitting=============\n");
				int val=keywordValidation(arr,receive);
				if(val>=1) {
					System.out.println("Row  "+msgCount.get(i).getText()+"  is matched with  "+receive);
					}
				else {
					System.out.println("Row  "+msgCount.get(i).getText()+"  is not matched with  "+receive);
				}
			}
		}*/
		
		public void searchVerify(String receive) throws Exception {
			Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Given KeyWord-- "+receive, Troopbase.color.BROWN));
			int c=msgCount.size();
			Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("No of matched rows for given name- "+receive+ "are  :"+c, Troopbase.color.TEAL));
				
			System.out.println("=====>NO of matched rows predicted :"+c);
			//1st screen 
			for(int i=0;i<c;i++)
			{
				
				String txt=msgCount.get(i).getText();
				System.out.println("===Row Text is :"+txt);
				Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel(i+"th Row  text :"+txt, Troopbase.color.TEAL));
				Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("===============string splitting=============", Troopbase.color.BROWN));
				String[] arr=txt.split(" ");
				System.out.println("              ===============string splitting=============\n");
				
				int val=keywordValidation(arr,receive);
				Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("No of substrings matched  :"+val, Troopbase.color.TEAL));
				if(val>=1) {
					System.out.println("Row  "+msgCount.get(i).getText()+"  is matched with key word  "+receive);
					Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Row  "+msgCount.get(i).getText()+"  is matched with  "+receive, Troopbase.color.BLUE));
					}
				else {
					System.out.println("Row  "+msgCount.get(i).getText()+"  is not matched with keyword  "+receive);
					Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Row  "+msgCount.get(i).getText()+"  is not matched with  "+receive, Troopbase.color.RED));
				}
			}
			
			Thread.sleep(2000);
			String text=msgCount.get(c-1).getText();
		
			System.out.println("====last row text  "+text);
			Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Last row text :"+text, Troopbase.color.TEAL));
			swipeVertical((AppiumDriver)driver,0.9,0.1,0.5,1099);
			int m1=msgCount.size();
			System.out.println("after scroll=======>"+m1);
			Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("After Scrolled_No of rows:"+m1, Troopbase.color.TEAL));
			if(text.equals(msgCount.get(m1-1).getText())) 
			{
					System.out.println("==========>rows are not repeating ,search field verified! \n");
					Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("==========>rows are not repeating ,search field verified! ", Troopbase.color.BLUE));
			}
			else {
				Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("==========>rows are repeating,Continuous......", Troopbase.color.BROWN));
				searchVerify(receive);
				}
		
		}

		private int keywordValidation(String[] arr,String receive) {
	
			int count=0;
				for(int j=0;j<arr.length;j++) {
				System.out.println("Substring is=======>"+arr[j]);
				Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("SubString is :"+arr[j], Troopbase.color.TEAL));
				//System.out.println("              ===========substring comparison with key=========");
				Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("===============Substring comparison=============", Troopbase.color.BROWN));
			int keylen=receive.length();
			System.out.println("GivenKeyLength=====>"+keylen);
			Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("Given Key length  :"+keylen, Troopbase.color.TEAL));
			int stringlen=arr[j].length();
			String ss=arr[j].substring(0, keylen);
			String result=null;
			if(receive.equalsIgnoreCase(ss))
			{
				System.out.println("========>substring equals");
				Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Substring equals", Troopbase.color.BLUE));
				System.out.println("SubString  "+arr[j]+"  is matched with  "+receive);
				Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("SubString : "+arr[j]+"  is matched with  "+receive, Troopbase.color.BLUE));
				result="pass";
				count++;
			}
			else {
				result="fail";
				Troopbase.extentTest.log(Status.PASS, MarkupHelper.createLabel("Substrings Not equals", Troopbase.color.RED));
			}
			}
			return count;		
		}

		public void search(String receive) throws InterruptedException {
			Troopbase.extentTest.log(Status.INFO, MarkupHelper.createLabel("GivenUser to search :			"+receive+"			",Troopbase.color.TEAL));
			Thread.sleep(3000);
			driver.findElementById("com.tvisha.troopmessenger:id/actionSearch").click();
			search.sendKeys(receive);
			predictedrows.get(0).click();
			
		}	
}


