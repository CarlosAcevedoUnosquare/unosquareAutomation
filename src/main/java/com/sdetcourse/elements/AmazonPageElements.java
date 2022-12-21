package com.sdetcourse.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPageElements {
	
	// Here should be all the information related to Amazon home page elements
	
		WebDriver driver;
		
		//Values to be validated
		public static String AMAZON_URL ="https://www.amazon.com/";
		public static String AMAZON_CART_URL ="https://www.amazon.com/gp/cart/view.html?ref_=nav_cart";
		
		//Elements
		@FindBy(xpath = "//input[@id='twotabsearchtextbox']") public WebElement txtSearchBox;
		
		@FindBy(xpath = "(//span[@class='a-offscreen'])[1]") public WebElement txtFirstPrice;
		@FindBy(xpath = "//input[@id='add-to-cart-button']") public WebElement btnAddToCart;
		@FindBy(xpath = "//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']") public WebElement txtAddedToCart;
		@FindBy(xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']") public WebElement cartPrice;
		@FindBy(xpath = "//input[@value='Delete']") public WebElement cartDeleteItem;
		@FindBy(xpath = "(//*[contains(text(), 'was removed from Shopping Cart.')])[1]") public WebElement txtWasRemovedFromShoppingCart;
		
		@FindBy(xpath = "//span[@class='a-price a-text-price a-size-medium apexPriceToPay']") public WebElement txtPriceDetailsLevel;
		@FindBy(xpath = "//span[@id='nav-cart-count']") public WebElement txtCartCounter;
		//@FindBy(xpath = "//span[@id='attachSiNoCoverage-announce']") public WebElement modalWarranty;
		@FindBy(xpath = "//*[@id='attach-warranty-pane']//*[text()=' No, gracias ']") public WebElement modalWarranty;
		@FindBy(xpath = "(//span[@class='a-price-whole'])[1]") public WebElement detailsPagePrice;
		
		
		//span[@id='attachSiNoCoverage-announce']
		
		//Login elements
		@FindBy(xpath = "(//*[contains(@href, 'https://www.amazon.com.mx/ap/signin?')])[1]") public WebElement btnSignIn;
		@FindBy(xpath = "//input[@name='email']") public WebElement txtLoginEmail;
		@FindBy(xpath = "//input[@id='continue']") public WebElement btnLoginContinuar;
		@FindBy(xpath = "//input[@name='password']") public WebElement txtLoginPassword;
		@FindBy(xpath = "//span[@id='auth-signin-button']") public WebElement btnLoginIniciarSession;
		
		//Optional box: Confirm phone number -> Click on 'Omitir' to continue normal flow
		@FindBy(xpath = "//*[contains(text(), 'Omitir')]") public WebElement btnLoginOmitir;
		
		
		
		
		
		public AmazonPageElements(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

}
