package com.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radio {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		List<WebElement> allButton = driver.findElements(By.xpath("//legend[.='Radio Button Example']/../child::label/input"));
		for(WebElement button:allButton) {
			if(!button.isSelected()) {
				button.click();
				Thread.sleep(1000);
			}
		}
	}
}