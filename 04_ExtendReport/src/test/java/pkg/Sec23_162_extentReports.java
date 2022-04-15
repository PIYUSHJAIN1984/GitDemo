package pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Sec23_162_extentReports {
	ExtentReports extent;

	@BeforeTest
	public void config() {
		// Get project path
		String path = System.getProperty("user.dir") + "\\reports\\index.html";

		// ExtentReports and ExtentSparkReporter class.ExtentSparkReporter is used to
		// set configurations in report
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Piyush"); // add testername
	}

	@Test
	public void initialDemo() {

		// Create test in reporting file
		// When we createTest ExtentReport creates a object of ExtentTest class.
		// This object send all happeninings back to ExtentReport class.
		ExtentTest test = extent.createTest("Initial Demo");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/#/index");
		System.out.println(driver.getTitle());
		driver.close();

		// Only required to intentionally report failure in test
		// test.fail("Results do not match");

		// To be done after end of last test. Not after everyTest
		extent.flush();

	}

}
