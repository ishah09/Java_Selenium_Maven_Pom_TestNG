package BasicSeleniumDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class headlessDemo {

	@Test
	public void testHeadlesschrome() {

		// WebDriver driver = new HtmlUnitDriver();
		// WebDriver driver = new PhantomJSDriver();

		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--headless", "--disable-gpu"); WebDriver driver = new
		 * ChromeDriver(options);
		 */

		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless", "--disable-gpu");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(options);

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

		driver.quit();

	}

}
