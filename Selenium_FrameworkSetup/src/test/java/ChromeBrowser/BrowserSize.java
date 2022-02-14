package ChromeBrowser;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrowserSize {
	WebDriver driver;
	String url= "https://www.google.com";
	
	@BeforeClass
	public void beforeclass() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\pawar.nagesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(5000);
	}
    @Test
	public void BrowserWindowZSize() {
	Dimension dim= driver.manage().window().getSize();
	System.out.println("size of the browser:" + dim);
	}
   @AfterClass
	public void close() {
	driver.close();
	}

}
