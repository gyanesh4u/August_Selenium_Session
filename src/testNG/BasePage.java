package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePage {
	WebDriver driver;// global method
	//WebElement element;
	String s;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		Reporter.log("opening chrome browser", true);
		driver = new ChromeDriver();
		Reporter.log("opening google.com", true);
		driver.get("https://google.com");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		Reporter.log("quiting browser", true);
		driver.quit();
	}
}
