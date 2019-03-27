package SuiteStructure;

import org.testng.annotations.Test;

/*
 * This is test, which is calling common TestNG annotation, if its common pre-post requisite for all tests.  
 * It call BaseClassConfiguration methods-annotations, in multiple tests. 
 */
public class ScriptConnectionWithTestNGUtility extends BaseClassConfiguration {	
	@Test
	public void testMethod01() {		
		System.out.println("This is test method01");
	}
	
	@Test
	public void testMethod02() {		
		System.out.println("This is test method02");
	}
}
