package com.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestions {

	
	public static void main(String[] args) throws InterruptedException {
		 
		WebDriver driver=new ChromeDriver();
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("java");
		Thread.sleep(3000);
		List<WebElement> allText = driver.findElements(By.xpath("//div[@class='wM6W7d']/span"));
		
		for(WebElement text:allText) {
			System.out.println(text.getText());
			String t1 = text.getText();
			if(t1.equalsIgnoreCase("javascript")) {
				text.click();
				break;
			}
		}
	}
}
