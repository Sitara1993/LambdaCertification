package LambdaDemo;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class HandleAlert {
RemoteWebDriver driver;
	
	@BeforeTest
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build","Alert");
        capabilities.setCapability("name","Interact with alert box");
        capabilities.setCapability("platform","Windows 11"); // If this cap isn't specified, it will just get any available one.
        capabilities.setCapability("browserName","chrome");
        capabilities.setCapability("version","97.0");
        capabilities.setCapability("console","true");
        capabilities.setCapability("network",true);
        capabilities.setCapability("visual",true);
        
        		try {
			driver = new RemoteWebDriver(new URL("https://msitara16:PocTkfCm7sBJ5vBjn09HBWExz5uYjVPmQO8POU4wFlXfIlJgSS@hub.lambdatest.com/wd/hub"), capabilities);
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void handleAlert()
	{ 
		
		driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
		driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Click Me'])[1]")).click();
		Alert alert = driver.switchTo().alert();
		//driver.switchTo().alert().accept();
		 System.out.println(alert.getText());
		alert.accept();
		driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Click Me'])[2]")).click();
		alert.dismiss();		 
		
	}
	
	@AfterTest
	public void tearDown()
	{ 
		driver.quit();
	}
}
