package TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

/*
 * This is demo with static data provider data 
 * Without using excel,you can have variety of test data. 
 */
public class StaticDataProviderDemo {

	@Test(dataProvider = "searchProvider")
	public void mainmethodtest(String source, String keyword) throws InterruptedException {
		System.out.println("Welcome ->" + source + " Your search key is->" + keyword);
	}

	@DataProvider(name = "searchProvider")
	public Object[][] getdata() {
		return new Object[][] { { "Guru99", "India" }, { "Krishna", "UK" }, { "Bhupesh", "USA" } };
	}
}
