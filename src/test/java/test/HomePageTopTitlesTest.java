package test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;

public class HomePageTopTitlesTest extends ProjectSpecificationMethod{

	@BeforeTest
	public void extentTestSetup() {
		testName = "TC_006_HomePageTopTitlesTest";
		testAuthor = "Maginthan";
		testCategory = "Functional";
	}
	
	@Test
	public void TC_006_HomePageTopTitlesTest() throws IOException {
		// TODO Auto-generated method stub
		// Passing info the extent report for test case
		extentTest.info("Verifying the Top Titles in the Home Page");
		
		try {
			//Explicit wait for the titles to be visible 
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> allTitles = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41 r-1pzd9i8']")));
			
			for(int i=0; i< allTitles.size(); i++) {
			Boolean ele = allTitles.get(i).isDisplayed();
			String eleText = allTitles.get(i).getText();
			
			if(ele){
				extentTest.pass("The Top Title validation for title "+ " - " + eleText + " - " +" is displayed");
			}else {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("The Top Title validation for title "+ " - " + eleText + " - " +" is not displayed");
			}
		}
			
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during HomePage Top Titles validation " + " - " + e.getMessage());
			e.printStackTrace();
		}
	}

}
