package BasicSeleniumDemos;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class handleMultipleTabs {

	@Test
	public void multiTabDemo() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Navigate to Google
		driver.get("http://www.google.com");

		// Locate the searchbox using its name
		WebElement element = driver.findElement(By.name("q"));

		// Enter a search query
		element.sendKeys("Guru99");

		// Submit the query. Webdriver searches for the form using the text input
		// element automatically
		// No need to locate/find the submit button
		element.submit();

		// This code will print the page title
		System.out.println("Page title is: " + driver.getTitle());

		((JavascriptExecutor) driver).executeScript("window.open()");

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));

		// Navigate to Google
		driver.get("http://www.google.com");

		// Locate the searchbox using its name
		WebElement element1 = driver.findElement(By.name("q"));

		// Enter a search query
		element1.sendKeys("Selenium");

		// Submit the query. Webdriver searches for the form using the text input
		// element automatically
		// No need to locate/find the submit button
		element1.submit();

		// This code will print the page title
		System.out.println("Page title is: " + driver.getTitle());

		((JavascriptExecutor) driver).executeScript("window.open()");

		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));

		// Navigate to Google
		driver.get("http://www.google.com");

		// Locate the searchbox using its name
		WebElement element2 = driver.findElement(By.name("q"));

		// Enter a search query
		element2.sendKeys("Software Testing");

		// Submit the query. Webdriver searches for the form using the text input
		// element automatically
		// No need to locate/find the submit button
		element2.submit();

		// This code will print the page title
		System.out.println("Page title is: " + driver.getTitle());

		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(tabs.size() - 2));
		
		// This code will print the page title
		System.out.println("Page title is: " + driver.getTitle());
		driver.quit();
	}
}
