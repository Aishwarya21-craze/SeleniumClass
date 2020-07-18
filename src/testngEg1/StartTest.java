package testngEg1;

import org.testng.annotations.Test;

public class StartTest {

	@Test(priority=7, groups = "Smoke")
	public void Initiate() {
		System.out.println("Sign up is successful");
		
	}
	@Test(priority=6)
	public void Middle(){
		System.out.println("Login is successful");
	}
	{
}
}
