package framework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TakeScreenshort {
	WebDriver driver;
	String url= "https://api.jquery.com/dblclick/";

	@BeforeTest
   public void Browser() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\pawar.nagesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(5000);
	}
	
	
	@Test
	public void screenshot(String fileName) throws IOException {
	//Take the screenshot

	File source_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source_file, new File("C:\\Users\\pawar.nagesh\\eclipse-workspace\\SeleniumFramework_Assertion\\src\\test\\java\\Assert"+fileName+".jpg"));



	}
	@Test(priority=0)
	private void takeScreenshot(String string) {
	takeScreenshot("Facebook_loginpage");

	}



	@AfterTest
	public void terminate() {
	driver.quit();
	}
	
}
