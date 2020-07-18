package selenium_basics;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_handling2 {

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
        
        ArrayList<String> list = new ArrayList<String>(all);
        
        for(int i=0;i<count;i++) {
        	list.get(i);
            driver.switchTo().window(list.get(i));
            
        	if(!driver.getTitle().equalsIgnoreCase("Jobs - Recruitment - Job Search - Employment -Job Vacancies - Naukri.com"))
        	{
              driver.close();
        	
        }
        	
        	driver.switchTo().window(parent);
		
	}
	}

}
