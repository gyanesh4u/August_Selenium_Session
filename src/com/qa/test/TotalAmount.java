package com.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalAmount {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement table = driver.findElement(By.xpath("(//table[@id='product'])[2]"));
		js.executeScript("arguments[0].scrollIntoView();", table);
		 List<WebElement> allTr = driver.findElements(By.xpath("(//table[@id='product'])[2]/child::tbody/tr"));
		 int sum=0;
//		 for(WebElement tr : allTr) {
//			 System.out.println(tr.getText());
//		 }
		 List<WebElement> allEle = driver.findElements(By.xpath("(//table[@id='product'])[2]/child::tbody/tr/td[4]"));
		 
		 for(int i=0;i<allEle.size();i++) {
			 //String amount = driver.findElement(By.xpath("(//table[@id='product'])[2]/child::tbody/tr/td[4]")).getText();
			 String amount = allEle.get(i).getText();
			 System.out.println(amount);
			 sum=sum+Integer.parseInt(amount);
		 }
		 System.out.println("Total Amount: "+sum);
	}
}
