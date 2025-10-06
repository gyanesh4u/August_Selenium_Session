package com.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/r.php?entry_point=login");
		driver.manage().window().maximize();
		List<WebElement> month = driver.findElements(By.xpath("//select[@aria-label='Month']/option"));
		
		for(int i=0; i<month.size(); i++) {
			String monthName = month.get(i).getText();
			System.out.println(monthName);
			if(monthName.equals("May")) {
				month.get(i).click();
				break;
			}
		}
		
	}
	
}
