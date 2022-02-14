package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleAccountGetAttribute {
	WebDriver driver;
	String url= "https://accounts.google.com/signup";

	@BeforeTest
   public void Browser() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\pawar.nagesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(5000);
	}

  @Test(priority=0)
	public void Firstname() throws InterruptedException {
    WebElement firstName = driver.findElement(By.id("firstName"));
	firstName.sendKeys("Software");
	Thread.sleep(5000);
	String firstname = firstName.getAttribute("value");
	System.out.println("First Name: "+firstname);
	}
   @Test(priority=1)
	public void lastname() throws InterruptedException {
    WebElement lastName = driver.findElement(By.id("lastName"));
	lastName.sendKeys("testing");
	Thread.sleep(5000);
	String lastname = lastName.getAttribute("value");
	System.out.println("Last Name: "+lastname);
	}
	@Test(priority=2)
	public void username() throws InterruptedException {
	WebElement userName = driver.findElement(By.xpath("//*[@id=\"username\"]"));
	userName.sendKeys("Softwaretesting1234");
	Thread.sleep(5000);
	String username = userName.getAttribute("value");
	System.out.println("User Name: "+username);
	}
   @AfterTest
	public void close() {
	driver.close();
   }

}
