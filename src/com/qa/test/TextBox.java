package com.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demoqa.com/text-box");
		WebElement userName = driver.findElement(By.id("userName"));
		WebElement email = driver.findElement(By.id("userEmail"));
		WebElement currentAddress = driver.findElement(By.id("currentAddress"));
		WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
		WebElement submit = driver.findElement(By.id("submit"));
		userName.sendKeys("gyanesh");
		email.sendKeys("kamal.gyanesh8@gmail.com");
		currentAddress.sendKeys("abc -123");
		permanentAddress.sendKeys("abc-123");
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
		submit.click();
		List<WebElement> allText = driver.findElements(By.xpath("//div[@class='border col-md-12 col-sm-12']"));
		for(WebElement text:allText) {
			String t1 = text.getText();
			System.out.println(t1);
		}
	}
	
}
