package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_data {
	
	XSSFWorkbook wb;
	XSSFSheet sh;

	//constructor to load the data when everytime called
	public Read_data(String xlpath) throws IOException {
		try {
			File path = new File(xlpath);
		
			FileInputStream fis = new FileInputStream(path);
			
			wb = new XSSFWorkbook(fis);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
		public String getdata(int sheetnum,int row,int col) 
		{
			
			sh = wb.getSheetAt(sheetnum);
		     
			String current = sh.getRow(row).getCell(col).getStringCellValue();
			
			return current;
			
		}
			
		
	}

