package basics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo04_WebElements_Methods {

	public static void main(String... args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/index.html");
		driver.findElement(By.className("icon-signin")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.name("user_password")).sendKeys("password");
		File src = driver.findElement(By.name("user_password")).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./BeforeChange.png"));

		// clear()
		driver.findElement(By.name("user_password")).clear();

		// Screenshot of webelement
		src = driver.findElement(By.name("user_password")).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./AfterChange.png"));

		driver.findElement(By.name("user_password")).sendKeys("password");

		// submit()
		driver.findElement(By.cssSelector(".btn.btn-primary")).submit();

		System.out.println(driver.getTitle());
		driver.navigate().to("http://zero.webappsecurity.com/login.html");
		
		//forward()
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		//back()
		driver.navigate().back();
		
		//refresh()
		driver.navigate().refresh();
		System.out.println(driver.getTitle());
		
		driver.navigate().to("http://testdiary.com/training/selenium/selenium-test-page");
		System.out.println(driver.getTitle());
		//isSelected()
		WebElement checkBox=driver.findElement(By.id("seleniumbox"));
		System.out.println("Before checking "+checkBox.isSelected());
		checkBox.click();
		System.out.println("After checking "+checkBox.isSelected());
		
		//isDisplayed()
		System.out.println("isDisplayed() "+driver.findElement(By.id("demo")).isDisplayed());
		
		//getSize()
		Dimension dim = driver.findElement(By.id("selectTable")).getSize();
		System.out.println("Width- "+dim.getWidth());
		System.out.println("Height- "+dim.getHeight());
		
		//getTagName()
		System.out.println("Tag name is "+driver.findElement(By.id("restapibox")).getTagName());
		
		//getAttribute()
		System.out.println("Attribute is "+driver.findElement(By.id("restapibox")).getAttribute("checked"));
		

		
		driver.quit();

	}

}
