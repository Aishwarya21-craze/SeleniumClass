package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class basic_flow {

	public static void main(String[] args) {
		basic_flow obj = new basic_flow();
   obj.emailid_test("aishu1@getnada.com");
	}
	
	public void emailid_test(String id_name) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
 driver.get("http://demo.guru99.com/");
 driver.manage().window().maximize();
 WebElement email_bx = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input"));
 email_bx.sendKeys(id_name);
 WebElement Submit_bt = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input"));
 Submit_bt.click();
 driver.quit();
 
	}
}
