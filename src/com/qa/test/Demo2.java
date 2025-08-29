package com.qa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2 {

	static WebDriver driver;
	public static void main(String[] args) {
		
		 driver=new ChromeDriver();
		driver.get("https://amazon.com");
		Demo2 d2=new Demo2();
		
		System.out.println(d2.title());
	}
	
	public  String title() {
		return driver.getTitle();
	}
}
