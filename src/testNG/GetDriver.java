package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetDriver {
	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
	static WebDriver driver;

	public static WebDriver getDriver() {
		 return tldriver.get();
	}
	
	@Test
	public void openApp() {
		tldriver.set(new ChromeDriver());
		getDriver().get("https://google.com");
		System.out.println(getDriver().getTitle());
		getDriver().close();
	}
}
