package com.qa.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Demo1 {

	static ChromeDriver driver;
	public static void main(String[] args) {
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--incognito");
		driver=new ChromeDriver(co);
		driver.manage().window().fullscreen();
		driver.get("https://google.com");
//		String title;//declaration
//		//System.out.println(title);
//		title=driver.getTitle();//initiallization
//		System.out.println(title);//utilizatiom
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		
	}
}
