package SuiteStructure;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * This is independent test, which has its own TestNG annotations. As according to its required. 
 * It can still call BaseClassConfiguration methods, in multiple tests. 
 */

public class IndependentScriptCallingTestNGUtility {

	BaseClassConfiguration objBaseClass = new BaseClassConfiguration();

	@BeforeMethod
	public void executeBeforeMethod() {
		objBaseClass.checkBeforeMethod();
	}

	@Test
	public void testMethod01() {
		System.out.println("This is test method01");
	}

	@Test
	public void testMethod02() {
		System.out.println("This is test method02");
	}

	@AfterMethod
	public void executeAfterMethod() {
		objBaseClass.checkAfterMethod();
	}
}
