package prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


//run testng.xml as testng suite

public class MultiBrowser_crossbrowser {

// link - https://www.toolsqa.com/testng/cross-browser-testing-using-testng/
//rightclick on the class in projectexplorer>testng>convert to testng>finnish>in projectexplorer 
	// at bottom under test-output testng.xml is found.
	// to see the error less xml clickon arrow of the test-output >search for
	// index.html >open with
	// web browser> click on some random text there like
	// "C:\Users\govibg\AppData\Local\-e-customsuite.xml"
	// udner info
	WebDriver driver;
	
	// in xml file for classname we need to give as packagename.classname
	// link - https://www.youtube.com/watch?v=5aPvncTAXGI
	// link - https://www.toolsqa.com/testng/cross-browser-testing-using-testng/

	@BeforeClass
	@Parameters("browser")
	public void browser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			System.out.println("no other .exe files");
			
		}
		driver.get("https://www.facebook.com");
	}

	@Test
	public void runtest() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();

	}

	@AfterClass
	public void closebrowser() {
		driver.quit();
	}
}
