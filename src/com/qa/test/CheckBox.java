package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/checkbox");
		WebElement home = driver.findElement(By.xpath("//span[@class='rct-checkbox']"));
		home.click();
		System.out.println(home.isSelected());
		
		Util util=new Util(driver);
		System.out.println(util.title());
		System.out.println(util.getURL(driver));
		//driver.quit();
	}
}
