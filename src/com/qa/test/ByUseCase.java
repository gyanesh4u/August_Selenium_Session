package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByUseCase {

	
	public static void main(String[] args)  {
		WebDriver driver=new ChromeDriver();
		driver.get("https://google.com");
		By searchBox=By.name("q");
		Util u=new Util(driver);
		u.doSendKeys(searchBox, "java");
		
		
		
	}
}
