package com.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectOptions {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		WebElement allOptions = driver.findElement(By.id("dropdown-class-example"));
		Select select=new Select(allOptions);
		List<WebElement> options = select.getOptions();
		for(WebElement op:options) {
			if(op.getText().equals("Option3")) {
				op.click();
				break;
			}
		}
	}
}
