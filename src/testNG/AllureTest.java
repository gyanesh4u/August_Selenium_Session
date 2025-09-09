package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class AllureTest {
	WebDriver driver;
@Step("starting app")
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}
	@Test
	@Epic("Google Page")
	@Story("Google Title")
	@Feature("title")
	@Severity(SeverityLevel.NORMAL)
	@Step("title test steps")
	public void titleTest() {
		Assert.assertEquals(driver.getTitle(), "Google");
	}
	@Step("closing app")
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
