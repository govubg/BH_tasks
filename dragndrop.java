package prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dragndrop {
	WebDriver driver;

	@BeforeSuite
	public void launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
	}

	@Test
	public void testsuite() throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		WebElement drop = driver.findElement(By.id("droppable"));

		Actions a = new Actions(driver);
		Thread.sleep(5000);
		Action dragAndDrop = a.clickAndHold(drag).moveToElement(drop).release(drop).build();
		dragAndDrop.perform();
		Thread.sleep(5000);
	}

	@AfterSuite
	public void close() {
		driver.quit();
	}
}
