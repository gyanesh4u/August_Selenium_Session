package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftVsHard {
	/*
	 * Softassert is having non static methods so we need to create object of it
	 * Hardassert all the methods are static
	 * 
	 * if test fails execution wont halt-->sf
	 * execution halts if fails-->ha
	 * 
	 * assertall-->sf
	 * not have assertall method-->Ha
	 * 
	 */
//hello h=1,2=1,l=2,o=1
	@Test(priority = 1)
	public void softAssert() {
		System.out.println("sf1");
		SoftAssert sf=new SoftAssert();
		sf.assertTrue(false);//fail
		System.out.println("sf2");
		sf.assertAll();
	}
	@Test(priority = 2)
	public void hardAssert() {
		System.out.println("hard 1");
		Assert.assertTrue(false);//fail
		System.out.println("hard 2");
	}
}
