package TroopMessengerApp;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.GetScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;




public class Troopbase extends Demo1{
	 AndroidDriver<AndroidElement> driver;
	 public static ExtentHtmlReporter htmlReport;
	 public static ExtentReports  extentReport;
	 public static ExtentTest extentTest;
	 public static ExtentColor color;
	 String file="/home/sireesha/Desktop/sample/Trpmsngr_profile.html";
	 String test="testerr"; 
	 @BeforeSuite
	 public void htmlReportSetup() {
		 
		 htmlReport=new ExtentHtmlReporter(file);
		 extentReport=new ExtentReports();
		 extentReport.attachReporter(htmlReport);
		 htmlReport.config().setReportName("TroopMessengerApk_RegreessionTesting");
		 htmlReport.config().setDocumentTitle("TroopMessengerApk");
		 htmlReport.config().setTheme(Theme.STANDARD);
		 htmlReport.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		 extentReport.setSystemInfo("HostName", "tvisha-desktop");
		 extentReport.setSystemInfo("Filename", "TroopMessenger_LocalApk");
		
	
		 }

	@BeforeTest
	public  void testDemo() throws MalformedURLException {
		startRecording("test");
		extentTest=extentReport.createTest("APP LAUNCH");
		 
		File f = new File("src");
		File f1 = new File(f, "TroopMsngrlocal.apk");
		//File f1=new File(f,"NewOneTrp.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.APP, f1.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability("appPackage", "com.tvisha.troopmessenger");
		cap.setCapability("appActivity", "com.tvisha.troopmessenger.activity.SplashScreenActivity");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement e=driver.findElementById("com.tvisha.troopmessenger:id/logo");
		WebDriverWait wt=new WebDriverWait(driver, 10);
		wt.until(ExpectedConditions.visibilityOf(e));
		if(e.isDisplayed()) {
			extentTest.log(Status.PASS, MarkupHelper.createLabel("App is Launched", color.GREEN));
		}
		
		
	}
	/*@BeforeMethod
	public void startmethod() {
		startRecording("test");
	}*/
	@AfterMethod

		public void getResult(ITestResult result) throws IOException, InterruptedException {
			System.out.println("after method===============");
			if (result.getStatus() == ITestResult.FAILURE) {
				//stopRecording();	
				/*extentTest.log(Status.INFO,
						"<video width=\"320\" height=\"240\" controls>\n" + "  <source src=\"./mp4Result/" +"testvideo"+ videoName
								+ "\" type=\"video/mp4\">\n" + "Your browser does not support the video tag.\n"
								+ "</video>");*/
				
				extentTest.addScreenCaptureFromPath(getScreenshot(driver,test));
				 // to add screenshot in
			Thread.sleep(2000);

			// MarkupHelper is used to display the output in different colors
			extentTest.log(Status.FAIL,
			MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
//				logger.log(Status.FAIL,
//				MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			
			} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP,
			MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
			extentTest.log(Status.SKIP,
			MarkupHelper.createLabel(result.getThrowable() + " - Test Case Skipped", ExtentColor.ORANGE));
			} else if (result.getStatus() == ITestResult.SUCCESS) {
			
				extentTest.log(Status.PASS,
			MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
			Thread.sleep(1300);
			
			
			/*extentTest.log(Status.INFO,
					"<video width=\"320\" height=\"240\" controls>\n" + "  <source src=\"./mp4Result/" +"testvideo"+ videoName
							+ "\" type=\"video/mp4\">\n" + "Your browser does not support the video tag.\n"
							+ "</video>");
*/
		}
			
	}
	public static String getScreenshot(AndroidDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
		+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		}
	
	@AfterTest
	public void htmlClose() {
		System.out.println("============Scenario completed===========");
		stopRecording();
	//	System.err.println("recording stopped");
		extentReport.flush();
		System.out.println("Execution Done!!!");
	}
}
