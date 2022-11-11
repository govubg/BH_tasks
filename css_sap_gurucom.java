package prac;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class css_sap_gurucom {
	//div [class='row featured-boxes']
	WebDriver driver;

	@BeforeSuite

	public void launch() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver();
	}
	@Test
	public void run() {
		driver.get("https://www.guru99.com/");
		
	//div[class='row featured-boxes'] div:nth-child(2) div:nth-child(1)
	//this above 26line will navigate to sap directly. but you will get output for "BIG DATA" also so
	//div[class='row featured-boxes'] div:nth-child(2) 
		List<WebElement> allHeader = driver
				.findElements(By.cssSelector("div[class='row featured-boxes'] div:nth-child(2) ul:nth-child(2)"));
		System.out.println(allHeader.size());

		for (WebElement element : allHeader) {
			String str = element.getText();
			System.out.println(str);
		}

	

		driver.close();
	}
}
//body > div:nth-child(10) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) 
//> main:nth-child(1) > div:nth-child(1) > article:nth-child(1) > div:nth-child(1)
//> div:nth-child(1) > div:nth-child(6) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(2)
//this above can select only sap .