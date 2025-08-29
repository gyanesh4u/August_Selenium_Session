package com.qa.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendKeys {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
		WebElement searchBox = driver.findElement(By.name("q"));
		//driver.switchTo().activeElement().sendKeys("java");
		Actions act=new Actions(driver);
		act.sendKeys(searchBox, "java").perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
		act.click(searchBtn).perform();
		//searchBtn.click();
	
	}
}
