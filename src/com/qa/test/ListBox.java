package com.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListBox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/r.php?entry_point=login");
		WebElement month = driver.findElement(By.id("month"));
		Select select=new Select(month);
		select.selectByVisibleText("Dec");
		
		Util u=new Util(driver);
		u.selectLisbox(month, "May");
		Thread.sleep(3000);
		select.selectByValue("1");
		Thread.sleep(3000);
		select.selectByIndex(2);
		List<WebElement> allDay = driver.findElements(By.xpath("//select[@id='day']/option"));
		for(WebElement day:allDay) {
			System.out.println(day.getDomAttribute("value"));
			if(day.getText().equals("30")) {
				day.click();
				break;
			}
		}
	}
}
