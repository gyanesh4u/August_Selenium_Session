package testNG;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest {

	
	 @Test
	    public void testOnGrid() throws MalformedURLException {
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setBrowserName("safari");   // or "firefox"

	        WebDriver driver = new RemoteWebDriver(
	                new URL("http://localhost:4444/wd/hub"), caps);

	        driver.get("https://www.google.com");
	        System.out.println("Title is: " + driver.getTitle());

	        driver.quit();
	    }
}
