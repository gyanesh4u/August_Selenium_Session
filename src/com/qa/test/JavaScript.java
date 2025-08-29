package com.qa.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://news.google.com/home?hl=en-IN&gl=IN&ceid=IN:en");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");

	}
}
