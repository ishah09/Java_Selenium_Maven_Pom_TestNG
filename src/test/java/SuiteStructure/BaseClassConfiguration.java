package SuiteStructure;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

/*
 * This is common base class for configuration purpose. 
 * All common methods can be struct here, and further it can be call in Tests. *  
 */

public class BaseClassConfiguration {
	
	@BeforeSuite
	public void checkBeforeSuite()
	{
	System.out.println("This is before suite");	
	}
	
	@BeforeMethod 
	public void checkBeforeMethod()
	{
	System.out.println("This is before method");	
	}
	
	@AfterMethod
	public void checkAfterMethod()
	{
	System.out.println("This is after method");	
	}
}
