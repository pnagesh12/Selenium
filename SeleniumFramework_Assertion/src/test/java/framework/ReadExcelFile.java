package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ReadExcelFile {
	WebDriver driver;
	String url="https://api.jquery.com/dblclick/";


	@BeforeTest
	public void BeforeTest() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\pawar.nagesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get(url);

	driver.manage().window().maximize();
	Thread.sleep(5000);
	}

	@Test
	public void excel() throws IOException {
	File src=new File("C:\\Users\\pawar.nagesh\\Excel.xlsx");
	FileInputStream fis= new FileInputStream(src);
    HSSFWorkbook wb= new HSSFWorkbook(fis);
	HSSFSheet sh1= wb.getSheetAt(0);
	String data0 = sh1.getRow(0).getCell(1).getStringCellValue();
	System.out.println("Data from Excel is "+data0);
	}


	@AfterTest
	public void quit() {
	driver.quit();
	}

}
