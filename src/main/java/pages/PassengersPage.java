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

public class PassengersPage extends ProjectSpecificationMethod{
	public PassengersPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Method to fill the contact details of passenger
	public PassengersPage contactDetails(String FirstName, String LastName, String ContactNumber, String EmailID, String City) throws IOException {
		
		// Passing info the extent report for test case
		extentTest.info("Entering the passenger contact details");
		
		try {
			//Entering firstName of the passenger
			WebDriverWait firstNameWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement firstNameEle = firstNameWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-poiln3 r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy'])[1]")));
			firstNameEle.sendKeys(FirstName);
			
			//Entering the lastName of the passenger
			WebDriverWait lastNameWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement lastNameEle = lastNameWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"primary-contact-details\"]/div[3]/div[3]/div/div/div[2]/input")));
			lastNameEle.sendKeys(LastName);
			
			//Entering the contact number of the passenger
			WebDriverWait contactNoWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement contactNoEle = contactNoWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='css-1cwyjr8 r-1yadl64 r-homxoj r-poiln3 r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy'])[1]")));
			contactNoEle.sendKeys(ContactNumber);

			//Entering the email address of the passenger
			WebDriverWait emailIDWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement emailIDEle = emailIDWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-poiln3 r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy'])[3]")));
			emailIDEle.sendKeys(EmailID);
			
			//Entering the city of the passenger
			WebDriverWait cityWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement cityEle = cityWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"primary-contact-details\"]/div[4]/div[3]/div/div/div[2]/input")));
			cityEle.sendKeys(City);			
			
			extentTest.info("Passenger contact details were entered successfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while entering the passenger contact details " + " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to click the primary passenger checkbox
	public PassengersPage primaryCheck() throws IOException {
		
		// Passing info the extent report for test case
		extentTest.info("Clicking the Primary passenger checkbox");
		
		try {
			WebDriverWait checkBoxWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement checkBoxEle = checkBoxWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='css-1dbjc4n r-zso239'])[5]")));
			checkBoxEle.click();
			extentTest.info("Clicked Primary passenger checkbox successfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while clicking the Primary passenger checkbox " + " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to click the continue button in passenger screen
	public AddOnsPage passengerContinue() throws IOException {
		
		// Passing info the extent report for test case
		extentTest.info("Clicking the continue button in the passenger screen");
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement continueClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-poiln3 r-adyw6z r-1kfrs79']")));
			Actions action = new Actions(driver);
			action.moveToElement(continueClick).click().perform();
			extentTest.info("The Continue button in the passenger screen was clicked successfully");	
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while clicking the continue button in the passenger screen  " + " - " + e.getMessage());
			e.printStackTrace();
		}
		return new AddOnsPage(driver);
	}
	
	
	
}
