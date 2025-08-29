package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoft {

	@Test
	public void soft() {
		System.out.println("soft assert 1");
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(false);
		System.out.println("soft assert 2");
		sa.assertAll();
	}

	@Test
	public void hard() {
		System.out.println("hard");
		Assert.assertTrue(false);//fails
		System.out.println("hard assert");//didn't run this line
	}
}
