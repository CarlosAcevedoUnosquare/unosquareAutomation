package com.sdetcourse.pages;

import org.openqa.selenium.WebDriver;

import com.sdetcourse.elements.AppleHomeElements;

public class AppleHomePage {
	
	WebDriver driver;
	AppleHomeElements appleHomeElements;
	
	public AppleHomePage(WebDriver driver) {
		this.driver = driver;
		appleHomeElements = new AppleHomeElements(driver);
	}

}
