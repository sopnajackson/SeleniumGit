package seleniumFrameworkDesign.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public static ExtentReports config() {
		String loc=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(loc);
		ExtentReports reports=new ExtentReports();
		reports.attachReporter(reporter);
		return reports;
	}

}
