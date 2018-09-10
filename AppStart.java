package package1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppStart {
	public static AndroidDriver driver;
	Logger logger=Logger.getLogger("AppStart");
	@Test 
	public void start() throws MalformedURLException {
		//when we know app package and activity names
		File f=new File(System.getProperty("user.dir")); 
		File fs=new File(f,"/apk/mrandmrs.apk");
		DesiredCapabilities cap=new DesiredCapabilities();
		 cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
				 /*cap.setCapability("autoGrantPermissions", true);
				cap.setCapability("unicodeKeyboard", true);
				cap.setCapability("resetKeyboard", true);
				
				cap.setCapability("appPackage", "com.tvisha.mrandmrs");
				 cap.setCapability("appActivity", "com.tvisha.mrandmrs.screens.registration.RegMobileActivity");*/
				cap.setCapability("appPackage", "com.tvisha.mrandmrs");
				 cap.setCapability("appActivity", "com.tvisha.mrandmrs.screens.registration.RegMobileActivity");
				driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				PropertyConfigurator .configure("/home/sireesha/eclipse-workspace/MrandMrsProject/log4j.properties");
				logger.info("Mr&Mrs app is launched");
				// driver.findElementById("com.tvisha.mrandmrs:id/heading").click();
				
				

	}

}
