package com.simpleineractions;

import java.time.Duration;
import java.time.Instant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo04_Iframe {

	public static void main(String... args) {
		
		Instant start = Instant.now();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
		driver.get("https://www.rediff.com/");
		System.out.println(driver.findElement(By.xpath("//div[@id='topdiv_0']//h2[@class='news'][1]/a")).getText());
		
		//Switch to frame using index
		driver.switchTo().frame(0);
		System.out.println(driver.findElement(By.xpath("//span[@id='bseindex']")).getText());
		//Switch back to parent html
		driver.switchTo().parentFrame();
		System.out.println(driver.findElement(By.xpath("//div[@id='topdiv_0']//h2[@class='news'][2]/a")).getText());
		
		//Switch to frame using frame name or id
		driver.switchTo().frame("moneyiframe");
		System.out.println(driver.findElement(By.xpath("//span[@id='nseindex']")).getText());
		//Switch back to parent html
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath("//div[@id='topdiv_0']//h2[@class='news'][3]/a")).getText());
		
		//Switch to frame using frame webelement
		driver.switchTo().frame(driver.findElement(By.id("moneyiframe")));
		System.out.println(driver.findElement(By.xpath("//span[@id='NseChange']")).getText());
		//Switch back to parent html
		driver.switchTo().defaultContent();
		driver.quit();
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println(timeElapsed / 1000 + "s");

	}
}
