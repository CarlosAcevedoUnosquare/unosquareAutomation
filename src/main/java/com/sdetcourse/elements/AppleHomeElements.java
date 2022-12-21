package com.sdetcourse.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppleHomeElements {
	
	WebDriver driver;
	
	@FindBy(xpath = "(//a[@href='/mx/mac/' and @data-analytics-title='mac'])[1]") public WebElement headerMac;
	@FindBy(xpath = "(//span[contains(text(), 'MacBook') and @class='typography-hero-product-headline hero-eyebrow'])[1]") public WebElement firstText;
	@FindBy(xpath = "//p[contains(text(), 'Tan poderosa que vuela.') and @class='typography-eyebrow-elevated hero-copy']") public WebElement secondText;
	@FindBy(xpath = "//li[@class='ac-gn-item ac-gn-item-menu ac-gn-search' and @role ='search']") public WebElement headerMagnifier;
	@FindBy(xpath = "//input[@id='ac-gn-searchform-input']") public WebElement magnifierInput;
	
	public AppleHomeElements(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
