/*package TroopMessengerApp;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

public class unread extends Troopbase {
	int index1=0;
	public void sss() throws Exception  {
		List<AndroidElement> grplist=driver.findElementsByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout/");
		
		int m=msgCount.size();
		int	s=unreadmsgCount.size();
		System.out.println("==>list size   :"+s);
		String txt=msgCount.get(m-1).getText();
		List<HashMap> grp_info=new ArrayList<HashMap>();
		HashMap<String, String>hash=new HashMap<String,String>();
		grp_info.add(hash);
		for(AndroidElement grp : unreadmsgCount) {
			hash.put("msgscount", grp.getText());
			index1++;
			System.out.println("value is=====>"+grp.getText());
		}
		
		swipeVertical((AppiumDriver)driver,0.9,0.1,0.5,3000);
		Thread.sleep(2000);
		int m1=msgCount.size();
		System.out.println("after scroll=======>"+m1);
		if(txt.equals(msgCount.get(m1-1).getText())) 
		{
				System.out.println("==========>rows are repeating");
		}
		else {
			sss();
			}
		System.out.println("count is=====>"+index1);
		
	}
	@SuppressWarnings("rawtypes")
	public static void swipeVertical(AppiumDriver driver2, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
	    Dimension size = driver2.manage().window().getSize();
	    int anchor = (int) (size.width * anchorPercentage);
	    int startPoint = (int) (size.height * startPercentage);
	    int endPoint = (int) (size.height * finalPercentage);
	    new TouchAction(driver2).press(anchor, startPoint).waitAction(Duration.ofMillis(duration)).moveTo(anchor, endPoint).release().perform();
	}
	

}
*/