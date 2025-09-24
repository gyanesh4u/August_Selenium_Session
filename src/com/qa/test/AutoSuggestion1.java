package com.qa.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion1 {

public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("autocomplete")).sendKeys("In");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> allElements = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		for(WebElement element:allElements) {
			System.out.println(element.getText());
			
			if(element.getText().equals("India")) {
				element.click();
			}
		}
		
		
}
}
