package com.complexineractions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo01_MouseMovement {

	public static void main(String... args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
		Actions actions = new Actions(driver);
		//Mouse hover
		 Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("SpiceMAX")).click();
		System.out.println("Mouse Hover Title is "+driver.getTitle());
		
	    //Right click
		driver.navigate().to("http://swisnl.github.io/jQuery-contextMenu/demo/accesskeys.html");
	
		actions.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).build().perform();
		Thread.sleep(2000);
		WebElement cutEle=driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-cut']/span"));
		System.out.println(cutEle.getText());
		cutEle.click();
		System.out.println("Alert text -"+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.quit();

	}
}
