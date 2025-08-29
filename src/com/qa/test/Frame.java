package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {
static WebDriver driver;
	static {
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/frames");
	}
	public static void main(String[] args) {
	
		WebElement frame1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame1);
		WebElement body = driver.findElement(By.tagName("body"));
		System.out.println(body.getText());
		driver.switchTo().defaultContent();//this will come out of frame
		WebElement frame2 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame2);
		WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
		System.out.println(sampleHeading.getText());
		
	}
}
