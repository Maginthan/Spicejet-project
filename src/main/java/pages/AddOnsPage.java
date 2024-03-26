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

public class AddOnsPage extends ProjectSpecificationMethod{
	public AddOnsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Method to wait and close the Add-on pop-up
	public AddOnsPage checkAddOnPopUp() {
		try {
			WebElement popUp = driver.findElement(By.xpath("//div[@class='at_addon_close']"));
			
			if(popUp.isDisplayed()) {
				System.out.println("Add-on pop up is present");
				popUp.click();
			}

		}catch(Exception e) {
			System.out.println("Add-on pop up is not present");
		}
		return this;
	}
	
	//Method to click the continue button in passenger screen
	public PaymentPage AddOnContinue() throws IOException {
		
		// Passing info the extent report for test case
		extentTest.info("Clicking the continue button in the AddOn screen");
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement continueClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='css-76zvg2 r-jwli3a r-poiln3 r-adyw6z r-1kfrs79'])[3]")));
			Actions action = new Actions(driver);
			action.moveToElement(continueClick).click().perform();
			extentTest.info("The Continue button in the AddOn screen was clicked successfully");	
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while clicking the continue button in the AddOn screen  " + " - " + e.getMessage());
			e.printStackTrace();
		}
		return new PaymentPage(driver);
	}
}
