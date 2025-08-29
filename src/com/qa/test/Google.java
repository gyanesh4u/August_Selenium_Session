package com.qa.test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Google {

	public static void main(String[] args) {
		 
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.switchTo().activeElement().sendKeys("java");
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://google.com");
		
		
	}
}
