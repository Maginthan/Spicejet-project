package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class OneWayTest extends ProjectSpecificationMethod{

	@BeforeTest
	public void extentTestSetup() {
		testName = "TC_003_OneWayTest";
		testAuthor = "Maginthan";
		testCategory = "Functional";
		state = "Chennai";
		month = "April 2024";
		date = "30";
		firstName = "Maginthan";
		lastName = "Raman";
		contactNumber = "7890567980";
		emailID = "Maginthanofficial@gmail.com";
		city = "Chennai";
		cardNumber = "4111111111111113";
		cardHolderName = "Mario";
		expMonth = "12";
		expYear = "26";
		cvv = "121";
	}
	
	@Test
	public void TC_003_OneWayTest() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		HomePage obj = new HomePage(driver);
		obj.enterState(state).departureDate(month, date).searchFlight().earlyDepartFlight().flightContinue().contactDetails(firstName, lastName, contactNumber, emailID, city).primaryCheck()
		.passengerContinue().checkAddOnPopUp().AddOnContinue().skipComfort()
		.cardDetails(cardNumber, cardHolderName, expMonth, expYear, cvv)
		.proceedToPay();
		
		//Validating whether the invalid card number error is present 
		try {
			String ExpErrTitle = "Invalid Card Details";
			String ExpErrMsg =  "One or more card details are wrong";
			
			WebDriverWait errorHeadingWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement errorHeading = errorHeadingWait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='css-76zvg2 r-jwli3a r-poiln3 r-ubezar r-1kfrs79 r-15zivkp']")));
			errorHeading.getText();
			
			WebDriverWait errorMessageWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement errorMessage = errorMessageWait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("// div[@class='css-76zvg2 css-cens5h r-7p11b r-poiln3 r-oulfea r-xaggoz']")));
			errorMessage.getText();
			
			if(ExpErrTitle.equals(errorHeading.getText()) && ExpErrMsg.equals(errorMessage.getText())) {
				// Calling public method to take passes test case screenshot
				filePath = passedTestsScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.pass("The test case "+ testName + " is passed and error message is displaying correctly");
			}else {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.pass("The test case "+ testName + " is failed and error message is displaying incorrectly");
			}

		} catch (Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while displaying the card details error in the Payment screen  " + " - " + e.getMessage());
			e.printStackTrace();
		}
	}

}
