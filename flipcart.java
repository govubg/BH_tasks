package prac;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipcart {
	
	     WebDriver driver;



	   public void main(String[] args) throws  IOException {
	        // Configure the driver
	        WebDriverManager.chromedriver().setup();


	       // Launch the browser
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        
	        // To get specific url
	        driver.get("https://www.flipkart.com/");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));



	       WebElement email = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
	        email.sendKeys("8879351441");



	       WebElement password = driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']"));
	        password.sendKeys("CloudComputing@980");



	       WebElement loginBtn = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']"));
	        loginBtn.click();



	       // verifying that user is logged in successfully
	        String actual = "Ashreen";
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	        WebElement userTxt = driver.findElement(By.xpath("(//div[@class='_1psGvi _3BvnxG']//child::div)[2]"));
	        
	        System.out.println(userTxt.getText());
	        if (userTxt.isDisplayed()) {
	            String expected = userTxt.getText();
	            if (actual.equalsIgnoreCase(expected)) {
	                System.out.println("Logged in Successfully");
	                getScreenshot("LoggedIn Successfully");
	            } else {
	                System.out.println("Login Failed");
	                getScreenshot("Login Failed");
	            }
	        }
	    }



	   public void getScreenshot(String fileName) throws IOException {
	        // Typecast
	        TakesScreenshot tk = (TakesScreenshot) driver;
	        File src = tk.getScreenshotAs(OutputType.FILE);// div[@class='exehdJ']



	       File des = new File("C:\\Users\\ashrkhan\\eclipse-workspace\\TrancedPgm\\Screenshot\\" + fileName+".png");



	       // copy file from source to destination
	        FileUtils.copyFile(src, des);
	    }



	
}
