package App.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class getReport {

	public static ExtentReports getExtentReport() {
		String file = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(file);
		report.config().setReportName("Test Automation");
		report.config().setTheme(Theme.STANDARD);

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Sagar Raipurkar");
		return extent;

	}

}
