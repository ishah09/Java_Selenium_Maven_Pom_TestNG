package SuiteStructure;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

/*
 * This is common base class for configuration purpose. 
 * All common methods can be struct here, and further it can be call in Tests. *  
 */

public class BaseClassConfiguration {
	
		public void browserLaunch() {
		// Driver Calling with Respective Browser

		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		// driver = new EdgeDriver();

		/*
		 * if (browser.equalsIgnoreCase("firefox")) { driver = new FirefoxDriver(); } if (browser.equalsIgnoreCase("chrome")) {
		 * driver = new ChromeDriver(); } if (browser.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
		 */

		browserCap = ((RemoteWebDriver) driver).getCapabilities();
		browserName = browserCap.getBrowserName();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	public void extentReportConfiguration() {
		className = this.getClass().getSimpleName();
		reportHeadline = "Report of " + className;
		reportName = reportLocation + browserName + " - " + className + ".html";
		// To generate Report and define location
		htmlReport = new ExtentHtmlReporter(reportName);
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReport);
		htmlReport.config().setReportName(reportHeadline);

		parentTestSection = extentReport.createTest("Global: Utility Call");
		parentTestSection.info("Script utility called.");
		parentTestSection.info("Browser:" + browserName);

		// Customize Report property
			htmlReport.config().setDocumentTitle("Automation Report Title");
		htmlReport.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReport.config().setTheme(Theme.DARK);
	}

	public void ATUTestRecorder() {
		recorderName = browserName + " - " + className + " ";

		// To recort Script
		date = new Date();
		/*
		 * try { DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); recordScript = new
		 * ATUTestRecorder(videoRecordLocation, recorderName + dateFormat.format(date), false); recordScript.start(); } catch
		 * (ATUTestRecorderException e) { e.printStackTrace(); }
		 */
	}

	public void objectInitialization() {
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 20);
		js = (JavascriptExecutor) driver;
		page = new pageLoadUtility();
		val = new validationUtility();
		login = new loginDefinition();
		logout = new logoutUtility();
		SS = new takeScreenShot();
		excelReader = new excelUtility();

		objD = new verification_Device();
	}

	public void configDeclaration() {
		browserLaunch();
		extentReportConfiguration();
		ATUTestRecorder();
		objectInitialization();
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert().accept();
			return true;
		} catch (Exception Ex) {
			return false;
		}
	}


	// call testStatus after every test method
	public void testStatus(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {

			testResult = "Test Fail :" + result.getName() + result.getAttributeNames();
			System.out.println(testResult);

			testResult = "Details of Fail Testcase:" + result.getThrowable();

			SS.calltakeScreenShot("Script Failure");

			extentReport.flush();

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			testResult = "Test Pass :" + result.getName();
			System.out.println(testResult);

		} else if (result.getStatus() == ITestResult.SKIP) {

			testResult = "Test Skip :" + result.getName();
			System.out.println(testResult);

		} else {

			testResult = "Test Undefined :" + result.getName() + "<br>Status : " + result.getStatus();
			System.out.println(testResult);

			testResult = "Details of undefined Testcase:" + result.getThrowable();
			System.out.println("Test Undefined :" + result.getName() + "<br>Status : " + result.getStatus());
			System.out.println(testResult);
		}
	}

	// To Stop recording script
	public void termination() {
		testResult = "Test Termination";
		/*
		 * try { recordScript.stop(); } catch (Exception e) { e.printStackTrace(); }
		 */
		extentReport.flush();
		driver.quit();
	}
}
