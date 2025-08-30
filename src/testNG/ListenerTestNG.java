package testNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTestNG implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("test has started");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("test passed succesfully" + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("test failed" + result.getName());

	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("test skip" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("test failed" +result.getName());
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("test failed" +result.getName());
	}

	public void onStart(ITestContext context) {
		System.out.println("test start" +context.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("test finish" +context.getName());
	}
}
