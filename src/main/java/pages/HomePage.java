package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class HomePage extends ProjectSpecificationMethod{
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Method to click the input text field for destination location
	public HomePage enterState(String state) throws IOException {
		
		// Passing info the extent report for test case
		extentTest.info("Entering the state name in the state input text field");
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement stateSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")));
			stateSelect.sendKeys(state);
			extentTest.info("The state name " + " - " + state + " - " +" entered successfully in the state text field");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while entering the state name  " + " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	// Method to select month and data of Departure date
	public HomePage departureDate(String givenMonth, String givenDate) throws IOException {

		// Passing info the extent report for test case
		extentTest.info("Selecting the Month and Date from the departure calender");
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> departMonths = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']")));
			// This is for selecting the Depart date from months
			// Instance to increment and count of the date occurrence of every month
			int i = 1;

			for (WebElement departMonth : departMonths) {

				String monthStr = departMonth.getText();
				//System.out.println("Depart Month is :"+monthStr);
				if (givenMonth.equals(monthStr)) {
					break;
				} else {
					// Clicking next arrow click
					driver.findElement(By.xpath(
							"//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[1]"))
							.click();
					i++;
				}
			}
			// Clicking the Depart date of the given month
			driver.findElement(By.xpath("(//div[text()='" + givenDate + "'])[" + i + "]")).click();
			extentTest.info("Selected the Month and Date from the departure calender successfully");
		
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while selecting the Month and Date from the departure calender "+ " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;

	}
	
	//Method to click search flight button
	public FlightSelectionPage searchFlight() throws IOException{
		// Passing info the extent report for test case
		extentTest.info("Clicking the Search Flight button");
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement searchFlight =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-1i10wst r-1kfrs79']")));
			Actions action = new Actions(driver);
			action.moveToElement(searchFlight).click().perform();
			extentTest.info("The Search Flight button is clicked successfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while clicking the Search Flight button "+ " - " + e.getMessage());
			e.printStackTrace();
		}
		return new FlightSelectionPage(driver);
	}
	
	//Method to select the email option to Log in 
	public HomePage emailCheck() throws IOException {		
		try {
			WebDriverWait emailWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement emailSelect = emailWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[3]/div/div/div[2]/div[2]/div/div[2]/div[2]/div")));
			Actions action = new Actions(driver);
			action.moveToElement(emailSelect).click().perform();
//			click(emailSelect);
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while clicking the Email option  " + " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to click the Round trip checkbox
	public HomePage roundTripCheck() throws IOException {
		
		// Passing info the extent report for test case
		extentTest.info("Clicking the Round trip checkbox");
		
		try {
			WebDriverWait checkBoxWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement checkBoxEle = checkBoxWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='css-1dbjc4n r-zso239'])[2]")));
			
			click(checkBoxEle);
			extentTest.info("Clicked the Round trip checkbox successfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while clicking the Round trip checkbox " + " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to click the Departure date and return date
	public HomePage departAndReturn(String DepartMonth, String DepartDate, String ReturnMonth, String ReturnDate) throws IOException {
		
		// Passing info the extent report for test case
		extentTest.info("Selecting the Month and Date from the departure calender");
		// This is for selecting the Depart date from month
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> departMonths = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']")));
			// This is for selecting the Depart date from months
			// Instance to increment and count of the date occurrence of every month
			int i = 1;

			for (WebElement departMonth : departMonths) {

				String monthStr = departMonth.getText();
				//System.out.println("Depart Month is :"+monthStr);
				if (DepartMonth.equals(monthStr)) {
					break;
				} else {
					// Clicking next arrow click
					driver.findElement(By.xpath(
							"//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[1]"))
							.click();
					i++;
				}
			}
			// Clicking the Depart date of the given month
			driver.findElement(By.xpath("(//div[text()='" + DepartDate + "'])[" + i + "]")).click();
			extentTest.info("Selected the Month and Date from the departure calender successfully");
		} catch (Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while selecting the Month and Date from the departure calender "+ " - " + e.getMessage());
			e.printStackTrace();
		}

		// Passing info the extent report for test case
		extentTest.info("Selecting the Month and Date from the return calender");
		// This is for selecting the Return date from month
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> returnMonths = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']")));

			// Instance to increment and count of the date occurrence of every month
			int j = 1;

			for (WebElement returnMonth : returnMonths) {

				String monthStr = returnMonth.getText();
				//System.out.println("Return month is :"+monthStr);
				if (ReturnMonth.equals(monthStr)) {
					break;
				} else {
					// Clicking next arrow click
					driver.findElement(By.xpath(
							"//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[1]"))
							.click();
					j++;
				}
			}
			// Clicking the Depart date of the given month
			driver.findElement(By.xpath("(//div[text()='" + ReturnDate + "'])[" + j + "]")).click();
			extentTest.info("Selected the Month and Date from the return calender successfully");
		} catch (Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while selecting the Month and Date from the return calender "+ " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to click Login button in Home screen
	public HomePage clickLogin() throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement loginButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='css-76zvg2 r-jwli3a r-ubezar'])[1]")));
			Actions action = new Actions(driver);
			action.moveToElement(loginButton).click().perform();
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while clicking the Login button in the Home screen "+ " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to enter Email ID in the Home screen
	public HomePage emailID(String EmailID) throws IOException {		
		try {
			WebElement emailEle = driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-13awgt0 r-ubezar r-tmtnm0 r-oxtfae r-10paoce r-ymttw5 r-9qu9m4'])[1]"));
			isElementEnabled(emailEle);
			cleartextField(emailEle);
			findElementAndSendKeysByXpath(emailEle,EmailID);
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while entering emailID in email textfield "+ " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to enter password in the Home screen
	public HomePage password(String Password) throws IOException {		
		try {
			WebElement passwordEle = driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-13awgt0 r-ubezar r-tmtnm0 r-oxtfae r-10paoce r-ymttw5 r-9qu9m4'])[2]"));
			isElementEnabled(passwordEle);
			cleartextField(passwordEle);
			findElementAndSendKeysByXpath(passwordEle,Password);
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while entering password in password textfield "+ " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//div[@class='css-1dbjc4n r-1awozwy r-184aecr r-z2wwpe r-1loqt21 r-18u37iz r-tmtnm0 r-1777fci r-1x0uki6 r-1w50u8q r-ah5dr5 r-1otgn73']
	//Method to click Login button in the Home screen with emailID and password
	public HomePage login() throws IOException {
		try {
			WebElement loginEle = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-184aecr r-z2wwpe r-1loqt21 r-18u37iz r-tmtnm0 r-1777fci r-1x0uki6 r-1w50u8q r-ah5dr5 r-1otgn73']"));
			isElementEnabled(loginEle);
			click(loginEle);
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while clicking the Login button after entering"+ " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to click SignIn button in Home screen
	public SignInPage clickSignIn() throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement loginButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='css-76zvg2 r-jwli3a r-ubezar'])[2]")));
			Actions action = new Actions(driver);
			action.moveToElement(loginButton).click().perform();
			
			//Window handling to move to the new tab for SignIn validation
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newTab.get(1));
			//System.out.println("Page title of new tab: " + driver.getTitle());
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while clicking the SignIn button in the Home screen "+ " - " + e.getMessage());
			e.printStackTrace();
		}
		return new SignInPage(driver);
	}
}
