package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RetryTest {

	WebDriver driver;

	@BeforeMethod
	public void openApp() {
		driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void titleTest() {
		Assert.assertEquals(driver.getTitle(), "Yahoo");
	}
}
