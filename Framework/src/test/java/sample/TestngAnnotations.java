package sample;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestngAnnotations {
	WebDriver driver;
	
	public void launchAmazon() {
		driver.get("https://www.amazon.com/");
	}

}
