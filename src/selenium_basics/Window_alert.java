package selenium_basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;


public class Window_alert {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		WebElement customer = driver.findElement(By.xpath("//input[@name='cusid']"));
		customer.sendKeys("8978978978");
		WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
		submit.click();
		
		//Accepting first alert & then the second one too
		
		Alert alert_handling = driver.switchTo().alert();
	    alert_handling.accept();
	    System.out.println("The first alert message was accepted");
	    alert_handling.dismiss();
	    System.out.println("The second one was also accepted");
	    
	    
	    /*Validating the alert message text with Assert 
	    String actual_msg = alert_handling.getText();
	    System.out.println("The alert message is " + actual_msg);
		String expected_msg = "The alert message is Customer Successfully Delete!";
		 
		Assert.assertEquals(expected_msg, actual_msg);
		*/

       //driver.quit();
		
		
	}

}
