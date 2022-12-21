package SDET_java_maintenanceUnosquare.sdet_java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestingStuff {


	public WebDriver SetUp() 
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\luis.osuna\\Downloads\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\carlos.acevedo\\\\Documents\\\\git\\\\chromedriver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo-store.seleniumacademy.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
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
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	//By ThreeDotMenu = By.cssSelector("needs maintenance");
	//By AboutUS = By.xpath("needs maintenance");
	//By Personal = By.cssSelector("needs maintenance");
	
	By ThreeDotMenu = By.xpath("//span[@class='navbar-toggler-icon']");
	By AboutUS = By.xpath("//a[@href='#about-us']");
	//By Personal = By.xpath("(//div[@class='d-flex flex-row'])[1]");
	By Personal = By.xpath("//div[@class='about-button' and @onclick='openAbout(0)']");
	
	/*
	 * List of elements for the demoshop: http://demo-store.seleniumacademy.com/
	 */

	By menuWomen = By.xpath("//li[@class='level0 nav-1 first parent']");
	By menuMen = By.xpath("//li[@class='level0 nav-2 parent']");
	By menuAccesories = By.xpath("//li[@class='level0 nav-3 parent']");
	
	By txtSearch = By.xpath("//input[@id='search']");
	
	public static void main(String[] args){
	
		TestingStuff testingStuff = new TestingStuff();
		WebDriver driver = testingStuff.SetUp();
		WebElement element;
		Actions action = new Actions(driver);
		WebElement tabWomen = driver.findElement(testingStuff.menuWomen);
		WebElement tabMen = driver.findElement(testingStuff.menuMen);
		WebElement tabAccesories = driver.findElement(testingStuff.menuAccesories);
		WebElement txtSearchBox = driver.findElement(testingStuff.txtSearch);
		String searchingArgument = "Chelsea Tee";
		WebElement btnSearch = driver.findElement(By.xpath("//button[@type='submit' and @class='button search-button']"));
		WebElement actualResult = driver.findElement(By.xpath("//li[@class='item last']"));
		
		
		/*
		element = driver.findElement(program.ThreeDotMenu);
		program.Click(element);		
		System.out.println("Located element: "+ element.toString());
		element = driver.findElement(program.AboutUS);
		program.Click(element);		
		System.out.println("Located element: "+ element.toString());
		element = driver.findElement(program.Personal);
		program.Click(element);	
		System.out.println("Located element: "+ element.toString());
		*/
		try {
		System.out.println("Hovering action here after landing on the page");
		action.moveToElement(tabWomen).moveToElement(driver.findElement(By.xpath("//li[@class='level0 nav-2 parent']"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(tabMen).moveToElement(driver.findElement(By.xpath("//li[@class='level0 nav-3 parent']"))).build().perform();
		Thread.sleep(1000);
		txtSearchBox.click();
		txtSearchBox.sendKeys(searchingArgument);
		Thread.sleep(3000);
		btnSearch.click();
		}catch(Exception e) {
			System.out.println("Something were wrong at code");
		}
		
	}

	
	
}
