package prac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class diff_alertpopup {
	WebDriver driver;

	@BeforeSuite
	
	
     // testng anoutations link -
	// https://www.browserstack.com/guide/testng-annotations-in-selenium
	
	
	public void launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test(priority = 1)
	public void handlefirstalert() {
		System.out.println("alerts is runing");
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		System.out.println("first alert");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("result")).getText());
		System.out.println("second alert");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.id("result")).getText());
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("result")).getText());
		System.out.println("third alert");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
		driver.switchTo().alert().sendKeys("govu");
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("result")).getText());
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.id("result")).getText());
	}

	@Test(priority = -1)
	protected void basicauthon() {
		String url = "the-internet.herokuapp.com/basic_auth";
		String username = "admin";
		String password = "admin";
		// driver.get(url+username+password);
		System.out.println("basicauth is runing");
		driver.get("https://" + username + ":" + password + "@" + url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println(driver.findElement(By.xpath("//*[@class=\"row\"]/div/div/p")).getText());
	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}
