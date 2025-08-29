package com.qa.test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo5 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");

        // Step 1: Click on the dropdown
        WebElement dropdown = driver.findElement(By.id("withOptGroup"));
        dropdown.click();

        // Step 2: Fetch all available options (they appear in the popup list)
        List<WebElement> options = driver.findElements(
            By.xpath("//div[@id='withOptGroup']/span")
        );

        System.out.println("Options found:");
        for (WebElement opt : options) {
            System.out.println(opt.getText());
        }

        // Step 3: Select "Group 1, option 1"
        for (WebElement opt : options) {
            if (opt.getText().equals("Group 1, option 1")) {
                opt.click();
                break;
            }
        }

        Thread.sleep(2000);
        driver.quit();
    }
}