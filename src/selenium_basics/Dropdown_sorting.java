package selenium_basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Dropdown_sorting {

	public static void main(String[] args) {	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement dr = driver.findElement(By.id("products"));
		Select drpobj = new Select(dr);
		
		List original = new ArrayList();
		List temp = new ArrayList();
		
		List<WebElement> drop = drpobj.getOptions();
		
		for(WebElement r:drop) {
			original.add(r.getText());
			temp.add(r.getText());
		}
		
		
		//driver.findElements(By.xpath(""))
		
		System.out.println("Actual original values before sorting" + original);
		System.out.println("Actual temporary values before sorting" + temp);
		
		Collections.sort(temp);
		
		System.out.println("Actual original values after sorting" + original);
		System.out.println("Actual temporary values after sorting" + temp);
		
		if(original==temp) {
			System.out.println("Dropdown is sorted");
		}
		else {
			System.out.println("Dropdown is not sorted");
		}

	driver.quit();

	}
	
}
