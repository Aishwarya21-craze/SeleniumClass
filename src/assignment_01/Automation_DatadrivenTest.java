package assignment_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.Screencapture;

public class Automation_DatadrivenTest {

	static WebDriver driver;
	public ExtentReports exreport;
	public ExtentTest extest;
	Screencapture ss = new Screencapture();
	
	@BeforeClass()
	public void startreport()
	{
	 	exreport = new ExtentReports("C:\\Users\\Hp\\eclipse-workspace\\Selenium\\test-output"+"\\exreportgen\\first"+".html");
	    exreport.addSystemInfo("Hostname","Local host");
	    exreport.addSystemInfo("Browser","Chrome");
	    exreport.addSystemInfo("Environment","Prod");
	    exreport.addSystemInfo("UserName","Aishu");
	    exreport.addSystemInfo("OS","Windows");
	}
	
	@AfterClass()
	public void stopreport()
	{
		exreport.flush();
	}

	
	@BeforeTest
	public void Start() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
         driver.get("http://demo.guru99.com/test/login.html");
         driver.manage().window().maximize();
	}
	@Test
	public void loginmodule() throws IOException {
		File file = new File("C:\\Users\\Hp\\Downloads\\LatestDatadrivenTest.xlsx");
		FileInputStream ff = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(ff);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum();
		System.out.println("No of rows are " + rowcount);
		
		int colcount = sheet.getRow(0).getLastCellNum();
		System.out.println("No of cols are " + colcount);

		for (int i=1;i<=rowcount;i++) {
			XSSFRow currentrow = sheet.getRow(i);
			String testemail = currentrow.getCell(0).toString();
			String testpass = currentrow.getCell(1).toString();
			
			WebElement email = driver.findElement(By.id("email"));
	    	email.sendKeys(testemail);
	    	WebElement pass = driver.findElement(By.id("passwd")); 
	    	pass.sendKeys(testpass);
	    	driver.findElement(By.id("SubmitLogin")).click();	
	    	String actual = driver.getTitle();
	    	Assert.assertEquals(actual, "","Login fails");
	    	extest.log(LogStatus.PASS, "Login is successful");
	    	extest.addScreenCapture(ss.savescreen("V1", driver));
	        exreport.endTest(extest);
	    	
	    	}
		}
		
	 @AfterTest
	    public void terminate() {
	    	driver.quit();
	 }	
}
