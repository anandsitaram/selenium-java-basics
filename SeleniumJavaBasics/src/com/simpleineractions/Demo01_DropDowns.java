package com.simpleineractions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo01_DropDowns {

	public static void main(String... args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).submit();
		
		driver.findElement(By.id("menu_time_viewTimeModule")).click();
		
		
		WebElement basicSelect=driver.findElement(By.id("time_startingDays"));
	
		Select select = new Select(basicSelect);
		
		System.out.println("----All options------");
		select.getOptions().forEach(a->System.out.println(a.getText()));
		System.out.println("-----------");
		System.out.println("is Multiple :- "+select.isMultiple());
		System.out.println("1.Selected option is - "+select.getFirstSelectedOption().getText());
		select.selectByIndex(1);
		System.out.println("2.Selected option is - "+select.getFirstSelectedOption().getText());
        select.selectByValue("4");
		System.out.println("3.Selected option is - "+select.getFirstSelectedOption().getText());
		select.selectByVisibleText("Saturday");
		System.out.println("4.Selected option is - "+select.getFirstSelectedOption().getText());
		
		//You  can deselect options of a multi-select
		
		driver.navigate().to("https://www.jqueryscript.net/demo/Two-side-Multi-Select-Plugin-with-jQuery-multiselect-js/");
		WebElement multiSelect=driver.findElement(By.id("undo_redo"));
		
		select = new Select(multiSelect);
		System.out.println("is Multiple :- "+select.isMultiple());
		System.out.println("----All options------");
		select.getOptions().forEach(a->System.out.println(a.getText()));
		System.out.println("-----------");
		System.out.println("all selected option count is "+select.getAllSelectedOptions().size());
		
		select.selectByIndex(1);
		System.out.println("5.Selected option is - "+select.getFirstSelectedOption().getText());
		select.deselectByIndex(1);
		System.out.println("all selected option count is "+select.getAllSelectedOptions().size());
		select.selectByValue("5");
		select.selectByVisibleText("Haskell");
		System.out.println("----All Selected options------");
		select.getAllSelectedOptions().forEach(a->System.out.println(a.getText()));
		System.out.println("-------");
		select.deselectAll();
		System.out.println("all selected option count is "+select.getAllSelectedOptions().size());
		driver.quit();
	

	}
}
