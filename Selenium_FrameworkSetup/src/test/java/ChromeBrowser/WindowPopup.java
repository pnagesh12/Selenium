package ChromeBrowser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowPopup {
	public String url= "https://www.browserstack.com/users/sign_up";
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
	public void Popup() throws InterruptedException {
		driver.findElement(By.id("user_full_name")).sendKeys("username"); 
		driver.findElement(By.id("user_email_login")).sendKeys("panagesh007@gmail.com");
		driver.findElement(By.id("user_password")).sendKeys("Password@1234");
		Thread.sleep(5000);
	    driver.findElement(By.xpath("//input[@value='Sign me up']")).click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert(); // switch to alertString 
		driver.switchTo().alert().getText(); // capture alert message
		System.out.println(alert.getText()); // Print Alert Message
		String text=alert.getText();
		if(text.equals("Please check the box to confirm acceptance of our ")) {
			System.out.println("Correct Message");
		}else {
			System.out.println("Incorrect Message");
		}
		Thread.sleep(5000);
		alert.dismiss();
		
	}
	@AfterClass
    public void afterTest() {
        driver.close();
    }
}