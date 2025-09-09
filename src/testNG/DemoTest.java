package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class DemoTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.get("https://google.com");
	}
	@Epic("Google")
	@Story("title")
	@Severity(SeverityLevel.MINOR)
	@Step("this is title test")
	@Test(priority = 1)
	public void titleTest() {
		
		Assert.assertEquals(driver.getTitle(), "Google");
	}
	@Epic("Google") //allure serve-->initiate allure server
	@Story("URL")
	@Severity(SeverityLevel.MINOR)
	@Step("this is URL test")
	@Test(priority = 2)
	public void urlTest() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
