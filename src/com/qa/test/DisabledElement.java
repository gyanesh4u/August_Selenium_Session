package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisabledElement {
static WebDriver driver;
	static {
		 driver=new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
	}
	public static void main(String[] args) {
		
		WebElement fName = driver.findElement(By.xpath("//input[contains(@placeholder,'First Enter name')]"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='gyanesh';", fName);
	}
	
}
