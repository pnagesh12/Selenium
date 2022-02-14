package ChromeBrowser;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragandDrop {
	public String url= "https://jqueryui.com/droppable/";
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
	public void dragdrop() {
	WebElement ele1= driver.findElement(By.xpath("//div[@class='ui-widget-content ui-draggable ui-draggable-handle']"));
	WebElement ele2= driver.findElement(By.xpath("//div[@class='ui-widget-header ui-droppable ui-state-highlight']"));

	Actions builder = new Actions(driver);

	Action dragAndDrop = builder.clickAndHold(ele1).moveToElement(ele2).release(ele2).build();
	dragAndDrop.perform();

}
	@AfterClass
    public void afterTest() {
        driver.close();
    }
}
