package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Upload {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");
		WebElement upload = driver.findElement(By.id("uploadFile"));
		upload.sendKeys("/Users/gyaneshkamal/eclipse-workspace/August_Selenium_Session/Selenium notes (2).pdf");
		
	}
}
