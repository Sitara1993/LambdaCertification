package LambdaAssignmentTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.net.URL;


	public class TestScenario2 {
		
	RemoteWebDriver driver;
	    @Parameters({"browsername"})
		@BeforeTest
		public void setUp(String browsername) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("build","Drag and Drop Slider");
	        capabilities.setCapability("name","Interact with Drag and Drop");
	        capabilities.setCapability("platform","Windows 11"); 
	        capabilities.setCapability("browserName",browsername);
	        capabilities.setCapability("version","120.0");
	        capabilities.setCapability("visual", true);
	        capabilities.setCapability("video", true);
	        capabilities.setCapability("network", true);
	        
	        		try {
				driver = new RemoteWebDriver(new URL("https://msitara92:iQMYe3qIjwyRLGGXBOsTxJBaQZqvhkNsPFen7LzvCazOQfBgYy@hub.lambdatest.com/wd/hub"),capabilities);
				driver.get("https://www.lambdatest.com/selenium-playground/");
				driver.manage().window().maximize();
				driver.findElement(By.linkText("Drag & Drop Sliders")).click();
				WebElement Slider = driver.findElement(By.xpath("(//input[@value='15'])[1]"));
				Actions dragAction =new Actions(driver);
				dragAction.dragAndDropBy(Slider, 214, 0).perform();
				
				String text = driver.findElement(By.id("rangeSuccess")).getText();
				System.out.println(text);
				String expected = "95";
				Assert.assertEquals(text.trim(), expected);
				driver.quit();  
	        		
	        		
	        		} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}