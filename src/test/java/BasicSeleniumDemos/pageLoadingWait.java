package BasicSeleniumDemos;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pageLoadingWait {

	static WebDriver driver;
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	static WebDriverWait wait = new WebDriverWait(driver, 20);

	// Wait for JQuery Load
	public static void waitForJQueryLoad() {
		// Wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) js.executeScript("return jQuery.active") == 0);

		// Get JQuery is Ready
		boolean jqueryReady = (Boolean) js.executeScript("return jQuery.active==0");

		// Wait JQuery until it is Ready!
		if (!jqueryReady) {
			// System.out.println("JQuery is NOT Ready!");
			// Wait for jQuery to load
			wait.until(jQueryLoad);
		} else {
			// System.out.println("JQuery is Ready!");
		}
	}

	// Wait for Angular Load
	public static void waitForAngularLoad() {
		String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

		// Wait for ANGULAR to load
		ExpectedCondition<Boolean> angularLoad = driver -> Boolean
				.valueOf(((JavascriptExecutor) driver).executeScript(angularReadyScript).toString());

		// Get Angular is Ready
		boolean angularReady = Boolean.valueOf(js.executeScript(angularReadyScript).toString());

		// Wait ANGULAR until it is Ready!
		if (!angularReady) {
			// System.out.println("ANGULAR is NOT Ready!");
			// Wait for Angular to load
			wait.until(angularLoad);
		} else {
			// System.out.println("ANGULAR is Ready!");
		}
	}

	// Wait Until JS Ready
	public static void waitUntilJSReady() {
		// Wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) js)
				.executeScript("return document.readyState").toString().equals("complete");

		// Get JS is Ready
		boolean jsReady = (Boolean) js.executeScript("return document.readyState").toString().equals("complete");

		// Wait Javascript until it is Ready!
		if (!jsReady) {
			// System.out.println("JS in NOT Ready!");
			// Wait for Javascript to load
			wait.until(jsLoad);
		} else {
			// System.out.println("JS is Ready!");
		}
	}

	// Wait Until JQuery and JS Ready
	public static void waitUntilJQueryReady() {
		// First check that JQuery is defined on the page. If it is, then wait AJAX
		Boolean jQueryDefined = (Boolean) js.executeScript("return typeof jQuery != 'undefined'");
		if (jQueryDefined == true) {
			// Pre Wait for stability (Optional)
			// sleep(20);

			// Wait JQuery Load
			waitForJQueryLoad();

			// Wait JS Load
			waitUntilJSReady();

			// Post Wait for stability (Optional)
			// sleep(1);
		} else {
			// System.out.println("jQuery is not defined on this site!");
		}
	}

	// Wait Until Angular and JS Ready
	public static void waitUntilAngularReady() {

		// First check that ANGULAR is defined on the page. If it is, then wait ANGULAR
		Boolean angularUnDefined = (Boolean) js.executeScript("return window.angular === undefined");
		if (!angularUnDefined) {
			Boolean angularInjectorUnDefined = (Boolean) js
					.executeScript("return angular.element(document).injector() === undefined");
			if (!angularInjectorUnDefined) {
				// Pre Wait for stability (Optional)
				// sleep(20);

				// Wait Angular Load
				waitForAngularLoad();

				// Wait JS Load
				waitUntilJSReady();

				// Post Wait for stability (Optional)
				// sleep(20);
			} else {
				System.out.println("Angular injector is not defined on this site!");
			}
		} else {
			// System.out.println("Angular is not defined on this site!");
		}
	}

	// Wait Until JQuery Angular and JS is ready
	public static void waitJQueryAngular() {
		waitUntilJQueryReady();
		waitUntilAngularReady();
	}

	public static void sleep(Integer seconds) {
		long secondsLong = (long) seconds;
		try {
			Thread.sleep(secondsLong);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void pagecallingUtility() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		waitUntilJQueryReady();
		waitUntilAngularReady();
	}

}
