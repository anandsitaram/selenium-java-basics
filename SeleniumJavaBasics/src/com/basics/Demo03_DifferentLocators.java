package com.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo03_DifferentLocators {

	public static void main(String... args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/index.html");

		// class
		driver.findElement(By.className("icon-signin")).click();
		// id
		driver.findElement(By.id("user_login")).sendKeys("username");

		// name
		driver.findElement(By.name("user_password")).sendKeys("password");

		// css selector ->.classname(if there is a space add .)
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();

		System.out.println(driver.getTitle());
		
		driver.quit();

	}

}
