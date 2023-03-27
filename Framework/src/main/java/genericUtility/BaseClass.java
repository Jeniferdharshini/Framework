package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(groups= {"SmokeTest","RegressionTest"})
	public void beforeSuite() {
		System.out.println("Dadabase open");
	}

	@BeforeTest(groups= {"SmokeTest","RegressionTest"})
	public void beforeTest() {
		System.out.println("parallel execution");

	}
	@Parameters("BROWSER")
	@BeforeClass(groups= {"SmokeTest","RegressionTest"})
	public void beforeClass() throws Throwable {
		//WebDriver driver = null;
				PropertyUtility proutil = new PropertyUtility();
				String BROWSER = proutil.getKeyValue("browser");

				if(BROWSER.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("edge")) {
					WebDriverManager.edgedriver().setup();
					driver=new EdgeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				}
				else{
					driver=new ChromeDriver();
				}
		   System.out.println("Launching browser");
		   sdriver=driver;

	}

	@BeforeMethod(groups= {"SmokeTest","RegressionTest"})
	public void beforeMethod() throws Throwable {
		PropertyUtility proutil = new PropertyUtility();
		String URL = proutil.getKeyValue("url");
		String USERNAME = proutil.getKeyValue("username");
		String PASS = proutil.getKeyValue("password");
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginData(USERNAME, PASS);
		System.out.println("login application");

	}
	@AfterMethod(groups= {"SmokeTest","RegressionTest"})
	public void afterMethod() {
		System.out.println("logout application");
	}

	@AfterClass(groups= {"SmokeTest","RegressionTest"})
	public void afterClass() {
		System.out.println("closing browser");

	}

	@AfterTest(groups= {"SmokeTest","RegressionTest"})
	public void afterTest() {
		System.out.println("parallel execution done ");

	}

	@AfterSuite(groups= {"SmokeTest","RegressionTest"})
	public void afterSuite() {
		System.out.println("database close");

	}
	

}
