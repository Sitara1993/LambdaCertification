package LambdaDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HandleAuthenticationPopUp {
	
	RemoteWebDriver driver = null;
	
	@Parameters({"browsername", "testName"})
	@BeforeMethod
	public void setUp(String browser, String testName) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build","HandleAuth");
        capabilities.setCapability("name","testName");
        capabilities.setCapability("platform","Windows 11"); // If this cap isn't specified, it will just get any available one.
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("version","98.0");
        
        try {
			driver = new RemoteWebDriver(new URL("https://msitara16:PocTkfCm7sBJ5vBjn09HBWExz5uYjVPmQO8POU4wFlXfIlJgSS@hub.lambdatest.com/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
	
	@Test
	
	public void handleAuth()
	{
		String username = "admin";
		String password = "admin";
		//System.setProperty("webdriver.chrome.driver","./DriversList/chromedriver.exe");
		//ChromeDriver driver = new ChromeDriver();
		driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		String text = driver.findElement(By.cssSelector("div#content>div>p")).getText();
		System.out.println(text);
		String expected = "Congratulations! You must have the proper credentials.";
		Assert.assertEquals(text.trim(), expected);
		
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		}
		
	}


