package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screencapture {
	public String savescreen(String ssname, WebDriver driver) {
		TakesScreenshot screenobj = (TakesScreenshot)driver;
		String date = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		File source = screenobj.getScreenshotAs(OutputType.FILE);
		String path = ("C:\\Users\\Hp\\eclipse-workspace\\Selenium\\test-output" + "\\screenshots\\AutomationScreenshots"+ ssname + date +".png");
		File destination = new File(path);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		
	}
	

}
