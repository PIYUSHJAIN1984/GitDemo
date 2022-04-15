package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener {

	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test;

	// ThreadLocal class helps to keep all tests threadSafe. We want all test
	// objects should be threadsafe.
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);

		// Create test in reporting file
		// When we createTest ExtentReport creates a object of ExtentTest class.
		// This object send all happeninings back to ExtentReport class.
		test = extent.createTest(result.getMethod().getMethodName());

		// extentTest object will now store all test objects . So, threadlocal will pass
		// correct test object when reporting failure of pass.
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);

		// This method getThrowable will report all failures in report
		extentTest.get().fail(result.getThrowable());

		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();

		// Step to get access of fields of class where test got failed
		// cast it to WebDriver
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
		}

		try {
			//addScreenCaptureFromPath 2 arguments are passed screenshot captured path and methodName
			//getScreenshot(testMethodName, driver) returns screenshot and path of image
			//result.getMethod().getMethodName() returns method name
			//addScreenCaptureFromPath method add screenshot details in extent report when reporting failure
			extentTest.get().addScreenCaptureFromPath(getScreenshot(testMethodName, driver),result.getMethod().getMethodName());	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		extent.flush();
	}

}
