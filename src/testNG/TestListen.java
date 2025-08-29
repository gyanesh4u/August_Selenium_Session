package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenersTestNG.class)
public class TestListen {

	
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

	@Test()
	public void titleTest() {
		Assert.assertEquals(driver.getTitle(), "Google");
	}
}
