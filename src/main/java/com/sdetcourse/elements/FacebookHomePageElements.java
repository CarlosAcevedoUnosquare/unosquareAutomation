package com.sdetcourse.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookHomePageElements {

	// Here should be all the information related to Facebook home page elements
	
	WebDriver driver;
	
	//Values to be validated
	public static String FACEBOOK_URL ="https://www.facebook.com/";
	public static String FACEBOOK_SIGN_IN_URL = "https://www.facebook.com/signup";
	public static String FACEBOOK_URL_SIGN_IN_TITLE ="Facebook - Log In or Sign Up";
	
	//Elements
	@FindBy(xpath = "//input[@name='firstname']") public WebElement txtFirstName;
	@FindBy(xpath = "//input[@name='lastname']") public WebElement txtLastName;
	@FindBy(xpath = "//input[@name='reg_email__']") public WebElement txtEmail;
	@FindBy(xpath = "//input[@name='reg_passwd__']") public WebElement txtPwd;
	@FindBy(xpath = "//select[@name='birthday_month']") public WebElement ddMonth;
	@FindBy(xpath = "//select[@name='birthday_day']") public WebElement ddDay;
	@FindBy(xpath = "//select[@name='birthday_year']") public WebElement ddYear;
	
	@FindBy(xpath = "//*[@class='mbs _52lq _9bp_ fsl fwb fcb']") public WebElement signUpHeader;
	@FindBy(xpath = "//*[@class='_52lr _9bq0 fsm fwn fcg']") public WebElement signUpSubHeader;
	
	@FindBy(xpath = "//a[@aria-label='Already have an account?']") public WebElement linkedBtnAlreadyHaveAnAccount;
	@FindBy(xpath = "//a[@href='https://www.facebook.com/recover/initiate/?ars=facebook_login']") public WebElement linkedBtnForgotPassword;
	
	
	@FindBy(xpath = "(//*[contains(text(), 'Find your account')])[2]") public WebElement lblFindYourAccount;
	@FindBy(xpath = "(//input[@name='email'])[2]") public WebElement txtFindAccountEmail;
	
	@FindBy(xpath = "//button[@name='did_submit']") public WebElement btnSearchEmail;
	@FindBy(xpath = "//*[contains(text(), 'Your search did not return any results.')]") public WebElement lblNoResultMessage;
	
	
	public FacebookHomePageElements(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
