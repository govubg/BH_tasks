package prac;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xpath_sap_gurucom {
	public static void main(String[] args) throws InterruptedException {

		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\GSETHY\\Downloads\\ChromeDriver 105\\chromedriver.exe");

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.guru99.com/");
		Thread.sleep(2000);
		
		
		//-----------------------------
		
		
		
		//List<WebElement> allHeader = driver
				//.findElements(By.xpath("//div/div[1]/div[2]/div[2]/div/ul/li/a[contains(@title,'SAP')]"));
		//div/div[1]/div[2]/div[2]/div/ul/li/a[contains(@title,'SAP') or contains(@title,'Crystal Reports')]
		
		
		//-----------------------------
		
		/*  List<WebElement> allHeader = driver
				.findElements(By.xpath("//div/div[1]/div[2]/div[2]/div/ul/li/a[contains(@title,'SAP') or contains(@title,'Crystal Reports')]"));
		System.out.println(allHeader.size());

		for (WebElement element : allHeader) {
			String str = element.getText();
			System.out.println(str);
		}

		// *[@id="java_technologies"]

		driver.close();
/*/
		//-----------------------------
		
		//div[@class='row featured-boxes']//div[2]//div[1]//ul[1]
		
		List<WebElement> allHeader = driver
				.findElements(By.xpath("//div[@class='row featured-boxes']//div[2]//div[1]//ul[1]"));
		System.out.println(allHeader.size());

		for (WebElement element : allHeader) {
			String str = element.getText();
			System.out.println(str);
		}
		driver.close();}
}
