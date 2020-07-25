package com.complexineractions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo04_MultipleWindows {

	public static void main(String... args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("Top Gun");
		search.sendKeys(Keys.ENTER);
		System.out.println("Before Handling " + driver.getWindowHandles().size());
		driver.findElement(By.xpath("//span[text()='Top Gun']")).click();
		System.out.println("After Handling " + driver.getWindowHandles().size());
		Set<String> han = driver.getWindowHandles();

		// Approach 1 using iterator

		Iterator<String> iterator = han.iterator();

		String parentWindow = iterator.next();
		String childWindow = iterator.next();

		driver.switchTo().window(childWindow);
		Thread.sleep(2500);
		System.out.println("Approach 1 child window - " + driver.getTitle());
		driver.switchTo().window(parentWindow);
		System.out.println("Approach 1 parent window - " + driver.getTitle());

		// Approach 2 using List
		
		ArrayList<String> handles = new ArrayList<String>(han);
		driver.switchTo().window(handles.get(1));
		Thread.sleep(2500);
		System.out.println("Approach 2 child window - " + driver.getTitle());
		driver.switchTo().window(handles.get(0));
		System.out.println("Approach 2 parent window - " + driver.getTitle());
		
		driver.quit();

	}
}
