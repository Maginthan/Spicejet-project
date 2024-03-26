package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class SignInTestPositive extends ProjectSpecificationMethod{

	@BeforeTest
	public void extentTestSetup() {
		testName = "TC_007_SignInTest_Positive";
		testAuthor = "Maginthan";
		testCategory = "Functional";
		firstName = "Maginthanan";
		lastName = "Ram";
		month = "January";
		year = "1996";
		date = "1";
		contactNumber = "9443081380";
		emailID = "Magi@gmail.com";
		password = "WeAreBest@123";
		confirmPassword = "WeAreBest@123";
	}
	
	@Test
	//This method covers the positive scenario of Sign in functionality with entering all the mandatory and non-mandatory fields in the SignUp form. 
	public void TC_007_SignInTest_Positive() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		HomePage obj = new HomePage(driver);
		obj.clickSignIn().selectTitle().firstName(firstName).lastName(lastName).dateOfBirth(month, year, date)
		.mobileNumber(contactNumber).emailID(emailID).password(password);
		try {
			WebDriverWait confirmPassWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement confirmPassEle = confirmPassWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='c-password']")));
			isElementEnabled(confirmPassEle);
			cleartextField(confirmPassEle);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('c-password').value='"+confirmPassword+"'");
			extentTest.info("The Comfirm Password field is entered with : "+ confirmPassword + " succesfully");
						
			if(!confirmPassEle.getAttribute("value").isEmpty()) {
				// Calling public method to take passes test case screenshot
				filePath = passedTestsScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.pass("The test case "+ testName + " is passed");
			}else {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("The test case "+ testName + " is failed");
			}
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while entering confirm password in the confirm password textfield "+ " - " + e.getMessage());
			e.printStackTrace();
		}
	}

}
