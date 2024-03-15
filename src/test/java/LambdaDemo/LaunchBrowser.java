package LambdaDemo;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class LaunchBrowser {
	RemoteWebDriver driver;
	
	@BeforeTest
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build","First Run Demo");
        capabilities.setCapability("name","Interact with Input");
        capabilities.setCapability("platform","Windows 11"); // If this cap isn't specified, it will just get any available one.
        capabilities.setCapability("browserName","chrome");
        capabilities.setCapability("version","97.0");
        		try {
			driver = new RemoteWebDriver(new URL("https://msitara16:PocTkfCm7sBJ5vBjn09HBWExz5uYjVPmQO8POU4wFlXfIlJgSS@hub.lambdatest.com/wd/hub"), capabilities);
		//	driver = new RemoteWebDriver(new URL("https://sitara.mohan:ivw0RJKjqZnRgzZs4nAHkf1M72qV1MkrcoIONdaitv3cK0JO1d@hub.lambdatest.com/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	
	public void myTest()
	{ 
		// System.setProperty("webdriver.chrome.driver","./DriversList/chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		
		// driver.get("https://accounts.lambdatest.com/login");
		driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		String title = driver.getTitle();
		System.out.println(title);
		WebElement aInput = driver.findElement(By.id("sum1"));
		String Message = aInput.getAttribute("placeholder");
		System.out.println("Placeholder value : "+Message);
		aInput.sendKeys("10");
		WebElement bInput = driver.findElement(By.id("sum2"));
		bInput.sendKeys("20");
		driver.findElement(By.xpath("//button[text()='Get Sum']")).click();
		String text = driver.findElement(By.id("addmessage")).getText();
		System.out.println(text);
		
	}
	
	@AfterTest
	public void tearDown()
	{ 
		driver.quit();
	}
}

