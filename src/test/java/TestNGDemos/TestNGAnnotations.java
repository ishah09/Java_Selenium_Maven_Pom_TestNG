package TestNGDemos;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * This is demo which represents TestNG annotations 
 */

public class TestNGAnnotations {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite");		
	}

	@BeforeTest
	public void beforetest() {
		System.out.println("@BeforeTest");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");
	}

	@BeforeMethod
	public void beforemethod() {
		System.out.println("@BeforeMethod");
	}

	@Test
	public void firstmethod() {
		System.out.println("@Test firstMethod");
	}

	@Test
	public void secondmethod() {
		System.out.println("@Test secondMethod");
	}

	@AfterMethod
	public void aftermethod() {
		System.out.println("@AfterMethod");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
	}

	@AfterTest
	public void aftertest() {
		System.out.println("@AfterTest");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite");
	}
}

