package SDET_java_maintenanceUnosquare.sdet_java;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sdetcourse.elements.AmazonPageElements;
import com.sdetcourse.elements.FacebookHomePageElements;
import com.sdetcourse.pages.AmazonHomePage;
import com.sdetcourse.pages.AmazonLoginPage;
import com.sdetcourse.pages.FacebookHomePage;
import com.sdetcourse.reader.ConfigFileReadFromFile;

public class AmazonTestCases {

	public WebDriver SetUp() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\carlos.acevedo\\\\Documents\\\\git\\\\chromedriver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(AmazonPageElements.AMAZON_URL);
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
	
	
	public void Amazon_TC000() {
		//Class initialization
		AmazonTestCases amazonTestCases = new AmazonTestCases();
		WebDriver driver = amazonTestCases.SetUp();
		AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
				
		// Test case information
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("This is TC: [" + name +"]");
		System.out.println("User landed at: [" + driver.getCurrentUrl().toString() + "]");
				
		//Test case starts here
		try {
			amazonHomePage.validatePageURL(AmazonPageElements.AMAZON_URL);
			amazonHomePage.searchForItem("Galaxy Note 20");
			amazonHomePage.getPriceAtPosition(1);
			amazonHomePage.clickElementAtPosition(1);
			amazonHomePage.getPriceAtPosition(1);
			amazonHomePage.comparePrices();
			amazonHomePage.clickAddToCart();
			amazonHomePage.verifyAddedToCart();
			amazonHomePage.navigateToCartPage();
			amazonHomePage.validateCartPrice();
			assertTrue(true);
		}catch(Exception e){
			System.out.println("Something went wrong at TC: [" + name +"]");
			assertTrue(false);
		}
	}
	
	
	public void BASE_Amazon_Search_Item(String itemToSearch) {
		//Class initialization
		AmazonTestCases amazonTestCases = new AmazonTestCases();
		WebDriver driver = amazonTestCases.SetUp();
		AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
				
		// Test case information
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("This is TC: [" + name +"]");
		System.out.println("User landed at: [" + driver.getCurrentUrl().toString() + "]");
				
		//Test case starts here
		try {
			amazonHomePage.validatePageURL(AmazonPageElements.AMAZON_URL);
			amazonHomePage.searchForItem(itemToSearch);
			amazonHomePage.getPriceAtPosition(1);
			amazonHomePage.clickElementAtPosition(1);
			amazonHomePage.getPriceAtPosition(1);
			amazonHomePage.comparePrices();
			amazonHomePage.clickAddToCart();
			//amazonHomePage.verifyAddedToCart();
			amazonHomePage.navigateToCartPage();
			amazonHomePage.validateCartPrice();
			amazonHomePage.deleteFirstItem();
			amazonHomePage.HARD_WAIT_X_SECONDS(2);
			assertTrue(true);
			closeDriver(driver);
		}catch(Exception e){
			System.out.println("Something went wrong at TC: [" + name +"]");
			assertTrue(false);
			closeDriver(driver);
		}
	}
	
	//@Test
	public void search_item_001() {
		BASE_Amazon_Search_Item("Galaxy Note 20");
	}
	
	//@Test
	public void search_item_002() {
		BASE_Amazon_Search_Item("Galaxy S20 FE 5G");
	}
	
	@BeforeTest
	public void beforeTestMethodHere() {
		System.out.println("Implementing Before test method in this section");
	}
	
	@AfterTest
	public void afterTestMethodHere() {
		System.out.println("Implementing After test method in this section");
	}
	
	@Test
	public void amazon_end_to_end_flow() {
		//Class initialization
		AmazonTestCases amazonTestCases = new AmazonTestCases();
		WebDriver driver = amazonTestCases.SetUp();
		AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
		AmazonLoginPage amazonLoginPage = new AmazonLoginPage(driver);
		ConfigFileReadFromFile configFileReadFromFile = new ConfigFileReadFromFile();
				
		// Test case information
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("This is TC: [" + name +"]");
		System.out.println("User landed at: [" + driver.getCurrentUrl().toString() + "]");
		String itemToSearch = configFileReadFromFile.getJsonValueOf("amazon_mx_product1");
		String itemToSearch2 = configFileReadFromFile.getJsonValueOf("amazon_mx_product2");
		//Test case starts here
		try {
			amazonLoginPage.navigateToAmazonMX();
			amazonLoginPage.clickSignIn();
			amazonLoginPage.writeUserEmail();
			amazonLoginPage.clickContinuar();
			amazonLoginPage.writeUserPassword();
			amazonLoginPage.clickIniciarSession();
			amazonHomePage.searchForItem(itemToSearch);
			amazonHomePage.scrollToElementAtPosition(1);
			amazonHomePage.getPriceAtPosition(1);
			amazonHomePage.clickElementAtPosition(1);
			//amazonHomePage.getPriceAtPosition(1);
			amazonHomePage.getPriceAtCartLevel();
			amazonHomePage.comparePrices();
			amazonHomePage.clickAddToCart();
			//
			amazonHomePage.checkForWarrantyModal();
			amazonHomePage.getPriceAtPosition(1);
			amazonHomePage.comparePrices();
			amazonHomePage.validateItemsInCartAre(1);
			amazonHomePage.searchForItem(itemToSearch2);
			amazonHomePage.scrollToElementAtPosition(1);
			amazonHomePage.clickElementAtPosition(1);
			amazonHomePage.clickAddToCart();
			//
			amazonHomePage.checkForWarrantyModal();
			amazonHomePage.validateItemsInCartAre(2);
			assertTrue(true);
			closeDriver(driver);
		}catch(Exception e){
			System.out.println("Something went wrong at TC: [" + name +"]");
			assertTrue(false);
			closeDriver(driver);
		}
	}
	
	
	
	public static void main(String[] args){
		AmazonTestCases amazonTestCases = new AmazonTestCases();
		//amazonTestCases.Amazon_TC000();
		//amazonTestCases.search_item_001();
		//amazonTestCases.search_item_002();
		amazonTestCases.amazon_end_to_end_flow();
	}
	
}
