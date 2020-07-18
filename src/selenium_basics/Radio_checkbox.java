package selenium_basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radio_checkbox {

	public static void main(String[] args) {
		
   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
   
   WebDriver driver = new ChromeDriver();
   
   driver.get("http://demo.guru99.com/test/radio.html");
   
   driver.manage().window().maximize();
   
  List<WebElement> radio = driver.findElements(By.xpath("//*[@name='webform' and @type='radio']"));
  
  for(int i=0;i<radio.size();i++) {
	  
	 WebElement radioite = radio.get(i);
	 
	 String val = radioite.getAttribute("value");
	 
	// System.out.println("The radio button names are " + radval); To print all the radio button names
	 
	 if(val.equalsIgnoreCase("Option 3"))
	 {
		 radioite.click();
		 System.out.println("Radio button " + i + " is clicked");
	 }
	 }
	 	
	 // multiple selection check box
	 
	 List<WebElement> check = driver.findElements(By.xpath("//*[@name='webform'and @type='checkbox']"));
	
	 for(int j=0;j<check.size();j++) {
		 
		 WebElement checkite = check.get(j);		
         checkite.click();
         System.out.println("Checkbox " + j + " is clicked");
         
		
	 }
		 
	driver.quit();
	}
}
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
