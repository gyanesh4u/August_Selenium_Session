package testNG;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest {

	
	@Test
	public void testOnGrid() throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName("safari");
		WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dc);
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(10000);
		driver.quit();
		
		}
}
