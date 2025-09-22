package com.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calander {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement date = driver.findElement(By.xpath("//i[@class='icon___0039d4 icon icon-date_range']"));
		date.click();
		WebElement monthYear = driver.findElement(By.xpath("//p[@class='monthYear___2b924f']"));
		List<WebElement> allDate = driver.findElements(By.xpath("//ul[@aria-label='September 2025 calendar']/li"));
		System.out.println(allDate.size());
		//js.executeScript("arguments[0].scrollIntoView(true)", date);
		//date.sendKeys("10/10/2023");
		js.executeScript("arguments[0].value='18/09/2025'", monthYear);
		
	}
}
