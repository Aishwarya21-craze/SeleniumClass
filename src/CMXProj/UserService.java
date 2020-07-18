package CMXProj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserService {
static WebDriver driver;

	@BeforeTest
	public void startsession() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	}
	@Test(priority=0)
	public void verify_home_title() {
		driver.get("https://cmxweb.influx.co.in/");
		driver.manage().window().maximize();
		String actual_home = driver.getTitle();
        String expected_home = "CMX - Home";
        Assert.assertEquals(actual_home, expected_home);
       // Assert.assertTrue(actual.contains(expected));
        System.out.println("Title of homepage is " + actual_home);   
	}
	
	@Test(priority=1)
	public void Signin() {
		driver.findElement(By.linkText("Sign In")).click();
		System.out.println("The Sign in page title is " +  driver.getTitle());
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("aishum25@getnada.com");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Test@123");
		//driver.findElement(By.xpath("/section[@class='form-check']//label")).click();
		driver.findElement(By.id("btnlogin")).submit();
	    String afterlogin = driver.getCurrentUrl();
	}
	
		
	
	@AfterTest
	public void terminatesession() {
		driver.quit();
	}
	

}
