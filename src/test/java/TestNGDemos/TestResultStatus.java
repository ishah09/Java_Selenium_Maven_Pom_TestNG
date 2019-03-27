package TestNGDemos;

import org.testng.annotations.Test;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

/*
 * This demo represents ITestResult usage, with AfterMethod
 * It calls after every method, and throw test status with Pass-Fail-Skip
 */

public class TestResultStatus {
	@Test
	public void test01() {
		System.out.println("This is test01");
	}

	@Test
	public void test02() {
		System.out.println("This is test02");		
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This is After method");
	}

	public void testStatus(ITestResult result) throws Exception {
		String testResult = "";
		if (result.getStatus() == ITestResult.FAILURE) {
			testResult = "Test Fail :" + result.getName() + result.getAttributeNames();
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			testResult = "Test Pass :" + result.getName();
		} else if (result.getStatus() == ITestResult.SKIP) {
			testResult = "Test Skip :" + result.getName();
		} else {
			testResult = "Test Undefined :" + result.getName() + "<br>Status : " + result.getStatus();
		}
		System.out.println("TestResult :"+testResult);
	}
}
