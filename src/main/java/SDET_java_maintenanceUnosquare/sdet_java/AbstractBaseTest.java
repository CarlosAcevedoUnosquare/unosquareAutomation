package SDET_java_maintenanceUnosquare.sdet_java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.sdetcourse.elements.AppleHomeElements;
import com.sdetcourse.pages.AppleHomePage;

public class AbstractBaseTest {
	
	WebDriver driver;
	AppleHomePage homePage;
	AppleHomeElements appleHomeElements;
	AppleHomeElements homePageElements;
	
	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("This is the @BeforeTest method from the AbstractBaseTest java file");
	}
	
	@BeforeTest
	public WebDriver SetUp() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\carlos.acevedo\\\\Documents\\\\git\\\\chromedriver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		//
		homePage = new AppleHomePage(driver);
		homePageElements = new AppleHomeElements(driver);
		//
		driver.manage().window().maximize();
		driver.get("https://www.apple.com/mx/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	@AfterTest
	public void afterTestMethod() {
		System.out.println("This is the @AfterTest method from the AbstractBaseTest java file");
	}

}
