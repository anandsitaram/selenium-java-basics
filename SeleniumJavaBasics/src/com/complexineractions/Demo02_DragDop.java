package com.complexineractions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo02_DragDop {

	public static void main(String... args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Actions actions = new Actions(driver);

		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));

		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));

		// Method 1
		actions.dragAndDrop(drag, drop).build().perform();
		System.out.println(drop.findElement(By.xpath("//div[@id='droppable']/p")).getText());

		driver.navigate().to("http://jqueryui.com/resources/demos/droppable/default.html");

		actions = new Actions(driver);
		drag = driver.findElement(By.xpath("//div[@id='draggable']"));

		drop = driver.findElement(By.xpath("//div[@id='droppable']"));

		// Method 2
		actions.clickAndHold(drag).pause(Duration.ofSeconds(3)).moveToElement(drop).release().build().perform();
		System.out.println(drop.findElement(By.xpath("//div[@id='droppable']/p")).getText());

		driver.quit();

	}
}
