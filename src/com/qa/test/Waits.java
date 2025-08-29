package com.qa.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Waits {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.linkText("Gmail")).click();
	}
}
