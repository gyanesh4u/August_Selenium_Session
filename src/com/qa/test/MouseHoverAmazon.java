package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MouseHoverAmazon {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		WebElement accounts = driver.findElement(By.xpath("//div[@id='nav-link-accountList']"));
		Util u=new Util(driver);
		u.mouseHover(driver, accounts);
		System.out.println(u.getURL(driver));
	}
}
