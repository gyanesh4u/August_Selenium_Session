package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo8 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		WebElement gmail = driver.findElement(By.xpath("//a[.='Gmail']"));
		boolean flag = gmail.isDisplayed();
		System.out.println(flag);
		WebElement search = driver
				.findElement(By.xpath("//input[@data-ved='0ahUKEwiwp8X13KKPAxV4xzgGHX01LZAQ4dUDCCA']"));
		System.out.println(search.isEnabled());
	}
}
