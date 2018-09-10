package package1;


import java.io.IOException;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class PageElements {
	AndroidDriver driver;
	public  PageElements(AndroidDriver driver) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException 
	{
		this.driver=driver;	
		PageFactory.initElements(new AppiumFieldDecorator(driver, 6, TimeUnit.SECONDS), this);
		
	}
	
	
	
	//@AndroidBy(id="com.tvisha.mrandmrs:id/heading")
	@FindBy(id="com.tvisha.mrandmrs:id/heading")
	public AndroidElement phoneNumberField;
	
	@FindBy(id="com.tvisha.mrandmrs:id/icon")
	public AndroidElement next;

	@FindBy(id="com.tvisha.mrandmrs:id/digit1")
	public AndroidElement OTP;
	
	@FindBy(id="com.tvisha.mrandmrs:id/icon")
	public AndroidElement otpNextButton;
	
	@FindBy(id="com.tvisha.mrandmrs:id/email")
	public AndroidElement email;
	
	@FindBy(id="com.tvisha.mrandmrs:id/password")
	public AndroidElement emailPwd;
	
	
	@FindBy(id="com.tvisha.mrandmrs:id/fname")
	public AndroidElement fname;
	
	@FindBy(id="com.tvisha.mrandmrs:id/lname")
	public AndroidElement lname;
	
	@FindBy(id="com.tvisha.mrandmrs:id/textView_selectedCountry")
	public AndroidElement countryDropdown;
	
	@FindBy(id="com.tvisha.mrandmrs:id/editText_search")
	public AndroidElement countrySearch;
	
	@FindBy(xpath="//android.widget.TextView[@text='Indonesia (ID)']")
	public AndroidElement country;
	
	@FindBy(xpath="//android.widget.TextView[@text='Women']")
	public AndroidElement gender;
	
	@FindBy(xpath="//android.widget.TextView[@text='YOU ARE ALMOST DONE!']")
	public AndroidElement done;
	
	
	@FindBy(xpath="//android.widget.TextView[contains(text(),'set your preferences or just click next')]")
	public AndroidElement msg;
	
	@FindBy(id="com.tvisha.mrandmrs:id/terms")
	public AndroidElement terms;
	
	@FindBy(id="com.android.packageinstaller:id/permission_deny_button")
	public AndroidElement deny;
	
	@FindBy(id="com.android.packageinstaller:id/permission_allow_button")
	public AndroidElement allow;
	
	@FindBy(id="com.tvisha.mrandmrs:id/current_location")
	public AndroidElement locationRefresh;
	
	@FindBy(xpath="//android.view.View[@content-desc='You. ']")
	public AndroidElement location;
	
	//setting preferences
	@FindBy(xpath="//android.widget.TextView[@text='Select style']")
	public AndroidElement setStyle;
	
	@FindBy(xpath="//android.widget.TextView[@text='Men']")
	public AndroidElement setGender;
	
	@FindBy(id="com.tvisha.mrandmrs:id/payment_mode_txt")
	public AndroidElement paymentMode;
	
	@FindBy(id="com.tvisha.mrandmrs:id/search")
	public AndroidElement searchStyle;
	
	@FindBy(id="com.tvisha.mrandmrs:id/text")
	public List<AndroidElement> nationality;
	
	@FindBy(id="com.tvisha.mrandmrs:id/done")
	public AndroidElement nationalityDone;
	
	@FindBy(id="com.tvisha.mrandmrs:id/back_arrow")
	public AndroidElement backButton;
	
	@FindBy(id="com.tvisha.mrandmrs:id/card")
	public AndroidElement paymentCard;	
	
	
	@FindBy(id="com.tvisha.mrandmrs:id/addr")
	public AndroidElement clickAddress_inmap;
	
	@FindBy(id="com.tvisha.mrandmrs:id/place_search")
	public AndroidElement whereTo;
	
	@FindBy(id="com.tvisha.mrandmrs:id/add_home")
	public AndroidElement addHome;
	

	@FindBy(id="com.tvisha.mrandmrs:id/home")
	public AndroidElement home;
	
	
	@FindBy(id="com.tvisha.mrandmrs:id/add_work")
	public AndroidElement addWork;
	
	@FindBy(id="com.tvisha.mrandmrs:id/work")
	public AndroidElement work;
	
	@FindBy(xpath="//android.widget.TextView[@text='Saved Places']")
	public AndroidElement savedPlaces;
	
	@FindBy(id="com.tvisha.mrandmrs:id/predictedRow")
	public List<AndroidElement> predictedRows;
	
	@FindBy(id="com.tvisha.mrandmrs:id/label")
	public AndroidElement locationLabel;
	
	@FindBy(id="com.tvisha.mrandmrs:id/saved_places_label")
	public AndroidElement addPlace;
	//Aditional Details page
	
	@FindBy(id="com.tvisha.mrandmrs:id/label")
	public AndroidElement homefield;//for work also
	
	@FindBy(id="com.tvisha.mrandmrs:id/flat_no")
	public AndroidElement flatNo;
	
	@FindBy(id="com.tvisha.mrandmrs:id/building")
	public AndroidElement apartmentName;
	
	@FindBy(id="com.tvisha.mrandmrs:id/landmark")
	public AndroidElement landMark; 
	
	@FindBy(id="com.tvisha.mrandmrs:id/additional_details")
	public AndroidElement additionalDetails;
	
	@FindBy(id="com.tvisha.mrandmrs:id/additional_details")
	public AndroidElement additionalDetailsButton;
	
	@FindBy(id="com.tvisha.mrandmrs:id/update")
	public AndroidElement updateButton;
	
	@FindBy(id="com.tvisha.mrandmrs:id/done")
	public AndroidElement addressDoneButton;
	
	
	
							public void setStyle(String nation) {
									setStyle.click();
									searchStyle.sendKeys(nation);
									System.out.println(nationality.size());
									nationality.get(0).click();
									nationalityDone.click();
									
									//backButton.click();
								}
								public void setGender() {
									setGender.click();
								}
								public void setPayment() {
									paymentMode.click();
									
									paymentCard.click();
									
								}
								
								public void clickInMap() {
									clickAddress_inmap.click();
								}
								public void whereTo(String location) {
									try {
										
									whereTo.sendKeys(location);
									predictedRows.get(0).click();
									
									}catch (Exception e) {
									    
										System.out.println("Element Not Found");
										e.printStackTrace();
									
									}
								}
								
								
								public void locationDone()
								{
									
									addressDoneButton.click();
									
								}
								
								
								public void detailsButton()
								{
										additionalDetailsButton.click();	
								}
								
	
								public void home() throws InterruptedException
								{
									/*clickAddress_inmap.click();*/
								
									try {
										if(addHome.isDisplayed()) {
											addHome.click();		
										}else {
											home.click();
										}
									
									}
									catch(Exception e) {
										//e.printStackTrace();
										/*try {
										//home.click();
										}catch (Exception e1) {
											e1.printStackTrace();
											
										}*/
									}
									
								}
								
								public void addWork() {
									

									try {
										addWork.click();
									}
									catch(Exception e) {
										//e.printStackTrace();
										work.click();
									}
									
									
								}
								public void additionalDetailsbutton() {
									additionalDetailsButton.click();
									
									
								}
								public void doneButton() {
									addressDoneButton.click();
									
									
								}
								public void savedPlaces() throws InterruptedException {
									
									savedPlaces.click();
									Thread.sleep(500);
									addPlace.click();
							}
								//setting Additional details
								public void additionalDetails() {
									
									homefield.sendKeys("work/Home");
									flatNo.sendKeys("12677");
									apartmentName.sendKeys("Radha enclave");
									landMark.sendKeys("Onestrore");
									additionalDetails.sendKeys("4 th lane");
									updateButton.click();
									addressDoneButton.click();
								}
	
	
	
				//calling methods
		
				public void phonenumber(String phoneNUmber) throws InterruptedException {
					Thread.sleep(3000);
					phoneNumberField.click();
					
					phoneNumberField.sendKeys(phoneNUmber);
				}
				
				public void nextButton() throws InterruptedException
				{
					Thread.sleep(1000);
					next.click();
				}
				
				public void otp(String OTp) throws InterruptedException {
					Thread.sleep(1000);
					OTP.sendKeys(OTp);
				
				}
				
				public void otpNext() {
					otpNextButton.click();
					
				}
				
				public void email(String eMail) throws InterruptedException {
					//email.clear();
					email.sendKeys(eMail);
				}
				
				public void emailpwd(String EPwd) {
					WebDriverWait wait=new WebDriverWait(driver, 10);
					//wait.until(ExpectedConditions.visibilityOfElementLocated(emailPwd));
					emailPwd.sendKeys(EPwd);
				}
			
				public void firstName(String fName) {
					fname.sendKeys(fName);
				}
				
				public void lastName(String lName) {
					lname.sendKeys(lName);
				}
				
				public void selectDropdown() throws InterruptedException {
					Thread.sleep(1000);
					countryDropdown.click();
					
				}
				public void countrySearch(String country) {
					//countrySearch.sendKeys("Indi");
					countrySearch.sendKeys(country);
				}
				
				public void country() {
					country.click();
				}
				
				public void gender() {
					gender.click();
				}
				public void terms() {
					terms.click();	
				}
				
				public void done() throws InterruptedException {
					System.out.println(done.getText());
					/*Thread.sleep(5000);
					System.out.println(msg.getText());
					Thread.sleep(1500);*/
					
				}
				
				public void allow() {
					//deny.click();
					allow.click();
				}
				
				public void currentLocation() throws InterruptedException {
					locationRefresh.click();
					Thread.sleep(3000);
					System.out.println(location.getText());
					//org.openqa.selenium.html5.Location location=driver.location(); 
					
					System.out.println("location.getCoordinates()  ===> "+location.getCoordinates());
					
					System.out.println("location.getLocation()   ==> "+location.getLocation());
					
				}
				
				
}
	
	

