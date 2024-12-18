package App.Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import App.Reports.getReport;

public class Listeners extends common_components implements ITestListener {
	
	ExtentReports extent = getReport.getExtentReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();	@Override
	public void onTestStart(ITestResult result) {
		test =  extent.createTest(result.getMethod().getMethodName());
		thread.set(test);
	}

	// This method is called when a test is passed
	@Override
	public void onTestSuccess(ITestResult result) {
		thread.get().log(Status.PASS, "Test Passed");
	}

	// This method is called when a test fails
	@Override
	public void onTestFailure(ITestResult result) {
		
		thread.get().fail(result.getThrowable());
		try {
			driver = (WebDriver)  result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filepath = null;
		try {
			filepath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}

	// This method is called when a test is skipped
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped: " + result.getName());
	}

	// This method is called when a test is set to be failed (due to invocation
	// count failure)
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test failed but within success percentage: " + result.getName());
	}

	// This method is called after all tests have been executed, regardless of
	// success or failure
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test failed due to timeout: " + result.getName());
	}

	// This method is called before any test method in the class is invoked
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test started: " + context.getName());
	}

	// This method is called after all tests in the class have been run
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
