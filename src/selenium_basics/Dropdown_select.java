package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_select {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 driver.get("https://www.amazon.in/");
		 WebElement var = driver.findElement(By.name("url"));
		Select val = new Select(var);
		
		val.selectByValue("search-alias=stripbooks");
	
		System.out.println("Dropdown is selected");

		driver.quit();
		
	}

}
