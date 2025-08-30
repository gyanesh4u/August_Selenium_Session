package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependOn {

	@Test
	public void m1() {
		Assert.assertTrue(true);
	}

	@Test(dependsOnMethods = { "m1" })
	public void m2() {
		System.out.println("m2 method");
	}
}
