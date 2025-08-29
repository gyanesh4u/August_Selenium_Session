package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOM {

	public static void main(String[] args) {
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://practice.expandtesting.com/shadowdom");
		 WebElement shadowHost = driver.findElement(By.cssSelector("#shadow-host"));
		 SearchContext shadowRoot = shadowHost.getShadowRoot();
		 WebElement shadowButton = shadowRoot.findElement(By.cssSelector("#my-btn"));
		 System.out.println(shadowButton.getText());
		 
		 
	}
}
