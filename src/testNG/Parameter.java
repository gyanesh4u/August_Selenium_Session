package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {
	WebDriver driver;// global method

	@BeforeMethod
	@Parameters({ "browser", "url" })
	public void setUp(String browser, String url) {
		System.out.println("browser name.." + browser);
		Reporter.log("url is..." + url, true);
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("ff")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("safari")) {
			driver = new SafariDriver();
		}
		driver.get(url);
	}

	@Test
	public void titleTest() {
		System.out.println(driver.getTitle());
	}

	@AfterMethod
	public void tearDown() {
		Reporter.log("quiting browser", true);
		driver.quit();
	}
}
