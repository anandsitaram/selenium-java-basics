package synchronization;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo03_FluentWait {

	public static void main(String... args) {

		Instant start = Instant.now();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// fluent wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
		driver.manage().window().maximize();

		driver.get("https://app.hubspot.com/login");

		// 1
		wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				// TODO Auto-generated method stub
				return t.findElement(By.id("hs-login"));
			}

		});

		driver.findElement(By.id("username")).sendKeys("testwebclient191@gmail.com");
		driver.findElement(By.id("password")).sendKeys("TeSt@123");
		driver.findElement(By.id("loginBtn")).submit();

		// 2
		wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				// TODO Auto-generated method stub
				return t.findElement(By.xpath("//i18n-string[text()='Dashboard Library']"));
			}

		});
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.id("nav-primary-contacts-branch")).click();
		driver.findElement(By.id("nav-secondary-contacts")).click();
		// 3
		wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				// TODO Auto-generated method stub
				return t.findElement(By.xpath("//i18n-string[text()='Contacts']"));
			}

		});
		title = driver.getTitle();
		System.out.println(title);

		driver.findElement(By.id("account-menu")).click();
		driver.findElement(By.id("signout")).click();

		// 4
		wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				// TODO Auto-generated method stub
				return t.findElement(By.id("hs-login"));
			}

		});
		title = driver.getTitle();
		System.out.println(title);
		driver.quit();
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println(timeElapsed / 1000 + "s");
	}
}
