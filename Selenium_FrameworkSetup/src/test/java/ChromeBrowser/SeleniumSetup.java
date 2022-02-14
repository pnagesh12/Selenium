package ChromeBrowser;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumSetup {
	
	@Test
	public  void setup() throws InterruptedException {  
	  
     System.setProperty("webdriver.chrome.driver", "C:\\Users\\pawar.nagesh\\Downloads\\chromedriver_win32\\chromedriver.exe");  
          
     WebDriver driver=new ChromeDriver();    
     driver.navigate().to("http://www.Google.com/");  
      driver.manage().window().maximize(); 
       Thread.sleep(5000);
       driver.quit();

}
	
	
	
	
}
