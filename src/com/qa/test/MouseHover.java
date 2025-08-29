package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.geeksforgeeks.org/python/python-programming-language-tutorial/");
		Actions actions=new Actions(driver);
		WebElement courses = driver.findElement(By.xpath("//span[.='Courses']"));
		//actions.moveToElement(courses).perform();
		WebElement professional = driver.findElement(By.xpath("//span[.='For Working Professionals']"));
		WebElement interview = driver.findElement(By.xpath("//a[.='Interview 101: DSA & System Design']"));
		//actions.moveToElement(professional).perform();
		actions.moveToElement(courses)
		.pause(1000)
		.moveToElement(professional)
		.pause(1000)
		.moveToElement(interview).click().perform();
	}
}//double click,right click,mouse hover
