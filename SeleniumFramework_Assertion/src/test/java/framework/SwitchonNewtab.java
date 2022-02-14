package framework;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwitchonNewtab {
	WebDriver driver;
	String url= "http://openclinic.sourceforge.net/openclinic/home/index.php";
	
	@BeforeTest
	   public void Browser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pawar.nagesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		}
	@Test
	public void first() {

	String parent = driver.getWindowHandle();
	System.out.println("Parent window id is: "+parent);

	driver.findElement(By.linkText("Medical Records")).click();
	Set<String> allWindows = driver.getWindowHandles();
	int count= allWindows.size();
	System.out.println("Total window" +count);

	for(String child:allWindows ) {
	if(!parent.equalsIgnoreCase(child)) {
	driver.switchTo().window(child);
	}
	}
	}

	@Test(priority=0)
	public void Second() throws InterruptedException {
	driver.findElement(By.xpath("//h2[@class='icon icon_search']/a[text()='Search Patient']")).click();
	Thread.sleep(10000);

	Select drpField = new Select(driver.findElement(By.xpath("//select[@id='search_type'][1]")));
	drpField.selectByVisibleText("First Name");
	driver.findElement(By.id("search_patient")).click();

	}
	 @AfterTest
		public void quit() {
		driver.quit();
		}

}
