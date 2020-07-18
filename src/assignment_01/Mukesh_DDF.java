package assignment_01;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.Read_data;
import Utilities.Screencapture;

public class Mukesh_DDF {
	
	public ExtentReports exreport;
	public ExtentTest extest;
	WebDriver driver;
	Screencapture ss = new Screencapture();
	
	@Test
	public void datadriven() throws IOException {
	Read_data logintest = new Read_data("C:\\Users\\Hp\\Downloads\\LatestDatadrivenTest.xlsx");
		
    String emailid = logintest.getdata(0, 1, 0);
    String password = logintest.getdata(0, 1, 1);
    
    WebElement email = driver.findElement(By.id("email"));
	email.sendKeys(emailid);
	WebElement pass = driver.findElement(By.id("passwd")); 
	pass.sendKeys(password);
	driver.findElement(By.id("SubmitLogin")).click();	
	String actual = driver.getTitle();
	Assert.assertEquals(actual, "","Login fails");
	extest.log(LogStatus.PASS, "Login is successful");
	extest.addScreenCapture(ss.savescreen("V1", driver));
    exreport.endTest(extest);
		
	}


	
}
