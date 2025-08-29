package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DragAndDrop {
static WebDriver driver;
	public static void main(String[] args) {
		 driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html5_draganddrop.asp");
		//WebElement source = driver.findElement(By.xpath("//div[@id='div1']"));
		//WebElement target = driver.findElement(By.xpath("//div[@id='div2']"));
		Util u=new Util(driver);
		WebElement source = u.getElement(By.xpath("//div[@id='div1']"));
		WebElement target = u.getElement(By.xpath("//div[@id='div2']"));
		u.dragAndDrop(driver, source, target);
		//actions.dragAndDrop(target, source).perform();
	}
}
