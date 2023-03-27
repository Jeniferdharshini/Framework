package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ObjectRepository.LoginPage;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.WebdriverUtility;
import genericUtility.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser extends BaseClass{

	//public static void main(String[] args) throws Throwable {
	//}
	@Test(groups="SmokeTest")
		public void Browser() throws Throwable {
		        //type1(Browser Launching)
				//WebDriver driver=new ChromeDriver();
		
		      //type2(Browser Launching)
		/*  String key="webdriver.chrome.driver"; 
		  String value="C:\\Users\\Riona\\Downloads\\chromedriver_win32\\chromedriver.exe";
		  //String Value="./src/main/resources/chromedriver.exe";
		  System.setProperty(key, value);
		  WebDriver driver = new ChromeDriver();*/
		  
		//type3(Browser Launching)
		PropertyUtility proutil = new PropertyUtility();
		/* String BROWSER = proutil.getKeyValue("browser");
		WebDriver driver = null;
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
		}*/
		
		WebdriverUtility wd=new WebdriverUtility();
		wd.implicity_wait(driver);
		  
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/*
		 * driver.get("https//demo.actitime.com/login.do");
		 * driver.findElement(By.id("username")).sendKeys("admin");
		 * driver.findElement(By.name("pwd")).sendKeys("manager");
		 * driver.findElement(By.id("loginButton")).click();
		 */
	/*	FileInputStream fis = new FileInputStream("./src/test/resources/propertyfile.txt");

		Properties pro = new Properties();

		pro.load(fis);

		String URL = pro.getProperty("url");

		String USERNAME = pro.getProperty("username");

		String PASS = pro.getProperty("password");
		*/

		String URL = proutil.getKeyValue("url");
		String USERNAME = proutil.getKeyValue("username");
		String PASS = proutil.getKeyValue("password");
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginData(USERNAME, PASS);
		Thread.sleep(1000);
/*
	    driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.name("pwd")).sendKeys(PASS);
		driver.findElement(By.id("loginButton")).click();*/

    	driver.findElement(By.xpath("(//div[@class='menu_icon'])[2]")).click();
		driver.findElement(By.xpath("//a[text()='Types of Work']")).click();
		driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
		
		JavaUtility ju=new JavaUtility();
		int ranno=ju.getRanDomNum();

		//Random ran=new Random();
		//int ranno = ran.nextInt(1000);

		/*FileInputStream fie = new FileInputStream("./src/test/resources/Seleniumdata.xlsx");
		Workbook book = WorkbookFactory.create(fie);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(0);
		String exceldata = cel.getStringCellValue()+ranno;
		driver.findElement(By.id("name")).sendKeys(exceldata);*/
		Thread.sleep(1000);
		ExcelUtility eu=new ExcelUtility();
		String exceldata = eu.getExcelDataByFormatter("Sheet1", 1, 0)+ranno;
		driver.findElement(By.id("name")).sendKeys(exceldata);
		//driver.findElement(By.xpath("//input[@value='   Create Type of Work   ']")).click();
		driver.findElement(By.xpath("//input[@onclick='handleCancel();']")).click();
  	   wd.getAlertAccept(driver);
		//Alert alt = driver.switchTo().alert();
		//alt.accept();
		//alt.dismiss();
	}

}
