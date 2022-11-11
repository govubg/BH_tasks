package prac;

import java.awt.Window;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v100.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alert {
	@Test
	public void alerthandel() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");

		String parentwindow = driver.getWindowHandle();
		driver.findElement(By.id("tabButton")).click();
		Set<String> childwindow = driver.getWindowHandles();
		for (String ele : childwindow) {
			if (!ele.equals(parentwindow)) {
				driver.switchTo().window(ele);
				String msg = driver.findElement(By.id("sampleHeading")).getText();
				System.out.println(msg);
				System.out.println(ele);

				driver.close();
			}

		}
		driver.switchTo().window(parentwindow);
		driver.findElement(By.id("windowButton")).click();
		Set<String> childwindow1 = driver.getWindowHandles();
		for (String ele : childwindow1) {
			if (!ele.equals(parentwindow)) {
				driver.switchTo().window(ele);
				String msg = driver.findElement(By.id("sampleHeading")).getText();
				System.out.println(msg);
				System.out.println(ele);

				driver.close();
				driver.switchTo().window(parentwindow);
			}

		}
		driver.findElement(By.id("windowButton")).click();
		Set<String> childwindow2 = driver.getWindowHandles();
		for (String ele : childwindow2) {
			if (!ele.equals(parentwindow)) {
				driver.switchTo().window(ele);
				String msg = driver.getTitle();
				System.out.println(msg);
				System.out.println(ele);

				driver.close();
			}
			driver.switchTo().window(parentwindow);
			driver.quit();
		}
	}
}
