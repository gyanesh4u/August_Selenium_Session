package com.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		List<WebElement> allTb = driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label/input"));
		for(WebElement tb:allTb) {
			if(!tb.isSelected()) {
				tb.click();
				Thread.sleep(1000);
			}
			
			
		}
	}
}
