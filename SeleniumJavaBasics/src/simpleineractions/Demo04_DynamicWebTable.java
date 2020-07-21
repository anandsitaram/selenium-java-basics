package simpleineractions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo04_DynamicWebTable {

	public static void main(String... args) {
		Instant start = Instant.now();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://classic.freecrm.com/index.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[text()='Companies']")).click();
		String companyName = "Aa Anand Testing";
		
		//Method 1
		int totalRows = driver.findElements(By.xpath("//form[@id='vCompaniesForm']/table//tr")).size();
		System.out.println(driver.findElement(By.xpath("//form[@id='vCompaniesForm']/table//tr[9]/td[2]/a")).getText());
		String xpath1 = "//form[@id='vCompaniesForm']/table//tr[";
		String xpath2 = "]/td[2]/a";

		for (int i = 5; i < totalRows; i++) {

			String actualComapnies = driver.findElement(By.xpath(xpath1 + i + xpath2)).getText();
			if (actualComapnies.equals(companyName)) {
				driver.findElement(By.xpath(xpath1 + i + "]/td[1]/input")).click();
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(src, new File("./src/simpleineractions/Demo04_DynamicWebTable_Method1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			}

		}

		// Method2 - > Preferred approach in case of perfomance 
		driver.findElement(By.xpath("//a[contains(text(),'" + companyName
				+ "')]/parent::td/preceding-sibling::td/input[@name='client_id']")).click();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./src/simpleineractions/Demo04_DynamicWebTable_Method2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println(timeElapsed / 1000 + "s");

	}
}
