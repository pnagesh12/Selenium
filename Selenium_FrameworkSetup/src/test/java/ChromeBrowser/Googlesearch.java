package ChromeBrowser;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Googlesearch {
	public String url= "https://Google.com/";
	public WebDriver driver;

	@BeforeClass
	public void demo() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\pawar.nagesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(5000);

}
	@Test
	public void search() throws InterruptedException {

	driver.findElement(By.name("q")).sendKeys("Books");
	Thread.sleep(5000);
	List<WebElement> webElement= driver.findElements(By.xpath("//div[text()='Horse Before Cart, Readers Before Books']"));
	for(int i=0; i<webElement.size(); i++) {
	String value = webElement.get(i).getText();
	if(value.contains("Book"))
	{
	Thread.sleep(5000);
	webElement.get(i).click();
	break;
	}
}
	}
	@AfterClass
	public void close() {
		driver.quit();
		
	}

	
}
