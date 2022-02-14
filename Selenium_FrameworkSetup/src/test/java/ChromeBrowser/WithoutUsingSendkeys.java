package ChromeBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WithoutUsingSendkeys {
	WebDriver driver;
	String url= "https://www.google.com";

	@BeforeTest
   public void browser() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\pawar.nagesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(5000);
	}
  @Test
  public void withoutsendkeys() {
	  JavascriptExecutor JS = (JavascriptExecutor)driver;
	  JS.executeScript("document.getElementsByName('q').value='BOOKS'");
	  }
  
    @AfterTest
	  public void close() {
	  driver.close();
	  }

}
