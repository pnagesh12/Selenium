package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assertion {
	WebDriver driver;
	String url= "http://www.Google.com";

	
	
	@BeforeTest
	public void BeforeTest() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\pawar.nagesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(5000);
	}

	@Test
	public void verifyTitleTrue()
	{

	String ActualTitle = driver.getTitle();


	String ExpectedTitle = "Google";
	Assert.assertEquals(ActualTitle, ExpectedTitle);
	System.out.println("Assert pass");
	}

	@Test(priority=0)

	public void verifyTitlefalse() {
	String ActualTitle = driver.getTitle();
    String ExpectedTitle = "Amazon.com.";
	Assert.assertNotEquals(ActualTitle, ExpectedTitle);
	System.out.println("Assert Fail");
	}



	@AfterTest
	public void closedriver(){

	//closes the browser instance
	driver.close();

	}
}
