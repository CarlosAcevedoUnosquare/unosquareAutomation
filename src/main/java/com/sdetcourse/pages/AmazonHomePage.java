package com.sdetcourse.pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sdetcourse.elements.AmazonPageElements;
import com.sdetcourse.elements.FacebookHomePageElements;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonHomePage {
	
	WebDriver driver;
	AmazonPageElements amazonElements;
	List<String> priceArray = new ArrayList<String>();
	
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		amazonElements = new AmazonPageElements(driver);
	}
	
	public WebDriver SetUp() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\carlos.acevedo\\\\Documents\\\\git\\\\chromedriver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(AmazonPageElements.AMAZON_URL);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
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
		 * Validate the URL of the page comparing vs static string at Elements class
		 * @param expectedURL
		 */
		@When("User validates page URL expectin to be {String}")
		public void validatePageURL(String expectedURL) {
			System.out.println("Validating actual driver tab title . . .");
			System.out.println("Actual title of the driver is: [" + driver.getCurrentUrl().toString() + "]");
			System.out.println("Expected title of the driver is: [" + expectedURL + "]");
			assertTrue(driver.getCurrentUrl().contains(expectedURL));
		}
		
	@When("User search for item {String}")
	public void searchForItem(String item) {
		Click(driver, amazonElements.txtSearchBox, true);
		SendText(amazonElements.txtSearchBox, item);
		System.out.println("Text sent to element: " + item);
		amazonElements.txtSearchBox.sendKeys(Keys.ENTER);
	}
	
	public void storePrice(float price) {
		System.out.println("Storing price: " + price);
		priceArray.add(""+price);
		System.out.println("Array elements: " + priceArray.toString());
	}
	
	@When("User stores price at position {int}")
	public void getPriceAtPosition(int position) {
		WebElement priceAtPosition = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[" + position +"]"));
		WebElement priceAtPosition2 = driver.findElement(By.xpath("(//span[@class='a-price-fraction'])[" + position +"]"));
		System.out.println("The price at position: [" + position + "] is: "+ priceAtPosition.getText());
		System.out.println("The price at position: [" + position + "] is: "+ priceAtPosition2.getText());
		String wholePrice = priceAtPosition.getText() +"."+ priceAtPosition2.getText();
		wholePrice = wholePrice.replaceAll("[,]", "");
		System.out.println("Whole price is: " + wholePrice);
		float f = Float.parseFloat(wholePrice);
		storePrice(f);
	}
	
	@When("User clicks element at position {int}")
	public void clickElementAtPosition(int position) {
		WebElement elementAtPosition = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[" + position +"]"));
		Click(driver, elementAtPosition, true);
	}
	
	@When("User compares prices in the cart")
	public void comparePrices() {
		System.out.println("Comparing prices. . .");
		System.out.println("Price at position [0] is: " + priceArray.get(0));
		System.out.println("Price at position [1] is: " + priceArray.get(1));
		assertTrue(priceArray.get(0).contains(priceArray.get(1)));
		System.out.println("Prices are the same.");
	}
	
	@Then("User clicks add to cart button")
	public void clickAddToCart() throws InterruptedException {
		Click(driver, amazonElements.btnAddToCart, true);
		// In case the browser is slow:
		Thread.sleep(2000);
	}
	
	@Then("User verifies item has been added to cart")
	public void verifyAddedToCart() {
		assertTrue(amazonElements.txtAddedToCart.isDisplayed());
		System.out.println("Item was added to cart successfully.");
	}
	
	@When("User nagivates to cart page")
	public void navigateToCartPage() {
		driver.get(amazonElements.AMAZON_CART_URL);
	}
	
	@When("User validates cart price")
	public void validateCartPrice() {
		System.out.println("Final price of cart is: " + amazonElements.cartPrice.getText());
		System.out.println("Comparing final price with: " + priceArray.get(0));
		String liveprice = amazonElements.cartPrice.getText();
		String priceClean = liveprice.replaceAll("[$]", "");
		assertTrue(priceArray.get(0).contains(priceClean));
		System.out.println("Prices are the same.");
	}
	
	@Then("User deletes the first item of the cart")
	public void deleteFirstItem() {
		Click(driver, amazonElements.cartDeleteItem, true);
		System.out.println("Validating 'Delete successful' message");
		assertTrue(amazonElements.txtWasRemovedFromShoppingCart.isDisplayed());
		System.out.println("Message is present.");
	}
	
	/**
	 * Method to wait 5 seconds so user can check for the final result before closing the driver.
	 * @throws InterruptedException
	 */
	public void HARD_WAIT_X_SECONDS(int seconds) throws InterruptedException {
		int time = (seconds*1000);
		Thread.sleep(time);
	}

	@When("User scrolls to element at position {int}")
	public void scrollToElementAtPosition(int position) {
		Actions actions = new Actions(driver);
		WebElement elementAtPosition = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[" + position +"]"));
		actions.moveToElement(elementAtPosition);
		actions.perform();
	}
	
	@When("User gets price at cart level")
	public void getPriceAtCartLevel() {
		try {
		String wholePrice = amazonElements.txtPriceDetailsLevel.getText();
		wholePrice = wholePrice.replaceAll("[$,]", "");
		System.out.println("Whole price is: " + wholePrice);
		float f = Float.parseFloat(wholePrice);
		storePrice(f);
		}catch(Exception e) {
		getPriceAtPosition(1);
		}
	}
	
	@Then("User validate items in cart are equal to {int}")
	public void validateItemsInCartAre(int amount) {
		System.out.println("Validating item cart counter. Should be -> " + amount);
		String currentAmount = amazonElements.txtCartCounter.getText();
		assertTrue(currentAmount.equals(String.valueOf(amount)));
		System.out.println("Cart counter has the expected items on it.");
	}
	
	@When("User checks for warranty modal and skips it")
	public void checkForWarrantyModal() throws InterruptedException {
		if(amazonElements.modalWarranty.isDisplayed()) {
			try {
			System.out.println("Warranty modal is displayed, choosing 'NO gracias' as option");
			Click(driver, amazonElements.modalWarranty, true);
			}catch(Exception e) {
				Actions action = new Actions(driver);
				action.sendKeys(Keys.ESCAPE).build().perform();
			}
			HARD_WAIT_X_SECONDS(3);
		}
	}
	
}
