package prac;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToFrames {
    @Test
    public void FrameSwitchVerify() throws IOException{
        //Instantiation of the Chrome Browser
        WebDriverManager.chromedriver().setup();
        //Set the behaviour of the chrome browser
        ChromeOptions options = new ChromeOptions();
        //Settings for the Headless browser
        options.addArguments("--headless");
        //Opening the chrome browser
        WebDriver driver = new ChromeDriver(options);
        //Maximizing the window
        driver.manage().window().maximize();
        //Navigate the html page
        driver.get("file:C:\\Users\\govibg\\Desktop\\softskills\\eclipseworkspace/htmlpagefordemo.html");
        //Method to take Screenshot
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //File path to save the screenshot
        FileUtils.copyFile(src, new File("C:\\Users\\govibg\\Desktop\\softskills\\eclipseworkspace\\BGG01\\target\\FramesScreenshot.png"));
        //Implicite wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Switching to the first frame by name
        driver.switchTo().frame("opencart");
        //Search for the phones
        driver.findElement(By.name("search")).sendKeys("phones",Keys.ENTER);
        //Switch back to default page
       
        driver.switchTo().defaultContent();
        //Switch to the second frame by name
        driver.switchTo().frame("seleniumWeb");
        //Clicks on the downloads
        driver.findElement(By.xpath("//span[.='Downloads']")).click();
        //validating the Downloads Page
        Assert.assertEquals("Downloads",driver.findElement(By.xpath("//h1[.='Downloads']")).getText());
        //closing the browser
        driver.quit();
    }
}
