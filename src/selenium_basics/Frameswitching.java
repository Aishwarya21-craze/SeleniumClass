package selenium_basics;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utilities.Screencapture;

public class Frameswitching {
	static WebDriver driver;

@Test
	public void OpenBrowser() {
	System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Hp\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    
    Screencapture sobj = new Screencapture();
    
    driver.get("http://demo.guru99.com/test/guru99home/");
    driver.manage().window().maximize();
      
		int count = driver.findElements(By.tagName("iframe")).size();
		System.out.println("The no of frames are " + count);
		
		WebElement ifrm = driver.findElement(By.name("a077aa5e"));
		driver.switchTo().frame(ifrm);
		
        driver.findElement(By.xpath("/html/body/a/img")).click();
        sobj.savescreen("framepage", driver);
        System.out.println("Screenshot is saved");
        
        
       // driver.findElement(By.id("awf_field-93653884")).sendKeys("aishu@getnada.com");
        //driver.findElement(By.id("af-submit-image-482158182")).click();
         
       /* driver.switchTo().defaultContent();
        System.out.println("I frame link is clicked" );
        System.out.println(driver.getCurrentUrl());
        
        driver.quit();
        */
	}
}
