package com.qa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stale {

	
	public static void main(String[] args) {
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://google.com");
		 driver.switchTo().newWindow(WindowType.WINDOW);//selenium 4
		 
		 driver.get("https://gmail.com");
	}
}
