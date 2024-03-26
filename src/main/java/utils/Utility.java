package utils;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.hc.core5.http.HttpConnection;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

public class Utility {
	// Public driver instance
	public WebDriver driver;

	// Public instance of Excel file
	public String excelFile;

	// Public instance of Excel sheet name
	public String sheetName;
	
	// Public instances of extent test required for a test case
	public String testName;
	public String testAuthor;
	public String testCategory;
	
	//Public instance used for capturing the failed test case screenshot file path
	public String filePath;
	
	//Public instance used for entering the state for one way and round trips
	public String state;
	public String month;
	public String date;
	public String returnMonth;
	public String returnDate;
	public String year;
	
	//Public instance for entering the passenger details in the contact info
	public String firstName;
	public String lastName;
	public String contactNumber;
	public String emailID;
	public String city;
	
	//Public instance for entering the passenger Credit/Debit card info
	public String cardNumber;
	public String cardHolderName;
	public String expMonth;
	public String expYear;
	public String cvv;
	
	//Public instance for entering password in Sign Up form
	public String password;
	public String confirmPassword;
	
	
	// Public method to launch browser and load url
	public void launchBrowser(String browser, String url) {
		
		//Setting headless browser on Chrome driver 
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("headless");
		
		//Setting headless browser on Firefox driver 
		FirefoxOptions firefoxOptions = new FirefoxOptions ();
		firefoxOptions.addArguments("--headless");
		
		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver(firefoxOptions);
		} else if (browser.equals("Safari")) {
			driver = new SafariDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	// Public method to close browser
	public void closeBrowser() {
		driver.close();
	}

	// Public method to perform click operation
	public void click(WebElement ele) {
		ele.click();
	}

	// Public method to find an element by ID and enter text
	public void findElementAndSendKeysByID(String attributevalue, String value) {
		driver.findElement(By.id(attributevalue)).sendKeys(value);
	}
	
	// Public method to find an element by xpath and enter text
	public void findElementAndSendKeysByXpath(WebElement attributevalue, String value) {
		attributevalue.sendKeys(value);
	}
	
	// Public method to check whether the element is visible
	public void isElementDisplayed(WebElement ele) {
		boolean eleDisplayed= ele.isDisplayed();
	}
	
	// Public method to check whether the element is enabled
	public void isElementEnabled(WebElement ele) {
		boolean eleEnabled = ele.isEnabled();
	}
	
	// Public method to check whether the element is enabled
	public void cleartextField(WebElement ele) {
		ele.clear(); 
	}
	
	// public method to explicit wait for visibility of element
	public WebElement visibiltiyofElement(WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	// Public method to read data from Excel file
	public String[][] readExcel(String excelfile, String sheetname) throws IOException {

		XSSFWorkbook book = new XSSFWorkbook("/Users/maginthangr/eclipse-workspace/SpicejetProject/Data/" + excelfile + ".xlsx");
		XSSFSheet sheet = book.getSheet(sheetname);

		// Getting the row count and column count
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();

		// Two dimensional array to store row and column values of cells
		String[][] data = new String[rowCount][columnCount];

		// Get into row
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);

			// Get into cell
			for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i - 1][j] = cell.getStringCellValue();
			}
		}
		// Closing the book
		book.close();
		return data;
	}

	// Public method to generate random user name for Sign up functionality
//	public String randomNameGenerator() {
//
//		// Creating string of all characters
//		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//
//		// Creating random string builder
//		StringBuilder sb = new StringBuilder();
//
//		// creating an object of random class
//		Random random = new Random();
//
//		// Specifying the length of random string
//		int length = 7;
//
//		for (int i = 0; i < length; i++) {
//			// Generating random index number
//			int index = random.nextInt(alphabet.length());
//
//			// Getting the character based on the specified index
//			char randomChar = alphabet.charAt(index);
//
//			// Appending the character to string builder
//			sb.append(randomChar);
//
//		}
//		String name = sb.toString();
//		System.out.println("The random string is " + name);
//		return name;
//	}
	
	//Public method to return if an alert is present on the web page
	public boolean isAlertPresent() {
	    try{
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	       wait.until(ExpectedConditions.alertIsPresent());
	       return true;
	    }
	    catch (NoAlertPresentException noAlert) {
	      return false;
	    }
	    catch (TimeoutException timeOutEx){
	      return false;
	    }
	}
		
	//Public method to click the Add-on pop-up
	public void closeAddOnPopUp() {
		try {
			WebElement popUp = driver.findElement(By.xpath("//div[@class='at_addon_close']"));
			popUp.click();
			System.out.println("Close Add-on pop up is closed");
		}catch(Exception e) {
			System.out.println("Exception occured while closing Add-on pop up");
			e.printStackTrace();
		}
	}
	

	// Public method to take screenshot with time stamp
		public String takeScreenshot(String screenshotName) throws IOException {
			Date d = new Date();
			String date = d.toString();

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path = "/Users/maginthangr/eclipse-workspace/SpicejetProject/FailedTestCaseScreenshots/" + screenshotName + "-" + date
					+ ".png";
			File dest = new File(path);
			FileUtils.copyFile(src, dest);
			return path;
		}
		
	//	Public method to take screenshot of passed test cases with time stamp
		public String passedTestsScreenshot(String screenshotName) throws IOException {
			Date d = new Date();
			String date = d.toString();

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path = "/Users/maginthangr/eclipse-workspace/SpicejetProject/PassedTestCaseScreenshots/" + screenshotName + "-" + date
					+ ".png";
			File dest = new File(path);
			FileUtils.copyFile(src, dest);
			return path;
		}

	//Public method to handle spinner
		public boolean isSpinnerDisplayed(WebElement element) {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		        wait.until(ExpectedConditions.visibilityOf(element));
		        return element.isDisplayed();
		    } catch (org.openqa.selenium.NoSuchElementException
		            | org.openqa.selenium.StaleElementReferenceException
		            | org.openqa.selenium.TimeoutException e) {
		        return false;
		    }
		}
		
	//Public method to wait for spinner to be gone
		public void waitForElementToBeGone(WebElement element, Duration timeout) {
		    if (isSpinnerDisplayed(element)) {
		        new WebDriverWait(driver, timeout).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
		    }else {
		    	System.out.println("Spinner not displayed");
		    }
		}
}

