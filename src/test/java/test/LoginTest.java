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

public class LoginTest extends ProjectSpecificationMethod {

	@BeforeTest
	public void extentTestSetup() {
		testName = "TC_005_LoginTest";
		testAuthor = "Maginthan";
		testCategory = "Functional";
		excelFile = "SpiceJetTestData";
		sheetName = "LoginTest";
	}

	@Test(dataProvider = "ReadfromExcel")
	public void TC_005_LoginTest(String email, String password, String dataMatch, String scenario) throws IOException {
		// TODO Auto-generated method stub

		HomePage obj = new HomePage(driver);
		obj.clickLogin().emailCheck().emailID(email).password(password).login();

		// Validating test cases for login functionality
		if (dataMatch.equals("bothCorrect") && scenario.equals("Positive_Con_1")) {
			// Passing info the extent report for test case
			extentTest.info("Verifying the LogIn condition with " + "- " + scenario);

			try {
				// Explicit wait for the user name to appear in Home screen
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//*[@id=\"main-container\"]/div/div[1]/div[2]/div[1]/div/div[3]/div[1]/div[2]/div[1]")));

				String actualName = userName.getText();
				//System.out.println("The actual name is :" + actualName);

				// Verifying the userName is displayed
				String expectedName = "Hi Mahi";
				if (expectedName.equals(actualName)) {
					// Calling public method to take passes test case screenshot
					filePath = passedTestsScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.pass("The user login for " + scenario + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user login for " + scenario + " failed");
				}
			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario " + scenario + " - " + e.getMessage());
				e.printStackTrace();
			}

		} else if (dataMatch.equals("wrongPassword") && scenario.equals("Positive_Con_2")) {

			// Passing info the extent report for test case
			extentTest.info("Verifying the LogIn condition with " + "- " + scenario);

			try {
				// Explicit wait for the error message to appear
				WebDriverWait titleWait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement errorTitle = titleWait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-1kfrs79 r-15zivkp']")));
				String actualTitle = errorTitle.getText();

				WebDriverWait messageWait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement errorMessage = messageWait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='css-76zvg2 css-cens5h r-7p11b r-oulfea r-xaggoz']")));
				String actualMessage = errorMessage.getText();

				/// Verifying the correct error message is displayed
				String expectedMessage = "Please try again or signup as a new user";
				String expectedTitle = "Invalid Username/Password";
				if (expectedMessage.equals(actualMessage) && expectedTitle.equals(actualTitle)) {
					extentTest.pass("The user login for " + scenario + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user login for " + scenario + " failed");
				}
			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario " + scenario + " - " + e.getMessage());
				e.printStackTrace();
			}
		} else if (dataMatch.equals("wrongUsername") && scenario.equals("Positive_Con_3")) {
			extentTest.info("Verifying the LogIn condition with " + "- " + scenario);

			try {
				// Explicit wait for the error message to appear
				WebDriverWait titleWait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement errorTitle = titleWait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-1kfrs79 r-15zivkp']")));
				String actualTitle = errorTitle.getText();

				WebDriverWait messageWait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement errorMessage = messageWait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='css-76zvg2 css-cens5h r-7p11b r-oulfea r-xaggoz']")));
				String actualMessage = errorMessage.getText();

				/// Verifying the correct error message is displayed
				String expectedMessage = "Please try again or signup as a new user";
				String expectedTitle = "Invalid Username/Password";
				if (expectedMessage.equals(actualMessage) && expectedTitle.equals(actualTitle)) {
					extentTest.pass("The user login for " + scenario + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user login for " + scenario + " failed");
				}
			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario " + scenario + " - " + e.getMessage());
				e.printStackTrace();
			}
		}

		else if (dataMatch.equals("bothWrong") && scenario.equals("Positive_Con_4")) {

			extentTest.info("Verifying the LogIn condition with " + "- " + scenario);

			try {
				// Explicit wait for the error message to appear
				WebDriverWait titleWait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement errorTitle = titleWait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-1kfrs79 r-15zivkp']")));
				String actualTitle = errorTitle.getText();

				WebDriverWait messageWait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement errorMessage = messageWait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='css-76zvg2 css-cens5h r-7p11b r-oulfea r-xaggoz']")));
				String actualMessage = errorMessage.getText();

				/// Verifying the correct error message is displayed
				String expectedMessage = "Please try again or signup as a new user";
				String expectedTitle = "Invalid Username/Password";
				if (expectedMessage.equals(actualMessage) && expectedTitle.equals(actualTitle)) {
					extentTest.pass("The user login for " + scenario + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user login for " + scenario + " failed");
				}
			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario " + scenario + " - " + e.getMessage());
				e.printStackTrace();
			}
		}

		else if (dataMatch.equals("emptyMailID") && scenario.equals("Negative_Con_1")) {

			extentTest.info("Verifying the LogIn condition with " + "- " + scenario);

			try {
				// Explicit wait for the error message to appear
				WebDriverWait errorWait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement errorMessage = errorWait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='css-76zvg2 r-1ttbpl1 r-2t9rge r-1enofrn r-1bymd8e']")));
				String actualMessage = errorMessage.getText();

				/// Verifying the correct error message is displayed
				String expectedMessage = "Please enter a valid email address";
				if (expectedMessage.equals(actualMessage)) {
					extentTest.pass("The user login for " + scenario + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user login for " + scenario + " failed");
				}
			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario " + scenario + " - " + e.getMessage());
				e.printStackTrace();
			}

		}

		else if (dataMatch.equals("emptyPassword") && scenario.equals("Negative_Con_2")) {

			extentTest.info("Verifying the LogIn condition with " + "- " + scenario);

			try {
				// Explicit wait for the error message to appear
				WebDriverWait errorWait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement errorMessage = errorWait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='css-76zvg2 r-1ttbpl1 r-2t9rge r-1enofrn r-1bymd8e']")));
				String actualMessage = errorMessage.getText();

				/// Verifying the correct error message is displayed
				String expectedMessage = "Please enter a valid password";
				if (expectedMessage.equals(actualMessage)) {
					extentTest.pass("The user login for " + scenario + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user login for " + scenario + " failed");
				}
			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario " + scenario + " - " + e.getMessage());
				e.printStackTrace();
			}
		} else {

			extentTest.info("Verifying the LogIn condition with " + "- " + scenario);

			try {
				// Explicit wait for the error message to appear
				// css-76zvg2 r-1ttbpl1 r-2t9rge r-1enofrn r-1bymd8e
				// css-76zvg2 r-1ttbpl1 r-2t9rge r-1enofrn r-1bymd8e
				WebDriverWait errorWait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement errorMessage = errorWait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='css-76zvg2 r-1ttbpl1 r-2t9rge r-1enofrn r-1bymd8e']")));
				String actualMessage = errorMessage.getText();

				// Verifying the correct error message is displayed
				String expectedMessage = "Please enter a valid password";
				if (expectedMessage.equals(actualMessage)) {
					extentTest.pass("The user login for " + scenario + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user login for " + scenario + " failed");
				}
			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario " + scenario + " - " + e.getMessage());
				e.printStackTrace();
			}
		}

	}

}
