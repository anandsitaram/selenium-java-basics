package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo02_DifferentBrowsers {

	public static void main(String... args) {

		WebDriverManager.firefoxdriver();
		// System.setProperty("webdriver.gecko.driver","./GeckoDriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://reminderbot.io/");
		System.out.println("Title is " + driver.getTitle());
		System.out.println("Current url is " + driver.getCurrentUrl());
		driver.quit();
		
		WebDriverManager.edgedriver();
		// System.setProperty("webdriver.edge.driver", "./MicrosoftWebDriver.exe");

		 driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://reminderbot.io/");
		System.out.println("Title is " + driver.getTitle());
		System.out.println("Current url is " + driver.getCurrentUrl());
		driver.quit();
		
	
		
		

	}

}
