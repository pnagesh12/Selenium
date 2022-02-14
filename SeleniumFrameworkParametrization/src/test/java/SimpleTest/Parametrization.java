package SimpleTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Parametrization {
	WebDriver driver;
	String url= "https://www.google.com";

   @DataProvider(name = "test-data")
	public Object[][] dataProvFunc(){
	return new Object[][]{
	{"Books"},{"Automation"}
	};
	}
   @BeforeTest
	public void setUp() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\pawar.nagesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(5000);
}
	//Passing the dataProvider to the test method through @Test annotation
	@Test(dataProvider ="test-data")
	public void search(String keyWord){
	WebElement txtBox = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
	txtBox.sendKeys(keyWord);
	Reporter.log("Keyword entered is : " +keyWord);
	txtBox.sendKeys(Keys.ENTER);
	Reporter.log("Search results are displayed.");
	}
  @AfterTest
	public void quit(){
	driver.quit();
	}
}
