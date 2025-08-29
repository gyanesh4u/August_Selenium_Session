package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {
	static WebDriver driver;

	public static void main(String[] args)  {

		driver = new ChromeDriver();
		driver.get("https://google.com");
		Util u = new Util(driver);
		u.takeScreenshot("Google");
		u.takeElementScreenshot(driver.findElement(By.linkText("Gmail")), "Gmail");
		// takeScreenshot("Google");
		// takeElementScreenshot(driver.findElement(By.name("q")), "searchbox");

	}

}
