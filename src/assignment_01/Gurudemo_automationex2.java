package assignment_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.HTMLReporter;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.Screencapture;

public class Gurudemo_automationex2 {	
	static WebDriver driver;
	public ExtentReports exreport;
	public ExtentTest extest;
	Screencapture ss = new Screencapture();
	
		
	@BeforeClass()
	public void startreport()
	{
	 	exreport = new ExtentReports("C:\\Users\\Hp\\eclipse-workspace\\Selenium\\test-output"+"\\exreportgen\\first.html");
		/*
		 * exreport.addSystemInfo("Hostname","Local host");
		 * exreport.addSystemInfo("Browser","Chrome");
		 * exreport.addSystemInfo("Environment","Prod");
		 * exreport.addSystemInfo("UserName","Aishu");
		 * exreport.addSystemInfo("OS","Windows");
		 */
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
    public void TestCase1() throws InterruptedException {
        
    	extest = exreport.startTest("TestCase1");
    	
    	WebElement email = driver.findElement(By.id("email"));
    	email.sendKeys("aishu01@getnada.com");
    	WebElement pass = driver.findElement(By.id("passwd")); 
    	pass.sendKeys("Test@123");
    	driver.findElement(By.id("SubmitLogin")).click();
    	String actual = driver.getTitle();
        Assert.assertEquals(actual,"", "Login fails");
    	 
    	extest.log(LogStatus.PASS, "Login is successful" + actual + extest.addScreenCapture(ss.savescreen("V1", driver)));
        exreport.endTest(extest);
        Thread.sleep(6000);
    }
    
    @Test
    public void TestCase2() {
    	
    	extest = exreport.startTest("TestCase2");
    	driver.navigate().to("http://demo.guru99.com/test/login.html");
        driver.manage().window().maximize();
      	WebElement email = driver.findElement(By.id("email"));
    	email.sendKeys("aishu02@getnada.com");
    	WebElement pass = driver.findElement(By.id("passwd")); 
    	pass.sendKeys("Test@124");
    	driver.findElement(By.id("SubmitLogin")).click();
    	String actual = driver.getTitle();
    	Assert.assertTrue(actual.contains(""), "Test case is failed");
    	/*
     	if(!(actual=="")) {
		System.out.println("Login is failed");
	}
	    SoftAssert ass = new SoftAssert();
	    ass.assertEquals(actual, "78uiy","Login is failed for invalid user");
	    ass.assertAll();
	    */
    	
    	extest.log(LogStatus.FAIL, "Login is failed" + extest.addScreenCapture(ss.savescreen("V2", driver)));
        exreport.endTest(extest);
    }
    
    
    @AfterTest
    public void terminate() {
    	driver.quit();
    }
	
}
