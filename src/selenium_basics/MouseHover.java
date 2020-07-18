package selenium_basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseHover {
static WebDriver driver;
	
	@BeforeTest
	public void startsession() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	}
	
	@Test
	public void mousehover() {
		driver.get("https://seleniumpractise.blogspot.com/search?q=mouse");
		WebElement el = driver.findElement(By.xpath("//button[@class='dropbtn']"));
		Actions act = new Actions(driver);
		act.moveToElement(el).perform();
        List <WebElement> choose = driver.findElements(By.xpath("//div[@id='post-body-4229879368008023176']//a"));		
        
        int countlinks = choose.size();
        
		for(int i=0;i<countlinks;i++) {
			WebElement ch1 = choose.get(i);
			
           String linkname =  ch1.getAttribute("innerHTML");
           System.out.println("Linkname is " + linkname);
           
		if(linkname.contains("TestNG")) {
			ch1.click();
			
		}
	}
		
	}
	
	@AfterTest
	public void terminatesession() {
		driver.quit();
	}
	
	
}
