package com.qa.test;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebElement men = driver.findElement(By.xpath("//a[.='Men']"));
		Actions act = new Actions(driver);
		act.moveToElement(men).perform();
		driver.findElement(By.xpath("//a[.='Jackets']")).click();
		driver.findElement(By.xpath("//picture[@class='img-responsive']")).click();
		driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
		System.out.println(driver.getTitle());
	}
}
