package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;

	public static ExtentReports getReportObject() {
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

		return extent;
	}

}
