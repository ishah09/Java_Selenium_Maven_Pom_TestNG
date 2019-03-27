/*
 * This method of Browser launching, calling Browser driver from Maven dependency WebDrivermanager. 
 */

package BasicSeleniumDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCall_Method3 {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		System.out.println("this is main test method");
		driver.get("https://www.google.co.in");
		driver.quit();
	}
}
