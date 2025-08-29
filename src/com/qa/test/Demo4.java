package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo4 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/buttons");
		driver.manage().window().maximize();
		WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
		//doubleClick.click();
		Actions action=new Actions(driver);
		action.doubleClick(doubleClick).perform();
		WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
		action.contextClick(rightClick).perform();
		
	}
}
