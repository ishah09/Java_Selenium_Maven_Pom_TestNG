/*
 * This method of Browser launching, calling Browser driver from file location. 
 */

package BasicSeleniumDemos;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCall_Method1 {
	
	static WebDriver driver;
	static String driverpath = "E:\\chromedriver.exe";
	//String driverpath = "E:\\geckodriver.exe";
	
	public static void main(String [] args)
	{
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();	
		
		System.out.println("this is main test method");
		driver.get("https://www.google.co.in");		
		driver.quit();
	}
}
