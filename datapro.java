package prac;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

// link - https://walkingtree.tech/data-driven-testing-with-selenium-apache-poi-and-testng/

public class datapro {
	WebDriver driver;

	@BeforeSuite

	public void launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
	}

	@Test(dataProvider = "getData")
	public void testSenchaLogin(String Username, String Password) throws InterruptedException {
		String parentwindow = driver.getWindowHandle();
		driver.findElement(By.id("email")).sendKeys(Username);
		driver.findElement(By.id("pass")).sendKeys(Password);
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(4000);
		Set<String> childwindow = driver.getWindowHandles();
		Thread.sleep(4000);
		for (String child : childwindow) {
			if (!child.equals(parentwindow)) {
				Thread.sleep(4000);
				driver.findElement(By.xpath("//*[@id=\"u_0_6_JU\"]/div/i")).click();
				driver.switchTo().window(parentwindow);
			}
		}

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "username1@gmail.com";
		data[0][1] = "pssword1";
		data[1][0] = "username3@gmail.com";
		data[1][1] = "password3";
		data[2][0] = "test@gmail.com";
		data[2][1] = "Testing";
		return data;
	}

/*   
	                           or
	 
	 
	 
	  @DataProvider(name = "Authentication")

  public static Object[][] credentials() {

        // The number of times data is repeated, test will be executed the same no. of times

        // Here it will execute two times

        return new Object[][] { 
        { "testuser_1", "Test@123" }, 
        { "testuser_1", "Test@123" }
        };

  }

  // Here we are calling the Data Provider object with its Name

  @Test(dataProvider = "Authentication")

  public void test(String sUsername, String sPassword) {

      driver = new FirefoxDriver();

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.get("https://www.store.demoqa.com");

      driver.findElement(By.xpath(".//*[@id='account']/a")).click();

      // Argument passed will be used here as String Variable

      driver.findElement(By.id("log")).sendKeys(sUsername);

      driver.findElement(By.id("pwd")).sendKeys(sPassword);

      driver.findElement(By.id("login")).click();

      driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

      driver.quit();

  }
	 
	 link- 
	 https://www.toolsqa.com/testng/testng-data-provider-excel/
	 
*/
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}
