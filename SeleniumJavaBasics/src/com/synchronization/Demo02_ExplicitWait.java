package com.synchronization;

import java.time.Duration;
import java.time.Instant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo02_ExplicitWait {

	public static void main(String... args) {

		Instant start = Instant.now();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 35);
		//By default polling time is 250ms, you can change the value
	    wait.pollingEvery(Duration.ofMillis(200));
	    
		driver.manage().window().maximize();
		driver.get("https://app.hubspot.com/login");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hs-login")));
		driver.findElement(By.id("username")).sendKeys("testwebclient191@gmail.com");
		driver.findElement(By.id("password")).sendKeys("TeSt@123");
		driver.findElement(By.id("loginBtn")).submit();
		
		//1
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i18n-string[text()='Dashboard Library']")));
		String title=driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.id("nav-primary-contacts-branch")).click();
		driver.findElement(By.id("nav-secondary-contacts")).click();
		
		//2
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i18n-string[text()='Contacts']")));
		title=driver.getTitle();
		System.out.println(title);

		driver.findElement(By.id("account-menu")).click();
		driver.findElement(By.id("signout")).click();
		
		//3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hs-login")));
		title=driver.getTitle();
		System.out.println(title);
		driver.quit();
		
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println(timeElapsed / 1000+"s");
	}
}
