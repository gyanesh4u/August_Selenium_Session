package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrame {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/nestedframes");
		WebElement frame1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame1);
		WebElement body = driver.findElement(By.tagName("body"));
		System.out.println(body.getText());
		WebElement child = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
		driver.switchTo().frame(child);
		WebElement childText = driver.findElement(By.tagName("body"));
		System.out.println(childText.getText());
	}
	
}
