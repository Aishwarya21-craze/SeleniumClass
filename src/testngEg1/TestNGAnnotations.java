package testngEg1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	@Test(priority = 0, groups = "Regression")
	public void test01() {
		System.out.println("At test 01");
	}

	@Test(groups = "Smoke")
	public void test02() {
		System.out.println("At test 02");
	}
	

	@BeforeTest
	public void beforetest() {
		System.out.println("At before test");
	}

	@AfterTest
	public void aftertest() {
		System.out.println("At after test");
	}

	@BeforeMethod
	public void beforemethod() {
		System.out.println("At before method");
	}

	@AfterMethod
	public void aftermethod() {
		System.out.println("At after method");
	}

	@BeforeClass
	public void beforeclass() {
		System.out.println("At before class");
	}

	@AfterClass
	public void afterclass() {
		System.out.println("At after class");
	}
	
	@BeforeSuite
	public void beforesuite() {
		System.out.println("At before suite");
	}

	@AfterSuite
	public void aftersuite() {
		System.out.println("At after suite");
	}
	
	
}
