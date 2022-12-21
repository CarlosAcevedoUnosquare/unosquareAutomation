package com.sdetcourse.pages;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sdetcourse.elements.AppleHomeElements;
import com.sdetcourse.elements.FacebookHomePageElements;

public class FacebookHomePage {

	WebDriver driver;
	FacebookHomePageElements facebookHomePageElements;
	
	public FacebookHomePage(WebDriver driver) {
		this.driver = driver;
		facebookHomePageElements = new FacebookHomePageElements(driver);
	}
	
	
	public WebDriver SetUp() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\carlos.acevedo\\\\Documents\\\\git\\\\chromedriver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(FacebookHomePageElements.FACEBOOK_URL);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	/**
	 * Method to close browser.
	 * @param driver
	 */
	public void closeDriver(WebDriver driver) {
		System.out.println("Closing browser . . .");
		driver.close();
	}
	
	// Methods of the page
	/**
	 * Click when element is available with 15s timeout
	 * @param driver
	 * @param element
	 */
	public void ClickWhenEnabled(WebDriver driver, WebElement element) 
	{
		System.out.println("Attempting to click on the element: [" + element + "]");
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * Method to wait until element is clickable, you can click it after that.
	 * @param driver
	 * @param element
	 * @param click
	 */
	public void Click(WebDriver driver, WebElement element, boolean click) {
		ClickWhenEnabled(driver, element);
		if(click) {
			element.click();
		}
	}
	
	public void SendText(WebElement element, String value) 
	{
		element.sendKeys(value);
	}
	
	/**
	 * Method to select gender: 1-Female, 2-Male, 3-Custom
	 * @param gender
	 */
	public void selectGender(int gender) {
		System.out.println("Select gender method:");
		switch(gender) {
		case 1:
			System.out.println("Selected: Female");
			Click(driver, driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba'])[" + gender +"]")), true);
			break;
		case 2:
			System.out.println("Selected: Male");
			Click(driver, driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba'])[" + gender +"]")), true);
			break;
		case 3:
			System.out.println("Selected: Custom");
			Click(driver, driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba'])[" + gender +"]")), true);
			break;
		default:
			System.out.println("Case not specified correctly");
			break;
		}
		
	}
	
	/**
	 * Method to validate both headers at the page: SignUp header and Subheader
	 */
	public void validateHeadersDisplayed() {
		WebElement elementToValidate;
		elementToValidate = facebookHomePageElements.signUpHeader;
		System.out.println("Validating element displayed using assertion method:" + elementToValidate.getText().toString());
		assertTrue(elementToValidate.isDisplayed());
		
		elementToValidate = facebookHomePageElements.signUpSubHeader;
		System.out.println("Validating element displayed using assertion method:" + elementToValidate.getText().toString());
		assertTrue(elementToValidate.isDisplayed());
	}
	
	/**
	 * Fill the form with some data hardcoded here
	 */
	public void fillAccountForm() {
		System.out.println("Entering in the fill account form method . . .");
		//driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='_8ien']")));
		SendText(facebookHomePageElements.txtFirstName, "FirstNameHere");
		SendText(facebookHomePageElements.txtLastName, "LastNameHere");
		SendText(facebookHomePageElements.txtEmail, "SDETemail@something.com");
		SendText(facebookHomePageElements.txtPwd, "password");
		SendText(facebookHomePageElements.ddMonth, "Feb");
		SendText(facebookHomePageElements.ddDay, "20");
		SendText(facebookHomePageElements.ddYear, "2000");
		System.out.println("Form filled . . .");
	}
	
	
	/**
	 * Method to trigger follow path and land on Forgot my Password
	 */
	public void forgotPasswordPageFlow() {
		Click(driver, facebookHomePageElements.linkedBtnAlreadyHaveAnAccount, true);
		Click(driver, facebookHomePageElements.linkedBtnForgotPassword, true);
		
	}
	
	/**
	 * Validate the title of the page using assertion
	 * @param expectedTitle
	 */
	public void validatePageTitle(String expectedTitle) {
		System.out.println("Validating actual driver tab title . . .");
		System.out.println("Actual title of the driver is: [" + driver.getTitle().toString() + "]");
		System.out.println("Expected title of the driver is: [" + expectedTitle + "]");
		assertTrue(driver.getTitle().contains(expectedTitle));
	}
	
	/**
	 * Validate the URL of the page comparing vs static string at Elements class
	 * @param expectedURL
	 */
	public void validatePageURL(String expectedURL) {
		System.out.println("Validating actual driver tab title . . .");
		System.out.println("Actual title of the driver is: [" + driver.getCurrentUrl().toString() + "]");
		System.out.println("Expected title of the driver is: [" + expectedURL + "]");
		assertTrue(driver.getCurrentUrl().contains(expectedURL));
	}
	
	public void validateFindYourAccountHeader() {
		System.out.println("Validating header of the page . . .");
		assertTrue(facebookHomePageElements.lblFindYourAccount.isDisplayed());
		System.out.println("Element text: " + facebookHomePageElements.lblFindYourAccount.getText());
		
	}
	
	/**
	 * Sending text to email field
	 * @param invalidEmail
	 */
	public void searchInvalidEmail(String invalidEmail) {
		System.out.println("Writting invalid email: " + invalidEmail);
		SendText(facebookHomePageElements.txtFindAccountEmail, invalidEmail);
	}
	
	/**
	 * Clicking on search email
	 */
	public void clickSearchEmail() {
		Click(driver, facebookHomePageElements.btnSearchEmail, true);
	}
	
	/**
	 * Validate error message at searching email page.
	 */
	public void validateEmailNotFound() {
		System.out.println("Validating error displayed. . .");
		assertTrue(facebookHomePageElements.lblNoResultMessage.isDisplayed());
		System.out.println("Displayed error message: " + facebookHomePageElements.lblNoResultMessage.getText());
	}
	
}
