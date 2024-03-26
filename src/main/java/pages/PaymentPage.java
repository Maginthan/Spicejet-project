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

public class PaymentPage extends ProjectSpecificationMethod{
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Method to click the skip comfort button
	public PaymentPage skipComfort() throws IOException {

		// Passing info the extent report for test case
		extentTest.info("Clicking the Skip comfort button in the Add-on screen");
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement skipComfortClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@id='skipfrompopup'])[1]")));
			Actions action = new Actions(driver);
			action.moveToElement(skipComfortClick).click().perform();
			extentTest.info("The Skip comfort button in the Add-on screen was clicked successfully");
		}catch(Exception e){
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while clicking Skip comfort button in the Add-on screen " + " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to enter the Credit/Debit card details in payment screen
	public PaymentPage cardDetails(String CardNumber, String CardHolderName, String ExpMonth, String ExpYear, String Cvv) throws IOException, InterruptedException {
		
		// Passing info the extent report for test case
		extentTest.info("Entering the Credit/Debit card details of passenger");
		
		Thread.sleep(5000);
		
		try {
			//card number iframe
			//iframe[@class='card_number_iframe']
			
			//name of card
			//iframe[@class='name_on_card_iframe']
			
			//expiry month
			//iframe[@class='card_exp_month_iframe']
			
			//expiry year
			//iframe[@class='card_exp_year_iframe']
			
			//cvv
			//iframe[@class='security_code_iframe']
			
			
			//Entering Card Number of the passenger and switching iframe
			WebDriverWait cardNumberFrame = new WebDriverWait(driver, Duration.ofSeconds(10));
			cardNumberFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='card_number_iframe']")));
			WebDriverWait cardNumberWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			cardNumberWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='card_number']"))).sendKeys(CardNumber);
			driver.switchTo().defaultContent();
			
			//Entering the Card Holder Name of the passenger and switching iframe
			WebDriverWait cardHolderFrame = new WebDriverWait(driver, Duration.ofSeconds(10));
			cardHolderFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='name_on_card_iframe']")));
			WebDriverWait cardHolderNameWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			cardHolderNameWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='name_on_card']"))).sendKeys(CardHolderName);
			driver.switchTo().defaultContent();
			
			//Entering the month of the Credit/Debit card
			WebDriverWait monthFrame = new WebDriverWait(driver, Duration.ofSeconds(10));
			monthFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='card_exp_month_iframe']")));
			WebDriverWait cardMonthWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			cardMonthWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='card_exp_month']"))).sendKeys(ExpMonth);
			driver.switchTo().defaultContent();
			
			//Entering the year of the Credit/Debit card
			WebDriverWait yearFrame = new WebDriverWait(driver, Duration.ofSeconds(10));
			yearFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='card_exp_year_iframe']")));
			WebDriverWait cardYearWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			cardYearWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='card_exp_year']"))).sendKeys(ExpYear);
			driver.switchTo().defaultContent();
			
			//Entering the CVV of the Credit/Debit card
			WebDriverWait cvvFrame = new WebDriverWait(driver, Duration.ofSeconds(10));
			cvvFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='security_code_iframe']")));
			WebDriverWait cvvWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			cvvWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='security_code']"))).sendKeys(Cvv);
			driver.switchTo().defaultContent();
			
			extentTest.info("Credit/Debit card details of passenger were entered successfully");
			
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while entering Credit/Debit card details of passenger " + " - " + e.getMessage());
			e.printStackTrace();
		}
		
		return this;
	}
	
	//Method to click proceed to pay in the payment screen
	public PaymentPage proceedToPay() throws IOException {
		
		// Passing info the extent report for test case
		extentTest.info("Clicking the Proceed to Pay button in Payment screen");
		
		//div[@class='css-76zvg2 r-jwli3a r-poiln3 r-ubezar r-1kfrs79']
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement proceedClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-poiln3 r-ubezar r-1kfrs79']")));
			Actions action = new Actions(driver);
			action.moveToElement(proceedClick).click().perform();
			extentTest.info("The Proceed to Pay button in the Payment screen was clicked successfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while clicking the Proceed to Pay button in the Payment screen  " + " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
}


























