package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo01_FirstScript {

	public static void main(String... args) {

		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://reminderbot.io/");
		System.out.println("Title is " + driver.getTitle());
		System.out.println("Current url is " + driver.getCurrentUrl());
		driver.quit();

	}

}
