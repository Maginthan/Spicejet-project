package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class SignInPage extends ProjectSpecificationMethod{
	
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Method to select the title for name in SignUp form
	public SignInPage selectTitle() throws IOException {
		try {
			WebDriverWait selectTitleWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			selectTitleWait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.xpath("//select[@class='form-control form-select ']"),By.tagName("option")));
			
			//Identifying the drop down
			Select select = new Select(driver.findElement(By.xpath("//select[@class='form-control form-select ']"))); 
			//Selecting the option by visible text
			select.selectByValue("MR");
			extentTest.info("The title is selected as : Mr  succesfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while selecting the title in Sign Up form "+ " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to enter the first name in SignUp form
	public SignInPage firstName(String FirstName) throws IOException {
		try {
			WebDriverWait firstNameWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement firstNameEle = firstNameWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='first_name']")));
			isElementEnabled(firstNameEle);
			cleartextField(firstNameEle);
			//Actions action = new Actions(driver);
//			action.moveToElement(firstNameEle).sendKeys(FirstName);
//			System.out.println("Entered firstname :"+ FirstName);
			findElementAndSendKeysByXpath(firstNameEle,FirstName);
			extentTest.info("The First Name field is entered with : "+ FirstName + " succesfully");
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("document.getElementById('first_name').value='"+FirstName+"'");			
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while entering first name in first name textfield "+ " - " + e.getMessage());
			e.printStackTrace();
		}   
		return this;
	}
	
	//Method to enter the last name in SignUp form
	public SignInPage lastName(String LastName) throws IOException {
		try {
			WebDriverWait lastNameWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement lastNameEle = lastNameWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='last_name']")));
			isElementEnabled(lastNameEle);
			cleartextField(lastNameEle);
//			Actions action = new Actions(driver);
//			action.moveToElement(lastNameEle).sendKeys(LastName);
//			System.out.println("Entered lastname :"+ LastName);
			findElementAndSendKeysByXpath(lastNameEle,LastName);
			extentTest.info("The Last Name field is entered with : "+ LastName + " succesfully");
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("document.getElementById('last_name').value='"+LastName+"'");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while entering last name in last name textfield "+ " - " + e.getMessage());
			e.printStackTrace();
		} 
		return this;
	}
	
	//Method to select the D.O.B in the SingUp form
	public SignInPage dateOfBirth(String Month, String Year, String Date) throws IOException {
		try {
			//Clicking the date picker
			WebDriverWait datePickerWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement datePicker = datePickerWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='position-absolute top-50 end-0 translate-middle-y me-3']")));
			click(datePicker);

			//Selecting the Month from the select tag drop down
			Select monthSelect = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"))); 
			//Selecting the option by visible text
			monthSelect.selectByVisibleText(Month);
			
			//Selecting the Month from the select tag drop down
			Select yearSelect = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"))); 
			//Selecting the option by visible text
			yearSelect.selectByVisibleText(Year);
			
			//Selecting the Date from the date picker using visible text
			WebElement date = driver.findElement(By.xpath("(//div[text()='1'])[1]"));
			date.click();
			extentTest.info("The D.O.B is selected succesfully");
			
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while selecting D.O.B from the date picker "+ " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to enter the mobile number in the SingUp form
	public SignInPage mobileNumber(String MobileNumber) throws IOException {
		try {
			WebDriverWait mobileNumWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement mobileNumEle = mobileNumWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class=' form-control']")));
			isElementEnabled(mobileNumEle);
			cleartextField(mobileNumEle);
//			Actions action = new Actions(driver);
//			action.moveToElement(mobileNumEle).sendKeys(MobileNumber);
//			System.out.println("Entered mobile :"+ MobileNumber);
			//findElementAndSendKeysByXpath(mobileNumEle,MobileNumber);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementsByClassName(' form-control')[5].value='"+MobileNumber+"'");
			extentTest.info("The Mobile number field is entered with : "+ MobileNumber + " succesfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while entering mobile number in the mobile number textfield "+ " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to enter the email ID in the SingUp form
	public SignInPage emailID(String EmailID) throws IOException, InterruptedException {
		try {
//				WebDriverWait loaderWait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
//				loaderWait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://spiceclub.spicejet.com/public/loader.gif']")));
//			
//				WebDriverWait loaderWait = new WebDriverWait(driver, Duration.ofSeconds(5));
//				loaderWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@src='https://spiceclub.spicejet.com/public/loader.gif']")));
			
				WebDriverWait emailWait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement emailEle = emailWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email_id']")));
				//WebElement emailEle = driver.findElement(By.xpath("//input[@id='email_id']"));
				isElementEnabled(emailEle);
				cleartextField(emailEle);
//				Actions action = new Actions(driver);
//				action.moveToElement(emailEle).sendKeys(EmailID);
//				System.out.println("Entered email :"+ EmailID);
				//findElementAndSendKeysByXpath(emailEle,EmailID);
				//emailEle.sendKeys(EmailID);
				//System.out.println("The enter mail id is :"+ emailEle.getText());
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.getElementById('email_id').value='"+EmailID+"'");
				extentTest.info("The EmailID field is entered with : "+ EmailID + " succesfully");
				//js.executeScript("arguments[0].value="+EmailID, emailEle);
			

		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while entering emailID in the emailID textfield "+ " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to enter the password in the SignUp form
	public SignInPage password(String Password) throws IOException {
		try {
			WebDriverWait passWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement passEle = passWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='new-password']")));
			isElementEnabled(passEle);
			cleartextField(passEle);
//			Actions action = new Actions(driver);
//			action.moveToElement(passEle).sendKeys(Password);
//			System.out.println("Entered pass :"+ Password);
			//findElementAndSendKeysByXpath(passEle,Password);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('new-password').value='"+Password+"'");
			extentTest.info("The Password field is entered with : "+ Password + " succesfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while entering password in the password textfield "+ " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to enter the confirm password in the SignUp form
	public SignInPage comfirmPassword(String ConfirmPassword) throws IOException {
		try {
			WebDriverWait confirmPassWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement confirmPassEle = confirmPassWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='c-password']")));
			isElementEnabled(confirmPassEle);
			cleartextField(confirmPassEle);
//			Actions action = new Actions(driver);
//			action.moveToElement(confirmPassEle).sendKeys(ConfirmPassword);
//			System.out.println("Entered conpass :"+ ConfirmPassword);
			//findElementAndSendKeysByXpath(confirmPassEle,ConfirmPassword);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('c-password').value='"+ConfirmPassword+"'");
			extentTest.info("The Comfirm Password field is entered with : "+ ConfirmPassword + " succesfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while entering confirm password in the confirm password textfield "+ " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to check the Terms and Conditions in the SignUp form
//	public SignInPage termsAndConditions() throws IOException {
//		try {
//			WebDriverWait termsCheckWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			WebElement termsCheckEle = termsCheckWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"defaultCheck1\"]")));
//			Actions action = new Actions(driver);
//			action.moveToElement(termsCheckEle).click().perform();
//			//click(termsCheckEle);
//		}catch(Exception e) {
//			// Calling public method to take screenshot
//			filePath = takeScreenshot(testName);
//			// Calling method the to capture screenshot from path
//			extentTest.addScreenCaptureFromPath(filePath, testName);
//			extentTest.fail("Exception occured while checking the Terms and Conditons checkbox in the Sign Up form "+ " - " + e.getMessage());
//		}
//		return this;
//	}
	
	//Method to click the Submit button in the SignUp form
	public SignInPage submit() throws IOException {
		try {
			WebDriverWait submitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement submitEle = submitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-red']")));
			isElementEnabled(submitEle);
			Actions action = new Actions(driver);
			action.moveToElement(submitEle).click().perform();
			extentTest.info("The Submit button is clicked in the Sign Up form succesfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while clicking the Submit button in the Sign Up form "+ " - " + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
}




























