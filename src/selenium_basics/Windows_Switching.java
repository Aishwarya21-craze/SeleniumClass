package selenium_basics;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows_Switching {

	public static void main(String[] args) {
    
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Hp\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
         
        driver.get("https://www.naukri.com/");
        driver.manage().window().maximize();
        String hometitle = driver.getTitle();
        System.out.println("Title of the home is " + hometitle);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/button")).click();
       // WebElement a = driver.findElement(By.className("fr geoLocBtn sure"));
        Alert a = driver.switchTo().alert();
        
        
        // Assigning var to window handles
		Set<String> s = driver.getWindowHandles();
		
		//Changing the set to ob array
		Object[] list = s.toArray();
		
		// Getting the no of windows opened in a session
		System.out.println(list.length);
		
		int count = list.length;
		for(int i = 0; i<count; i++) {
		//getting name of the windows
			System.out.println("Window " + i + "name is" + list[i]);
			
			driver.switchTo().window((String) list[i]);
			System.out.println("The title of window is " + driver.getTitle());
			
			// validating the title of home to close the other windows
			if(!driver.getTitle().equalsIgnoreCase(hometitle))
			{
				driver.close();
				System.out.println("Driver is closed");
			}
			
			
		
		
		
	}
	}
}
