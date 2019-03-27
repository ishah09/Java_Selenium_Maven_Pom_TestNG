/*
 * This method of Browser launching, calling Browser driver from System properties(Environment Variable). 
 */

package BasicSeleniumDemos;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCall_Method2 {
	
	static WebDriver driver;
	
	public static void main(String [] args)
	{
		driver = new ChromeDriver();	
		
		System.out.println("this is main test method");
		driver.get("https://www.google.co.in");		
		driver.quit();
	}
}
