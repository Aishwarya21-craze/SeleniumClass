package selenium_basics;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {

	
	@Test(priority=4)
	public void softassertion() {
		System.out.println("TC2 Started");
		
		//create obj of softassert
		SoftAssert ob = new SoftAssert();
		ob.assertEquals(12, 111111, "Dropdown count is not correct");
		System.out.println("TC2 completed");
		
		//below line is mandatory for softassert
		ob.assertAll();
	}
	@Test(priority=5)
	public void hardassertion() {
         System.out.println("TC1 started");
         Assert.assertEquals(12, 14, "Dropdown count mismatches");
         System.out.println("TC1 Completed");
		
	}
	
	
	
}
