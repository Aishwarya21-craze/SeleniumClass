package assignment_01;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.Screencapture;

public class Automation_TestCases {
	
	static WebDriver driver;
	Screencapture res_sc = new Screencapture();
	
	@BeforeTest
	public void Start() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
         driver.get("http://demo.guru99.com/test/login.html");
         driver.manage().window().maximize();
	}
	
    @Test
    public void TestCase1() {
    	//System.out.println(driver.getTitle());
    	WebElement email = driver.findElement(By.id("email"));
    	email.sendKeys("aishu01@getnada.com");
    	WebElement pass = driver.findElement(By.id("passwd")); 
    	pass.sendKeys("Test@123");
    	driver.findElement(By.id("SubmitLogin")).click();
    	res_sc.savescreen("assignmentTC1", driver);
    	String actual = driver.getTitle();
    	Assert.assertEquals(actual, "", "Login fails");
    }
    
    
    
    @Test
    public void TestCase2() {
    	driver.navigate().to("http://demo.guru99.com/test/login.html");
    	//System.out.println(driver.getTitle());
    	WebElement email = driver.findElement(By.id("email"));
    	email.sendKeys("aishu01@getnada.com");
    	WebElement pass = driver.findElement(By.id("passwd")); 
    	pass.sendKeys("Test@123");
    	driver.findElement(By.id("SubmitLogin")).click();
    	res_sc.savescreen("assignmentTC2", driver);
    	String actual = driver.getTitle();
    	Assert.assertEquals(actual, "jhjfhe","Login fails");
    }
    
    
    @AfterTest
    public void terminate() {
    	driver.quit();
    }
    
}
