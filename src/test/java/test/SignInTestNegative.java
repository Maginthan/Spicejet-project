package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class SignInTestNegative extends ProjectSpecificationMethod{

	@BeforeTest
	public void extentTestSetup() {
		testName = "TC_008_SignInTest_Negative";
		testAuthor = "Maginthan";
		testCategory = "Functional";
	}
	
	
	@Test
	//This method covers the negative scenario of Sign in functionality with leaving all fields as empty and clicking submit button. 
	public void TC_008_SignInTest_Negative() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		HomePage obj = new HomePage(driver);
		obj.clickSignIn().submit();
		
		extentTest.info("Validating the Mandatory fields error message is shown");
		try{
			//(//div[@class='font-13 mt-10 inlineErrors'])[1]
			WebDriverWait mandatoryErrWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement mandatoryErrEle = mandatoryErrWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='font-13 mt-10 inlineErrors'])[1]")));
			String expectedError = "Please fill all mandatory fields marked with an '*' to proceed";
			
			if(mandatoryErrEle.getText().equals(expectedError)) {
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
			extentTest.fail("Exception occured while getting the Mandatory fields error message "+ " - " + e.getMessage());
			e.printStackTrace();
		}
	}

}
