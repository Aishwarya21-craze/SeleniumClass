package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyErrorMessages {
static WebDriver driver;
	
	@BeforeTest
	public void startsession() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	}
	@Test
	public void verifyerrormessage() {
		driver.get("https://gmail.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		WebElement error = driver.findElement(By.xpath("//div[@class='o6cuMc']"));
		String actual = error.getText();
        String expected = "Enter an email or phone number";
        
        Assert.assertEquals(actual, expected);
       // Assert.assertTrue(actual.contains(expected));
        System.out.println(actual);
	}
	@AfterTest
	public void terminatesession() {
		driver.quit();
	}


}
