package com.qa.test;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

	public class WhatsAppSpam {
		
		//WebElement sc;
	    public static void main(String[] args) throws InterruptedException {
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://web.whatsapp.com/");
	        
	        // Wait for you to scan QR code
	        Thread.sleep(20000);

	        // Open chat with a contact (replace with your friend's name as it appears in WhatsApp)
	        driver.findElement(By.xpath("//span[@title='Alok Kumar']")).click();
	        Thread.sleep(10000);
	        
	        String message = "Hi!";
	        for (int i = 0; i < 200; i++) {
	            driver.findElement(By.xpath("//div[@aria-label='Type to Alok Kumar']//p[@class='selectable-text copyable-text x15bjb6t x1n2onr6']")).sendKeys(message);
	            driver.findElement(By.xpath("//button[@aria-label='Send']")).click();
	            Thread.sleep(200); // small delay
	        }
	    }
	}


