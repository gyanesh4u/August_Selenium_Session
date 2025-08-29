package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo6 {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://google.com");
		 Util u=new Util(driver);
		WebElement search = driver.findElement(By.name("q"));
		u.doSendKeys(By.name("q"), "java");
		//u.doSendKeys(search, "java");
		u.highlightElement(search);
	}
}
