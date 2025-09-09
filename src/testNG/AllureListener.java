package testNG;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

	 @Override
	    public void onTestFailure(ITestResult result) {
		 try {
	        Object testInstance = result.getInstance();
            WebDriver driver = (WebDriver) testInstance.getClass().getDeclaredField("driver").get(testInstance);
	        if (driver != null) {
	            ScreenshotUtils.attachScreenshot(driver, "Failure Screenshot");
	        }
	    }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
}
}
