package simpleineractions;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo03_WebTable {

	public WebDriver driver;

	public Demo03_WebTable(WebDriver driver) {

		this.driver = driver;

	}

	
	public int getHeader(List<WebElement> rows, String header) {
		int index = 0;
		/*
		for (WebElement row : rows) {

			List<WebElement> headers = row.findElements(By.tagName("th"));
			for (int i = 0; i < headers.size(); i++) {
				if (headers.get(i).getText().equals("Start date")) {
					index = i;
					break;
				}
			}

		}
		
		*/
		//Header will also be the first row so hardcoding index value
		List<WebElement> headers = rows.get(0).findElements(By.tagName("th"));
		for (int i = 0; i < headers.size(); i++) {
			if (headers.get(i).getText().equals("Start date")) {
				index = i;
				break;
			}
		}
		return index;

	}

	public void getAllRowColumns(List<WebElement> rows) {
		/*for (WebElement row : rows) {

			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				System.out.println(col.getText());
			}

		}*/
		
		//Java 8
		rows.forEach(r->r.findElements(By.tagName("td")).forEach(c->System.out.println(c.getText())));

	}

	public void getRowTexts(List<WebElement> rows ,int index) {

	System.out.println(rows.get(index).getText());
		
	}

	public void getColumnTexts(List<WebElement> rows, String header) {
		int index = getHeader(rows, header);
		
		
		for (WebElement row : rows) {

			List<WebElement> cols = row.findElements(By.tagName("td"));
			if (cols.size() > 0) {
				System.out.println(cols.get(index).getText());

			}

		}

	}

	public String getCellText(List<WebElement> rows , int rowIndex,int colIndex) {
		
		List<WebElement> cols = rows.get(rowIndex).findElements(By.tagName("td"));
		return cols.get(colIndex).getText();
		
		

	}

	public static void main(String... args) {
		Instant start = Instant.now();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		WebElement table = driver.findElement(By.id("example"));

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		Demo03_WebTable webtable = new Demo03_WebTable(driver);
		System.out.println("---All rows and columns text ---------");
		webtable.getAllRowColumns(rows);

		System.out.println("----------------------------------------");
		webtable.getColumnTexts(rows, "Start date");
		System.out.println("----------------------------------------");
		webtable.getRowTexts(rows, 2);
		System.out.println("----------------------------------------");
		System.out.println(webtable.getCellText(rows, 5,3));
		driver.quit();
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println(timeElapsed / 1000+"s");

	}
}
