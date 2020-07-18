/**
 * 
 */
package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Dropdown_href {
	public static void main(String[] args) {
		Dropdown_href obj = new Dropdown_href();
		obj.dropdownselection();
	}
 
	public void dropdownselection() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/");
		driver.manage().window().maximize();
		WebElement ddbox = driver.findElement(By.className("dropdown-toggle"));
		ddbox.click();
		WebElement loginoption = driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[11]/a"));
		loginoption.click();
		String display = driver.getCurrentUrl();
		if(display.equals("http://demo.guru99.com/test/login.html"))
		{
			System.out.println("The next page is redirected");
		}
		else
			System.out.println("Invalid ascreen");
	driver.quit();	
	}
}
