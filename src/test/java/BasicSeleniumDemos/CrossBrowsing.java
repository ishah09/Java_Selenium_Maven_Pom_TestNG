package BasicSeleniumDemos;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowsing {

	String browserType = "chrome";
	WebDriver driver;
	Capabilities browserCap;

	@Test
	public void browserLaunch() {
		// Driver Calling with Respective Browser

		if (browserType.contains("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		} else if (browserType.contains("firefox")) {

			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		} else if (browserType.contains("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("No browser Found.");
		}

		browserCap = ((RemoteWebDriver) driver).getCapabilities();
		browserCap.getBrowserName();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.navigate().to("http://google.com");
		driver.quit();
	}
}
