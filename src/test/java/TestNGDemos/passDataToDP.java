package TestNGDemos;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
 * This class contains TestNG data provider demo, 
 * Data provider gets data from Excel
 */

public class passDataToDP extends getDataFromExcel {

	@Test(dataProvider="getTestData")
	public void testDataProvider(String id, String userName, String passWord)
	{
			System.out.println(id + userName + passWord);
	}	
	
	@DataProvider
	public Object[][] getTestData() throws Exception {
		return readExcel();
	}
}
