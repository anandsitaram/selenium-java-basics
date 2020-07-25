package com.complexineractions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo03_JavaScriptExecutorBasics {

	public static void waitForPageLoad(JavascriptExecutor js) {

		boolean flag = js.executeScript("return document.readyState;").toString().equals("complete");
		int count = 10;
		while (count!=0 && !flag) {
			try {

				Thread.sleep(1000);
				count = count--;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String... args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://classic.crmpro.com/");

		JavascriptExecutor js = (JavascriptExecutor) driver;

        // Example to find out screen height and width of the web page
		long height=(long) js.executeScript("return document.body.scrollHeight;");
		System.out.println(height);
		
		//Scroll down till last
		js.executeScript("window.scroll(0,"+height+")");
		
		//Wait for 5s
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length-1],5000)");
		
		//Scroll up
		js.executeScript("window.scroll(0,-"+height+")");
	
		
		WebElement userName = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));

		// Example for entering texts
		js.executeScript("arguments[0].value='batchautomation';", userName);
		js.executeScript("arguments[0].value='Test@12345';", password);
		WebElement click = driver.findElement(By.xpath("//input[@type='submit']"));

		// Example for clicking a button
		js.executeScript("arguments[0].click();", click);

		//Wait for page load
		waitForPageLoad(js);
		
		System.out.println("Title is " + driver.getTitle());
		driver.quit();

	}
}
