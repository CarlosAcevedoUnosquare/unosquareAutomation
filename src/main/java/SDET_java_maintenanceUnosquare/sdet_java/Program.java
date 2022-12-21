package SDET_java_maintenanceUnosquare.sdet_java;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Program {

	public WebDriver SetUp() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\carlos.acevedo\\\\Documents\\\\git\\\\chromedriver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://people.unosquare.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	public void SendText(WebElement element, String value) 
	{
		System.out.println("Ingresing text into element: " + value);
		element.sendKeys(value);
	}
	
	/**
	 * Method to upperCase value variable.
	 * Example: something.SendText(element, "text", true);
	 * @param element
	 * @param value
	 * @param upperCase
	 */
	public void SendText(WebElement element, String value, boolean upperCase) 
	{
		if(upperCase){
			value.toUpperCase();
			System.out.println("Using upper-case method for the text -> final text: " + value);
		}
		System.out.println("Ingresing text into element: " + value);
		element.sendKeys(value);
	}
	
	public void Click(WebElement element) 
	{
		element.click();
	}
	
	/**
	 * This method will print the element desired to be clicked
	 * Example: Click(element, true);
	 * @param element
	 * @param print
	 */
	public void Click(WebElement element, boolean print) 
	{
		if(print) {
		System.out.println("Trying to click on the element: " + element.toString());
		element.click();
		System.out.println("Clicking method end");
		}else {
			element.click();
		}
	}
	
	public void ClickWhenEnabled(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	//By ThreeDotMenu = By.cssSelector("needs maintenance");
	//By AboutUS = By.xpath("needs maintenance");
	//By Personal = By.cssSelector("needs maintenance");
	
	By ThreeDotMenu = By.xpath("//span[@class='navbar-toggler-icon']");
	By AboutUS = By.xpath("//a[@href='#about-us']");
	By Personal = By.xpath("//div[@class='about-button' and @onclick='openAbout(0)']");

	public static void main(String[] args){
		
		Program program = new Program();
		WebDriver driver = program.SetUp();
		WebElement element;
		
		element = driver.findElement(program.ThreeDotMenu);
		program.Click(element);		
		//System.out.println("Located element: "+ element.toString());
		element = driver.findElement(program.AboutUS);
		//program.Click(element);
		program.Click(element, true);
		//System.out.println("Located element: "+ element.toString());
		element = driver.findElement(program.Personal);
		program.Click(element);	
		//System.out.println("Located element: "+ element.toString());
		
	}

}
