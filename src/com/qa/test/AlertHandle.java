package com.qa.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandle {

	static WebDriver driver;
	static Actions act;
	public static void main(String[] args) {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		Util u=new Util(driver);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement alertButton = driver.findElement(By.id("alertButton"));
		act=new Actions(driver);
		act.pause(10000);
		act.scrollToElement(alertButton).perform();
		act.pause(20000).perform();
		 js.executeScript("arguments[0].scrollIntoView(true);", alertButton);
		alertButton.click();
		System.out.println(u.getAlertText());
		//Alert alert=driver.switchTo().alert();
		//System.out.println(alert.getText());
		u.acceptAlert();
		//alert.accept();
		WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		act.scrollToElement(timerAlertButton).perform();
		 js.executeScript("arguments[0].scrollIntoView(true);", timerAlertButton);
		timerAlertButton.click();
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(u.getAlertText());
		u.acceptAlert();
		//alert.accept();
		
		WebElement promtButton = driver.findElement(By.id("promtButton"));
		act.scrollToElement(promtButton).perform();
		act.pause(20000).perform();
		 js.executeScript("arguments[0].scrollIntoView(true);", promtButton);
		promtButton.click();
		//driver.switchTo().alert();
		u.sendKeysOnAlert("abcd");
		u.acceptAlert();
		//alert.sendKeys("abcd");
		//alert.accept();
	}
}
