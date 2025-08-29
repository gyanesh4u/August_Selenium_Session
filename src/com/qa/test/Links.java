package com.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int a=allLinks.size();
		System.out.println(a);
		for(WebElement links:allLinks) {
			String text = links.getText();
			System.out.println(text);
		}
	}
}
