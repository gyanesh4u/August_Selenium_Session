package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	
	WebDriver driver;
	
	@DataProvider(name="Login")
	public Object[][] getTestdata(){
		return ExcelUtil.getTestData("Login");
	}
	
	@BeforeMethod
	public void openApp() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
}
	@Test(dataProvider = "Login")
	public void loginTest(String username,String password) throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(3000);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
