package prac;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//https://www.youtube.com/watch?v=8DaPdlhDpBc

public class datadrivenfromexcel {
	WebDriver driver;

	@BeforeSuite

	public void launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@DataProvider
	public static Object[][] logindata() throws Exception {
		DataFormatter df = new DataFormatter();
		String fileloc = "C:\\Users\\govibg\\Desktop\\softskills\\eclipseworkspace\\BGG01\\dataproviderwithexcel.xlsx";
		FileInputStream fis = new FileInputStream(fileloc);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(0);
		int rowno = sheet.getPhysicalNumberOfRows();
		int colno = row.getPhysicalNumberOfCells();
		Object data[][] = new Object[rowno - 1][colno];
		for (int i = 0; i < rowno - 1; i++) {
			XSSFRow row1 = sheet.getRow(i + 1);
			for (int j = 0; j < colno; j++) {
				if (row1 == null) {
					data[i][j] = "";
				} else {
					XSSFCell cell = row1.getCell(j);
					if (cell == null) {
						data[i][j] = "";
					} else {
						String cellvalue = df.formatCellValue(cell);
						data[i][j] = cellvalue;
					}
				}

			}
		}

		return data;
	}

	@Test(dataProvider = "logindata")
	public void getData(String Email, String Password) {
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys(Password);
		driver.navigate().refresh();

	}

	
}
