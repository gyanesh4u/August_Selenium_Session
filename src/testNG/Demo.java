package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo {

	WebDriver driver;//global method
	
	@BeforeMethod
	public void setUp() {
		Reporter.log("opening chrome browser",true);
		driver=new ChromeDriver();
		Reporter.log("opening google.com",true);
		driver.get("https://google.com");
	}
	@AfterMethod
	public void tearDown() {
		Reporter.log("quiting browser",true);
		driver.quit();
	}
	@Test(description = "this is title test")
	public void titleTest() {
		String title=driver.getTitle();
		Reporter.log(title,true);
		Assert.assertEquals(title, "Google");
		
	}
	@Test(description = "this is gmail link test")
	public void gmailLink() {
		Reporter.log("gmail link",true);
		WebElement gmail = driver.findElement(By.linkText("Gmail"));
		boolean flag = gmail.isDisplayed();
		Assert.assertTrue(flag);
	}
}
