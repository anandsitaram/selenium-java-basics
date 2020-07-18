package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo01_FirstScript {

	public static void main(String... args) {

		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/playlist?list=PL6flErFppaj2ArNxLyR4nQ4JV8qFc56-M");
		driver.findElements(By.id("video-title")).forEach(a->System.out.println(a.getText()));
		driver.quit();

	}

}
