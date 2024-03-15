package LambdaDemo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ScreenShot {
	
RemoteWebDriver driver = null;
	
	@Parameters({"browsername", "testName"})
	@BeforeMethod
	public void setUp(String browser, String testName) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build","Screenshot1");
        capabilities.setCapability("name","testName");
        capabilities.setCapability("platform","Windows 10"); // If this cap isn't specified, it will just get any available one.
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
	public void screenshot()
	{
	//System.setProperty("webdriver.chrome.driver","./DriversList/chromedriver.exe");
//	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
	File ScreenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	// FileHandler fileHandler = new FileHandler();
	try {
		FileHandler.copy(ScreenshotAs, new File("./snap/img1.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	WebElement ele = driver.findElement(By.xpath("//button[@id='showInput']"));
	File scr = ele.getScreenshotAs(OutputType.FILE);	
	try {
		FileHandler.copy(scr, new File("./snap/ele1.jpg"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.quit();
	
}
}
