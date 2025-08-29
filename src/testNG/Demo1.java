package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 extends BasePage {

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
