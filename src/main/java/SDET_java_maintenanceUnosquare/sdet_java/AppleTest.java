package SDET_java_maintenanceUnosquare.sdet_java;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sdetcourse.elements.AppleHomeElements;

public class AppleTest extends AbstractBaseTest{

	
	public WebDriver SetUp() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\carlos.acevedo\\\\Documents\\\\git\\\\chromedriver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.apple.com/mx/");
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
	
	public void Click(WebElement element) 
	{
		element.click();
	}
	
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
	
	/**
	 * Method to validate actual driver tab title
	 * @param driver
	 * @param expectedTitle
	 */
	public void validatePageTitle(WebDriver driver, String expectedTitle) {
		System.out.println("Validating actual driver tab title . . .");
		System.out.println("Actual title of the driver is: [" + driver.getTitle().toString() + "]");
		System.out.println("Expected title of the driver is: [" + expectedTitle + "]");
		assertTrue(driver.getTitle().contains(expectedTitle));
	}
	
	/**
	 * Method to validate header elements are displayed and enabled
	 * @param driver
	 */
	public void validateHeaderItems(WebDriver driver) {
		int x;
		for(x=1; x<(x+1);x++) {
			try {
				WebElement headerElement = driver.findElement(By.xpath("(//li[contains(@class, 'ac-gn-item ac-gn-item-menu')])[" + x +"]"));
				Assert.assertEquals(true, headerElement.isDisplayed());
				Assert.assertTrue(headerElement.isEnabled());
				System.out.println("Validating header menu at position [" +x+"] using xPath:"+ headerElement.toString());
				System.out.println("Element at [" +x+"] has the value of: " + headerElement.getText().toString());
			}catch(Exception e){
				System.out.println("No more elements at position [" +x+"]");
				if(x < 10) {
					System.out.println("Expected elements in header should be more than 10");
					assertTrue(false);
				}
				
				break;
			}
		}
		System.out.println("Header elemenets displayed has been shown.");
		
	}
	
	@Test
	public void apple_search_TC000() {
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		AppleTest appleTest = new AppleTest();
		WebDriver driver = appleTest.SetUp();
		WebElement element;
		Actions action = new Actions(driver);

		AppleHomeElements homeElements = new AppleHomeElements(driver);
		
		try {
		System.out.println("This is TC: [" + name +"]");
		//WebElement headerMac = driver.findElement(By.xpath("(//a[@href='/mx/mac/' and @data-analytics-title='mac'])[1]"));
		System.out.println("User landed at: [" + driver.getCurrentUrl().toString() + "]");
		appleTest.ClickWhenEnabled(driver, homeElements.headerMac);
		appleTest.Click(driver, homeElements.headerMac, true);
		
		//WebElement firstText = driver.findElement(By.xpath("(//span[contains(text(), 'MacBook') and @class='typography-hero-product-headline hero-eyebrow'])[1]"));
		//WebElement secondText = driver.findElement(By.xpath("//p[contains(text(), 'Tan poderosa que vuela.') and @class='typography-eyebrow-elevated hero-copy']"));
		System.out.println("Validate elements displaued: ");
		Assert.assertEquals(true, homeElements.firstText.isDisplayed());
		System.out.println("First text is displayed. ");
		Assert.assertEquals(true, homeElements.secondText.isDisplayed());
		System.out.println("Second text is displayed. ");
		
		
		//WebElement headerMagnifier = driver.findElement(By.xpath("//li[@class='ac-gn-item ac-gn-item-menu ac-gn-search' and @role ='search']"));
		//WebElement magnifierInput = driver.findElement(By.xpath("//input[@id='ac-gn-searchform-input']"));
		appleTest.Click(driver, homeElements.headerMagnifier, true);
		appleTest.Click(driver, homeElements.magnifierInput, true);
		appleTest.SendText(homeElements.magnifierInput, "iPhone XR");
		homeElements.magnifierInput.sendKeys(Keys.ENTER);
		
		appleTest.validatePageTitle(driver, "iPhone XR - Apple (MX)");
		appleTest.validateHeaderItems(driver);
		appleTest.closeDriver(driver);
		System.out.println(". . . End of test here ...");

		}catch(Exception e) {
			System.out.println("Something went wrong");
		}
	}
	
	@Test
	public void apple_search_TC001() {
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		AppleTest appleTest = new AppleTest();
		WebDriver driver = appleTest.SetUp();
		WebElement element;
		Actions action = new Actions(driver);

		try {
		System.out.println("This is TC: [" + name +"]");
		WebElement headerMac = driver.findElement(By.xpath("(//a[@href='/mx/mac/' and @data-analytics-title='mac'])[1]"));
		System.out.println("User landed at: [" + driver.getCurrentUrl().toString() + "]");
		appleTest.ClickWhenEnabled(driver, headerMac);
		appleTest.Click(driver, headerMac, true);
		
		WebElement firstText = driver.findElement(By.xpath("(//span[contains(text(), 'MacBook') and @class='typography-hero-product-headline hero-eyebrow'])[1]"));
		WebElement secondText = driver.findElement(By.xpath("//p[contains(text(), 'Tan poderosa que vuela.') and @class='typography-eyebrow-elevated hero-copy']"));
		System.out.println("Validate elements displaued: ");
		Assert.assertEquals(true, firstText.isDisplayed());
		System.out.println("First text is displayed. ");
		Assert.assertEquals(true, secondText.isDisplayed());
		System.out.println("Second text is displayed. ");
		
		
		WebElement headerMagnifier = driver.findElement(By.xpath("//li[@class='ac-gn-item ac-gn-item-menu ac-gn-search' and @role ='search']"));
		WebElement magnifierInput = driver.findElement(By.xpath("//input[@id='ac-gn-searchform-input']"));
		appleTest.Click(driver, headerMagnifier, true);
		appleTest.Click(driver, magnifierInput, true);
		appleTest.SendText(magnifierInput, "iPhone XR");
		magnifierInput.sendKeys(Keys.ENTER);
		
		appleTest.validatePageTitle(driver, "iPhone XR - Apple (MX)");
		appleTest.validateHeaderItems(driver);
		appleTest.closeDriver(driver);
		System.out.println(". . . End of test here ...");

		}catch(Exception e) {
			System.out.println("Something went wrong");
		}
	}
	
	@Test
	public void apple_search_TC002() {
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		AppleTest appleTest = new AppleTest();
		WebDriver driver = appleTest.SetUp();
		WebElement element;
		Actions action = new Actions(driver);

		try {
		System.out.println("This is TC: [" + name +"]");
		WebElement headerMac = driver.findElement(By.xpath("(//a[@href='/mx/mac/' and @data-analytics-title='mac'])[1]"));
		System.out.println("User landed at: [" + driver.getCurrentUrl().toString() + "]");
		appleTest.ClickWhenEnabled(driver, headerMac);
		appleTest.Click(driver, headerMac, true);
		
		WebElement firstText = driver.findElement(By.xpath("(//span[contains(text(), 'MacBook') and @class='typography-hero-product-headline hero-eyebrow'])[1]"));
		WebElement secondText = driver.findElement(By.xpath("//p[contains(text(), 'Tan poderosa que vuela.') and @class='typography-eyebrow-elevated hero-copy']"));
		System.out.println("Validate elements displaued: ");
		Assert.assertEquals(true, firstText.isDisplayed());
		System.out.println("First text is displayed. ");
		Assert.assertEquals(true, secondText.isDisplayed());
		System.out.println("Second text is displayed. ");
		
		
		WebElement headerMagnifier = driver.findElement(By.xpath("//li[@class='ac-gn-item ac-gn-item-menu ac-gn-search' and @role ='search']"));
		WebElement magnifierInput = driver.findElement(By.xpath("//input[@id='ac-gn-searchform-input']"));
		appleTest.Click(driver, headerMagnifier, true);
		appleTest.Click(driver, magnifierInput, true);
		appleTest.SendText(magnifierInput, "iPhone XR");
		magnifierInput.sendKeys(Keys.ENTER);
		
		appleTest.validatePageTitle(driver, "iPhone XR - Apple (MX)");
		appleTest.validateHeaderItems(driver);
		appleTest.closeDriver(driver);
		System.out.println(". . . End of test here ...");

		}catch(Exception e) {
			System.out.println("Something went wrong");
		}
	}
	
	public static void main(String[] args){
	
		// Class initialization
		AppleTest appleTest = new AppleTest();
		/*
		WebDriver driver = appleTest.SetUp();
		WebElement element;
		Actions action = new Actions(driver);

		try {
		WebElement headerMac = driver.findElement(By.xpath("(//a[@href='/mx/mac/' and @data-analytics-title='mac'])[1]"));
		System.out.println("User landed at: [" + driver.getCurrentUrl().toString() + "]");
		appleTest.ClickWhenEnabled(driver, headerMac);
		appleTest.Click(driver, headerMac, true);
		
		WebElement firstText = driver.findElement(By.xpath("(//span[contains(text(), 'MacBook') and @class='typography-hero-product-headline hero-eyebrow'])[1]"));
		WebElement secondText = driver.findElement(By.xpath("//p[contains(text(), 'Tan poderosa que vuela.') and @class='typography-eyebrow-elevated hero-copy']"));
		System.out.println("Validate elements displaued: ");
		Assert.assertEquals(true, firstText.isDisplayed());
		System.out.println("First text is displayed. ");
		Assert.assertEquals(true, secondText.isDisplayed());
		System.out.println("Second text is displayed. ");
		
		
		WebElement headerMagnifier = driver.findElement(By.xpath("//li[@class='ac-gn-item ac-gn-item-menu ac-gn-search' and @role ='search']"));
		WebElement magnifierInput = driver.findElement(By.xpath("//input[@id='ac-gn-searchform-input']"));
		appleTest.Click(driver, headerMagnifier, true);
		appleTest.Click(driver, magnifierInput, true);
		appleTest.SendText(magnifierInput, "iPhone XR");
		magnifierInput.sendKeys(Keys.ENTER);
		
		appleTest.validatePageTitle(driver, "iPhone XR - Apple (MX)");
		appleTest.validateHeaderItems(driver);
		appleTest.closeDriver(driver);
		System.out.println(". . . End of test here ...");

		}catch(Exception e) {
			System.out.println("Something went wrong");
		}
		*/
		appleTest.apple_search_TC000();
	}
}
