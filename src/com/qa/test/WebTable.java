package com.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	static WebDriver driver;
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/webtables");
		List<WebElement> allElements = driver.findElements(By.xpath("//div[@role='row']"));
		for(WebElement element:allElements) {
			String text = element.getText();
			System.out.println(text);
		}
	}
}
