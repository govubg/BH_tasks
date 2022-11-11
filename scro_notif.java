package prac;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scro_notif {
	public WebDriver driver;

	@BeforeClass

	public void before() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions set = new ChromeOptions();
		driver = new ChromeDriver(set);
		driver.manage().window().maximize();
		set.addArguments("--disable-notifications");
		set.addArguments("--disable-geolocation");
		
	}

	@Test(priority = 1)

	public void testscroll() {
		driver.get("https://www.pizzahut.co.in/order/pizzas/");

		// using action class scroll is not working, so used javascript
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_UP).build().perform();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// chromeoptions disable locations not worked so

		HashMap<String, Integer> refvar = new HashMap<String, Integer>();
		refvar.put("geolocation", 2);
		refvar.put("notification", 2);

		// o means always ask, 1 measn accept, 2 disable
	}

	@Test(priority = 2)
	public void windowhandal() {
		driver.get("https://www.trip.com/flights/?allianceid=1273644&sid=3460485&ouid=8a915518bb6ab667f6c84a2d37169e9a");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.cssSelector("#main > div.online-prepermission-popup.show > div.content-con > div.popup-btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		HashMap<String, Integer> refvar = new HashMap<String, Integer>();
		refvar.put("notification", 2);
		//driver.findElement(By.cssSelector("#main > div.mc-hd mc-hd__en-xx > div.mc-hd__inner > div.mc-hd__flex-con > div.mc-hd__logo-con mc-hd__logo-con-en-XX mc-hd__logo-layout-0 > a.mc-hd__logo mc-hd__logo-en-xx")).click();
	}
	@AfterClass
	public void afclass(){
		driver.quit();
	}
}
