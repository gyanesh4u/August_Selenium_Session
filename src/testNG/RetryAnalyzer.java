package testNG;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int counter = 0;
	int retryCount = 4;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (counter < retryCount) {
			counter++;
			return true;
		}
		return false;
	}

}
