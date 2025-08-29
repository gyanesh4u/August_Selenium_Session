package com.qa.test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://demoqa.com/browser-windows");
		 driver.manage().window().maximize();
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 String parent = driver.getWindowHandle();//parent id
		 WebElement tabButton = driver.findElement(By.id("tabButton"));
		 js.executeScript("arguments[0].scrollIntoView(true)", tabButton);
	
		 tabButton.click();
		 Set<String> allWindow = driver.getWindowHandles();//all windows including parent & child
		 
		 for(String window:allWindow) {
			 if(!window.equals(parent)) {
				 driver.switchTo().window(window);
				 
				 System.out.println(driver.getCurrentUrl());
				 WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
				 System.out.println(sampleHeading.getText());
				 Thread.sleep(1000);
				 driver.close();
				 }
		 }
		 driver.switchTo().window(parent);
		 System.out.println(driver.getCurrentUrl());
		 
		 WebElement windowButton = driver.findElement(By.id("windowButton"));
		 js.executeScript("arguments[0].scrollIntoView(true)", windowButton);
		 windowButton.click();
		 Set<String> allTab = driver.getWindowHandles();
		 for(String tab:allTab) {
			 if(!tab.equals(parent)) {
				 driver.switchTo().window(tab);
				 System.out.println(driver.getCurrentUrl());
				 driver.quit();
			 }
		 }
		
	}
}
