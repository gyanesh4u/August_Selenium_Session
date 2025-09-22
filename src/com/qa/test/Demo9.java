package com.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo9 {
	 public static void main(String[] args) {
	      WebDriver driver=new ChromeDriver();
	      driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    List<WebElement> row=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[position()=4]/td"));
	    for(WebElement r:row){
	       
	          //i need to print Appium(Selenium) in the console and then price of appium
	    		          if(r.getText().contains("Appium")){
	    		        	  	    	  System.out.println(r.getText());
	    		        	  	    	  WebElement price=r.findElement(By.xpath("following-sibling::td[1]"));
	    		        	  	    	  System.out.println(price.getText());
	    		          }
	        }
	    }
}
