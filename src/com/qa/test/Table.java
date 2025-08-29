package com.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/webtables");
		List<WebElement> allText = driver.findElements(By.xpath("//div[@role='row']"));
		for(WebElement text:allText) {
			String t1 = text.getText();
			
			System.out.println(t1);
			if(t1.equals("Kierra")) {
				System.out.println("pass found Kierra");
			}
		}
	}
}
