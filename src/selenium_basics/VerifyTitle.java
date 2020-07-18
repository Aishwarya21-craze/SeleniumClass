package selenium_basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class VerifyTitle {
	static WebDriver driver;
	
	@BeforeTest
	public void startsession() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	}
	@Test
	public void verifylandingpage() {
		driver.get("http://learn-automation.com/");
		driver.manage().window().maximize();
        String Actual = driver.getTitle();
        String expected = "Automation - Selenium WebDriver tutorial Step by Step";
        
        //Assert.assertEquals(Actual, expected);
        Assert.assertTrue(Actual.contains(expected));
        System.out.println("Title is loaded");
	}
	@AfterTest
	public void terminatesession() {
		driver.quit();
	}

}
