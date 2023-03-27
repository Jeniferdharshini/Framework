package genericUtility;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class WebdriverUtility {

		public void implicity_wait(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		public void getAlertAccept(WebDriver driver)
		{
			Alert alt = driver.switchTo().alert();
			alt.accept();

		}
		
		public void getAlertDismiss(WebDriver driver)
		{
			Alert alt = driver.switchTo().alert();
			alt.dismiss();

		
		}

}
