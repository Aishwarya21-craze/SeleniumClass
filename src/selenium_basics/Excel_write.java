package selenium_basics;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel_write {

	public static void main(String[] args) throws IOException {

   // System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
    //WebDriver driver = new ChromeDriver();
    FileOutputStream file = new FileOutputStream("C:\\Users\\Hp\\Downloads\\Poijar.xlsx");
    XSSFWorkbook wb = new XSSFWorkbook();
    XSSFSheet sheet = wb.createSheet("Sheet1");
    
    for(int i=0;i<4;i++) {
    	XSSFRow currentrow = sheet.createRow(i);
    	
    	for(int j=0;j<4;j++) {
    		currentrow.createCell(j).setCellValue("10");
    		
    		System.out.println("Test is passed" + i + j );
    	}
    	file.close();
    			
    }
    
	}

}
