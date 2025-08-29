package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupsConcept {
	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
	}

	@Test(groups = {"regression"})
	public void titleTest() {

		Assert.assertEquals(driver.getTitle(), "Google");
	}

	@Test(groups = {"smoke"})
	public void gmailLinkTest() {

		WebElement gmail = driver.findElement(By.linkText("Gmail"));
		Assert.assertTrue(gmail.isDisplayed());
	}

	@Test(groups = {"smoke"})
	public void imageLinkTest() {
		WebElement images = driver.findElement(By.linkText("Images"));
		Assert.assertTrue(images.isDisplayed());
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
