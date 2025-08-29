package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo7 {

	public static void main(String[] args) {
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://google.com");
		 driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("java");
	}
}
