package SDET_java_maintenanceUnosquare.sdet_java;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.sdetcourse.elements.FacebookHomePageElements;
import com.sdetcourse.pages.FacebookHomePage;

public class FacebookTestCases {
	

	public WebDriver SetUp() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\carlos.acevedo\\\\Documents\\\\git\\\\chromedriver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(FacebookHomePageElements.FACEBOOK_SIGN_IN_URL);
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
	
	public void SendText(WebElement element, String value) 
	{
		element.sendKeys(value);
	}
	
	// Test cases area
	
	@Test
	public void Facebook_TC000() {
		//Class initialization
		FacebookTestCases facebookTestCases = new FacebookTestCases();
		WebDriver driver = facebookTestCases.SetUp();
		FacebookHomePage facebookHomePage = new FacebookHomePage(driver);
		
		// Test case information
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("This is TC: [" + name +"]");
		System.out.println("User landed at: [" + driver.getCurrentUrl().toString() + "]");
		
		//Test case starts here
		try {
		facebookHomePage.validatePageURL(FacebookHomePageElements.FACEBOOK_SIGN_IN_URL);
		facebookHomePage.fillAccountForm();
		facebookHomePage.selectGender(1);
		facebookHomePage.validateHeadersDisplayed();
		facebookHomePage.forgotPasswordPageFlow();
		facebookHomePage.validatePageTitle("Forgot password | Can't log in | Facebook");
		facebookHomePage.validateFindYourAccountHeader();
		facebookHomePage.searchInvalidEmail("InvalidEmail@thisAddressForSureIsInvalid.something");
		facebookHomePage.clickSearchEmail();
		facebookHomePage.validateEmailNotFound();
		facebookHomePage.closeDriver(driver);
		assertTrue(true);
		}catch(Exception e) {
			System.out.println("Something went wrong . . .");
			assertTrue(false);
			facebookHomePage.closeDriver(driver);
		}
	}
	
	public static void main(String[] args){
		FacebookTestCases facebookTestCases = new FacebookTestCases();
		facebookTestCases.Facebook_TC000();
	}
}
