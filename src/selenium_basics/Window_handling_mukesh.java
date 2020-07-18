package selenium_basics;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_handling_mukesh {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
        
        driver.get("https://www.naukri.com/");
        
        driver.manage().window().maximize();
        // to get parent window name
        
        String parent = driver.getWindowHandle();
        
        System.out.println("The parent window is " + parent);
        
        //to get no of windows
        
        Set<String> all = driver.getWindowHandles();
        
        int count = all.size();
        
        System.out.println("no of windows are " + count);
        
        for(String child : all) {
                
        if(!child.equalsIgnoreCase(parent)) {
        
            driver.switchTo().window(child);
            driver.close();
        	
        }
        }
        
        driver.switchTo().window(parent);
        System.out.println("The title of parent is " + driver.getTitle());
        
        driver.quit();
        
	}

}
