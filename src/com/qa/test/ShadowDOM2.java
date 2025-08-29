package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOM2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		Thread.sleep(1000);
		SearchContext shadow0 = driver.findElement(By.cssSelector("#userName")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#app2")).getShadowRoot();
		Thread.sleep(1000);
		shadow1.findElement(By.cssSelector("#pizza")).sendKeys("pizza");
	}
}
/*
//This Element is inside 2 nested shadow DOM.
String cssSelectorForHost1 = "#userName";
String cssSelectorForHost2 = "#app2";
Thread.sleep(1000);
SearchContext shadow0 = driver.findElement(By.cssSelector("#userName")).getShadowRoot();
Thread.sleep(1000);
SearchContext shadow1 = shadow0.findElement(By.cssSelector("#app2")).getShadowRoot();
Thread.sleep(1000);
shadow1.findElement(By.cssSelector("#pizza"));*/