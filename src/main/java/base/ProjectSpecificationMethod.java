package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Utility;

public class ProjectSpecificationMethod extends Utility{

	//Instance variable of extent reports and extent test
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static ExtentSparkReporter sparkReporter;
	
	//This is where extend reports are initialised
	@BeforeSuite
	public void reportInitialisation() {
		extentReports = new ExtentReports();
		sparkReporter = new ExtentSparkReporter("/Users/maginthangr/eclipse-workspace/SpicejetProject/Reports/ExtentReport.html");
		extentReports.attachReporter(sparkReporter);
		sparkReporter.config().setReportName("SpiceJet test report");
	}
	
	@AfterSuite
	public void generateExtentReports() {
		extentReports.flush();
	}

	
	// Public method to launch browser and load url
	// Parameter tag to pass the browser and url values from testng xml
	@Parameters({ "browser", "url" })
	@BeforeMethod
	public void browserLaunch(String browser, String url) {
		launchBrowser(browser, url);
	}
	
	// Public method to close browser
	@AfterMethod
	public void browserClose() {
		closeBrowser();
	}
	
	//public method to create Extend test
	@BeforeClass
	public void createExtentTest() {
		extentTest = extentReports.createTest(testName);
		extentTest.assignAuthor(testAuthor);
		extentTest.assignCategory(testCategory);
	}

	// Public method to read data from excel sheet
	@DataProvider(name = "ReadfromExcel")
	public String[][] excelRead() throws IOException {
		String[][] data = readExcel(excelFile, sheetName);
		return data;
	}
	
}
