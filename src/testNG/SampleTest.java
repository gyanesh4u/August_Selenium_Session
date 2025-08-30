package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class SampleTest {

	@Test(description = "Verify login functionality")
	@Epic("User Management")
	@Feature("Login")
	@Story("Valid user login")
	@Severity(SeverityLevel.CRITICAL)
	public void loginTest() {
		// test code
		Assert.assertTrue(true, "Login successful");
	}
}
