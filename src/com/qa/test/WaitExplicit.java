package com.qa.test;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitExplicit {

	public static void main(String[] args) {
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://google.com");
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		 WebElement search = driver.findElement(By.name("z"));
		 
		 
		 wait.until(ExpectedConditions.visibilityOf(search));
		 search.sendKeys("java");
		 wait.pollingEvery(Duration.ofSeconds(10))
		 .ignoring(NoSuchElementException.class)
		 .withTimeout(Duration.ofSeconds(10));
	}
}
