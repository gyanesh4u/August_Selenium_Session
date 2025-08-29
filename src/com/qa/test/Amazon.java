package com.qa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://amazon.in");
		 Util u=new Util(driver);
		 
		 System.out.println(u.title());
	}
}
