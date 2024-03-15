package LambdaDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ConfigFile {
public RemoteWebDriver driver;
	
	@BeforeTest
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build","Windows And Frame");
        capabilities.setCapability("name","Interact with Windows and Frame");
        capabilities.setCapability("platform","Windows 11"); // If this cap isn't specified, it will just get any available one.
        capabilities.setCapability("browserName","chrome");
        capabilities.setCapability("version","97.0");
        capabilities.setCapability("console","true");
        capabilities.setCapability("network","true");
        capabilities.setCapability("visual","true");
        		try {
			driver = new RemoteWebDriver(new URL("https://msitara16:PocTkfCm7sBJ5vBjn09HBWExz5uYjVPmQO8POU4wFlXfIlJgSS@hub.lambdatest.com/wd/hub"), capabilities);
		//	driver = new RemoteWebDriver(new URL("https://sitara.mohan:ivw0RJKjqZnRgzZs4nAHkf1M72qV1MkrcoIONdaitv3cK0JO1d@hub.lambdatest.com/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterTest
	public void tearDown()
	{ 
		driver.quit();
	}
}
