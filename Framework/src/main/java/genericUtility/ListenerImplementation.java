package genericUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener {
	public void onTestFailure(ITestResult result) {
	String data = result.getMethod().getMethodName();
	System.out.println("Execute");
	EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver );
	File src=edriver.getScreenshotAs(OutputType.FILE);
	
		try {
			FileUtils.copyFile(src, new File("./Screeshot/"+data+".png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
