package com.sdetcourse.lib;

import org.openqa.selenium.WebDriver;

import com.sdetcourse.elements.AppleHomeElements;
import com.sdetcourse.pages.AppleHomePage;

public class PageLib {
	private WebDriver driver;
	private AppleHomePage homePage;
	private AppleHomeElements homeElements;
	
	public PageLib(WebDriver driver) {
		this.driver = driver;
		homePage = new AppleHomePage(driver);
		homeElements = new AppleHomeElements(driver);
	}
	
	public AppleHomePage homePage() {
		return homePage;
	}
	
	public AppleHomeElements homeElements() {
		return homeElements;
	}

}
