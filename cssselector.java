package BH;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class cssselector {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://demo.actitime.com//login.do");
		Thread.sleep(2000);
		WebElement untb = driver.findElement(By.cssSelector("input[placeholder='Username']"));
		untb.sendKeys("admin");

		Thread.sleep(2000);

		WebElement pwtb = driver.findElement(By.cssSelector("input[placeholder='Password']"));
		pwtb.sendKeys("manager");

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("a[class='initial']")).click();
//  ul[id="java_technologies"]
	}

	}

