package ChromeBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrokenLinks {
	public String url= "https://demoqa.com/broken";
	public WebDriver driver;

	@BeforeClass
	public void open() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\pawar.nagesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(5000);
	}
	@Test
	public void checkbrokenLink() throws InterruptedException {
	driver.findElement(By.linkText("Click Here for Valid Link")).click();
	Thread.sleep(10000);
	System.out.println(driver.getTitle());
    driver.navigate().to("https://demoqa.com/broken");
	Thread.sleep(5000);
    driver.findElement(By.xpath("//a[@href='http://the-internet.herokuapp.com/status_codes/500']")).click();
	Thread.sleep(10000);
	Boolean Display=driver.findElement(By.xpath("//div[@class='example']")).isDisplayed();
}
	
	
	@AfterClass
    public void afterTest() {
        driver.close();
    }
}
