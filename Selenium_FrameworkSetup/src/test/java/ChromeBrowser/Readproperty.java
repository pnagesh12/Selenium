package ChromeBrowser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Readproperty {
	WebDriver driver;

	private Properties properties;
	private final String propertyFilePath="Configue\\Config.Properties";

	@BeforeTest
	public void configFile(){
	System.setProperty("webdriver.chrome.driver", "getChromeDriverPath");
	driver= new ChromeDriver();
   BufferedReader reader;
	try {
	reader = new BufferedReader(new FileReader(propertyFilePath));
	properties = new Properties();
	try {
	properties.load(reader);
	reader.close();
	} catch (IOException e) {
	e.printStackTrace();
	}
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	}
	}

	@Test
	public String getDriverPath(){
	String driverPath = properties.getProperty("driverPath");
	if(driverPath!= null) return driverPath;
	else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public long getImplicitlyWait() {
	String implicitlyWait = properties.getProperty("implicitlyWait");
	if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
	else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public String getApplicationUrl() {
	String url = properties.getProperty("url");
	if(url != null) return url;
	else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}



	@AfterTest
	public void terminate() {
	driver.close();
	}

}
