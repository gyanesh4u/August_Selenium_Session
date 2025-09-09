package testNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FailedTestScreenshot {

	
	WebDriver driver;//global variable
	
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
	}
	@Test
	public void titleTest() {
		Assert.assertEquals(driver.getTitle(), "Facebook");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(!result.isSuccess()) {//true
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src, new File("/Users/gyaneshkamal/eclipse-workspace/"
						+ "August_Selenium_Session/snap//"+System.currentTimeMillis()+".png"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		driver.quit();
	}
}
