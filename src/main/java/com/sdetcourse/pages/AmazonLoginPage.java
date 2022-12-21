package com.sdetcourse.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sdetcourse.elements.AmazonPageElements;
import com.sdetcourse.reader.ConfigFileReadFromFile;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class AmazonLoginPage {

	WebDriver driver;
	AmazonPageElements amazonElements;
	AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
	ConfigFileReadFromFile configFileReadFromFile = new ConfigFileReadFromFile();
	
	public AmazonLoginPage(WebDriver driver) {
		this.driver = driver;
		amazonElements = new AmazonPageElements(driver);
	}
	
	@Given("User nagivates to amazonMX page")
	public void navigateToAmazonMX() {
		System.out.println("Trying to get URL:" + configFileReadFromFile.getJsonValueOf("AMAZON_MX_URL"));
		driver.get(configFileReadFromFile.getJsonValueOf("AMAZON_MX_URL"));
	}
	
	@When("User clicks on signin button")
	public void clickSignIn() {
		amazonHomePage.Click(driver, amazonElements.btnSignIn, true);
	}
	
	@When("User writes user email")
	public void writeUserEmail() {
		String user = configFileReadFromFile.getJsonValueOf("amazon_mx_email");
		amazonHomePage.SendText(amazonElements.txtLoginEmail, user);
		System.out.println("Email entered.");
	}
	
	@When("User clicks continuar button")
	public void clickContinuar() {
		amazonHomePage.Click(driver, amazonElements.btnLoginContinuar, true);
	}
	
	@When("User wirtes password")
	public void writeUserPassword() {
		String pwd = configFileReadFromFile.getJsonValueOf("amazon_mx_pwd");
		amazonHomePage.SendText(amazonElements.txtLoginPassword, pwd);
		System.out.println("Password entered.");
	}
	
	@When("User clicks iniciar sesion")
	public void clickIniciarSession() {
		amazonHomePage.Click(driver, amazonElements.btnLoginIniciarSession, true);
		//checkForSkipSecurityPopUp();
	}
	
	@When("User checks for security pop-up")
	public void checkForSkipSecurityPopUp() {
		if (amazonElements.btnLoginOmitir.isDisplayed()) {
			try {
				amazonHomePage.Click(driver, amazonElements.btnLoginOmitir, true);
				System.out.println("'Omitir' button has been clicked.");
			}catch(Exception e) {
				System.out.println("'Omitir' flow catched here.");
			}
		}
	}
	
	@When("User validates landing on amazon home page")
	public void validateHomePageLanding() {
		System.out.println("Validate user landed on the main page");
		assertTrue(driver.getCurrentUrl().contains("returnFromLogin"));
	}
	
}
