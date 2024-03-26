package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class FlightSelectionPage extends ProjectSpecificationMethod{
	public FlightSelectionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Method to click early flight on the selected date
	public FlightSelectionPage earlyDepartFlight() throws IOException {
		
		// Passing info the extent report for test case
		extentTest.info("Selecting the earliest Depart flight in the SpiceSaver for the selected");
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement earlyFlight = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"list-results-section-0\"]/div[5]/div[1]/div/div[2]/div[1]/div/div/div/div[2]")));
			Actions action = new Actions(driver);
			action.moveToElement(earlyFlight).click().perform();
			extentTest.info("Selected the earliest Depart flight in the SpiceSaver successfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while selecting the earliest Depart flight in the SpiceSaver  " + " - " + e.getMessage());
			e.printStackTrace();
		}
	
		return this;
	}
	
	//Method to click continue button after selecting flight
	public PassengersPage flightContinue() throws IOException {
		
		// Passing info the extent report for test case
		extentTest.info("Clicking the continue button in the flight screen");
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement continueClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-1i10wst r-1kfrs79']")));
			Actions action = new Actions(driver);
			action.moveToElement(continueClick).click().perform();
			extentTest.info("The Continue button in the flight screen was clicked successfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while clicking the continue button in the flight screen  " + " - " + e.getMessage());
			e.printStackTrace();
		}
	return new PassengersPage(driver);	
	}
	
	//Method to click early return flight on the selected date
	//*[@id="list-results-section-1"]/div[5]/div[1]/div/div[2]/div[1]/div/div/div/div[2]
	public FlightSelectionPage earlyReturnFlight() throws IOException {
		
		// Passing info the extent report for test case
		extentTest.info("Selecting the earliest Return flight in the SpiceSaver for the selected");
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement earlyFlight = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"list-results-section-1\"]/div[5]/div[1]/div/div[2]/div[1]/div/div/div/div[2]")));
			Actions action = new Actions(driver);
			action.moveToElement(earlyFlight).click().perform();
			extentTest.info("Selected the earliest Return flight in the SpiceSaver successfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while selecting the earliest Return flight in the SpiceSaver  " + " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
}
