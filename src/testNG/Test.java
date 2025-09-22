package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class Test {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@org.testng.annotations.Test(dataProvider = "loginData")
	public void test(String username, String password) {

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@DataProvider(name = "loginData")
	public Object[][] getData() {
		Object[][] data = new Object[2][2];

		data[0][0] = "Admin";
		data[0][1] = "admin123";
		data[1][0] = "Admin1";
		data[1][1] = "admin1234";
		return data;
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
