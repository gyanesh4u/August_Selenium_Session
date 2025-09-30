package com.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table1 {

	public static void main(String[] args) {
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 List<WebElement> fourthRow = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[4]"));
		 for(WebElement ele:fourthRow) {
			 System.out.println(ele.getText());
		 }
	}
}
