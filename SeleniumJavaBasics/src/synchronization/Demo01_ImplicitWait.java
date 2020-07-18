package synchronization;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo01_ImplicitWait {

	public static void main(String... args) {

		Instant start = Instant.now();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		/*driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("samusung");
		search.sendKeys(Keys.ENTER);
		List<WebElement> results = driver.findElements(By.xpath("//a/span"));
		for (WebElement webElement : results) {
			if (webElement.getText().contains("Samsung Galaxy M21 (Raven Black, 6GB RAM, 128GB Storage)")) {
				webElement.click();
				break;
			}

		}
		Set<String> handles = driver.getWindowHandles();
		List<String> as = new ArrayList<>(handles);
		driver.switchTo().window(as.get(1));
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.id("priceblock_dealprice")).getText());
		driver.findElement(By.id("buy-now-button")).click();
		System.out.println(driver.getTitle());*/
		driver.manage().window().maximize();
		
		driver.get("https://app.hubspot.com/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("testwebclient191@gmail.com");
		driver.findElement(By.id("password")).sendKeys("TeSt@123");
		driver.findElement(By.id("loginBtn")).submit();
		String title=driver.getTitle();
		System.out.println(title);
		driver.findElement(By.id("nav-primary-reports-branch")).click();
		driver.findElement(By.id("nav-secondary-analytics-tools")).click();
		driver.findElement(By.id("account-menu")).click();
		driver.findElement(By.id("signout")).click();
		driver.getTitle();
		System.out.println(title);
		driver.quit();
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println(timeElapsed / 1000+"s");

	}
}
