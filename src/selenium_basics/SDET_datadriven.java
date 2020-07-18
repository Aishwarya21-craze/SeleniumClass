package selenium_basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SDET_datadriven {

	public static void main(String[] args) throws IOException {
     File file = new File("C:\\Users\\Hp\\Downloads\\Registration-SDET.xlsx");
     FileInputStream ff = new FileInputStream(file);
     try (XSSFWorkbook wb = new XSSFWorkbook(ff)) {
		XSSFSheet sheet= wb.getSheet("Sheet1");
		 int row = sheet.getLastRowNum();
		 System.out.println(row);
		 int col = sheet.getRow(0).getLastCellNum();
		 System.out.println(col);
		 for(int i = 0; i<row; i++) {
			 XSSFRow currentrow = sheet.getRow(i);
			 for (int j=0;j<col;j++) {
				 //currentrow.getCell(0).toString();
				String celldata = currentrow.getCell(j).toString();
				System.out.print("          "+celldata);
				 
			 }
			 System.out.println();
		 }
	}
     
     
		
		
	}

}
