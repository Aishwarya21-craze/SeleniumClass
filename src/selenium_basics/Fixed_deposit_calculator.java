package selenium_basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Fixed_deposit_calculator {
	
		public static void main(String[] args) throws IOException {
			  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver_win32\\chromedriver.exe"); //Setup file path
			  WebDriver driver = new ChromeDriver(); //Launch chrome driver
			  driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true"); //Launch URL
			  driver.manage().window().maximize();
			  
			  // Setup file path  
			  File file = new File("C:\\Users\\Hp\\Downloads\\Fixed_deposit_calci.xlsx");
			  
			  //Read the file
			  FileInputStream ff = new FileInputStream(file);

			//Get workbook
			  XSSFWorkbook workbook = new XSSFWorkbook(ff);

			//Get the sheet
			  XSSFSheet sheet = workbook.getSheet("Sheet1");
				  
				  // Get row & col count
				  int rows = sheet.getLastRowNum();
				  System.out.println("No of rows are " + rows);
				  
				  int cols = sheet.getRow(0).getLastCellNum();
				  System.out.println("No of columns are " + cols);
				  
				  
				  for(int i=1;i<=rows;i++) {
					  
					  XSSFRow currentrow = sheet.getRow(i);
					  
					  int principal = (int)currentrow.getCell(0).getNumericCellValue();
					  int roi = (int)currentrow.getCell(1).getNumericCellValue();
					  int period = (int)currentrow.getCell(2).getNumericCellValue();
					  String freq = currentrow.getCell(3).getStringCellValue();
					  int exp_maturity = (int)currentrow.getCell(4).getNumericCellValue();
				    
					  driver.findElement(By.name("principal")).sendKeys(String.valueOf(principal));
					  driver.findElement(By.name("interest")).sendKeys(String.valueOf(roi));
					  driver.findElement(By.name("tenure")).sendKeys(String.valueOf(period));
					  
                      Select days = new Select(driver.findElement(By.name("tenurePeriod")));	
                      days.selectByVisibleText("year(s)");
                      
                      Select frequency = new Select(driver.findElement(By.name("frequency")));
					  frequency.selectByVisibleText(freq);
					  
					  driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
					  String actual_maturity = driver.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();
					  
					  if(Double.parseDouble(actual_maturity)==exp_maturity) {
						  System.out.println("Test case " + i + " is passed");
					  }
					  else {
						  System.out.println("Test case " + i + " is failed");
					  }
					  
					  driver.findElement(By.name("principal")).clear();
					  driver.findElement(By.name("interest")).clear();
					  driver.findElement(By.name("tenure")).clear();
					  
					 
				  }
				  driver.quit();
	}

}
