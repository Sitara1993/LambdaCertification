package LambdaAssignmentTask;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.net.URL;


	public class TestScenario1 {
	RemoteWebDriver driver;
	    @Parameters({"browsername"})
		@BeforeTest
		public void setUp(String browsername) {
	    	System.out.println(browsername);
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("build","Single Input Field");
	        capabilities.setCapability("name","Interact with Single Form Demo");
	        capabilities.setCapability("platform","Windows 11"); 
	        capabilities.setCapability("browserName", browsername);
	        capabilities.setCapability("version","120.0");
	        capabilities.setCapability("visual", true);
	        capabilities.setCapability("video", true);
	        capabilities.setCapability("network", true);
	        
	        		try {
				driver = new RemoteWebDriver(new URL("https://msitara92:iQMYe3qIjwyRLGGXBOsTxJBaQZqvhkNsPFen7LzvCazOQfBgYy@hub.lambdatest.com/wd/hub"), capabilities);
				driver.get("https://www.lambdatest.com/selenium-playground");
				driver.findElement(By.linkText("Simple Form Demo")).click();
				String actual_URL = driver.getCurrentUrl();
				Assert.assertTrue(actual_URL.contains("simple-form-demo"));
				WebElement aMessage = driver.findElement(By.xpath("//input[@id='user-message']"));
				String Welcome = "Welcome to LambdaTest";
				aMessage.sendKeys(Welcome);
				driver.findElement(By.xpath("//button[text()='Get Checked Value']")).click();
				
				String YourMessageText = driver.findElement(By.id("message")).getText();
				System.out.println(YourMessageText);
				
				Assert.assertEquals(YourMessageText, Welcome);
				driver.quit();       		
	        		        		        		
	        		} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}


