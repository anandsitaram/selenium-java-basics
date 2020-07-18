package simpleineractions;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo02_BootstrapDropDowns {

	public static void main(String... args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Filterable-Bootstrap-Dropdown-Select-Bootstrap-Select/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement web = driver.findElement(By.id("bts-ex-1"));
		web.click();
		try {
		System.out.println(web.findElement(By.xpath("//span[@class='text']")).getText());
		}
		catch(NoSuchElementException ex) {
			System.out.println("No element is selected");
		}
		List<WebElement> sel = web.findElements(By.className("items"));
		for(WebElement we:sel) {
			if(we.getText().equals("Item 4")) {
				we.click();
				break;
			}
		}
		
		System.out.println(web.findElement(By.xpath("//span[@class='text']")).getText());
		
		driver.quit();
	

	}
}
