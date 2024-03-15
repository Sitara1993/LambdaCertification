package LambdaAssignmentTask;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
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


	public class TestScenario3 {
	RemoteWebDriver driver;
	    @Parameters({"browsername"})		
		@BeforeTest
		public void setUp(String browsername) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("build","Input Form");
	        capabilities.setCapability("name","Interact with Input Form Submit");
	        capabilities.setCapability("platform","Windows 11"); 
	        capabilities.setCapability("browserName",browsername);
	        capabilities.setCapability("version","120.0");
	        capabilities.setCapability("visual", true);
	        capabilities.setCapability("video", true);
	        capabilities.setCapability("network", true);
	        
	        		try {
				driver = new RemoteWebDriver(new URL("https://msitara92:iQMYe3qIjwyRLGGXBOsTxJBaQZqvhkNsPFen7LzvCazOQfBgYy@hub.lambdatest.com/wd/hub"),capabilities);
				driver.manage().window().maximize();
				driver.get("https://www.lambdatest.com/selenium-playground/");
				driver.findElement(By.linkText("Input Form Submit")).click();
				driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
				WebElement Name = driver.findElement(By.id("name"));
				String pleasefilloutthisform = Name.getAttribute("required");
		        Assert.assertTrue(true, pleasefilloutthisform);
		        String errormsg = "Please fill out this field.";
		        Assert.assertTrue(true, errormsg);
		        Name.sendKeys("Sitara Mohan");
		        WebElement Email = driver.findElement(By.xpath("//input[@id='inputEmail4']"));
		        Email.sendKeys("msitara92@yahoo.com");
		        WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
		        Password.sendKeys("MSITARA");
		        WebElement Company = driver.findElement(By.id("company"));
		        Company.sendKeys("Reflections Info System");
		        WebElement Website = driver.findElement(By.id("websitename"));
		        Website.sendKeys("www.reflectionsglobal.com");
		        WebElement CountryDropDown = driver.findElement(By.name("country"));
				Select sel = new Select(CountryDropDown);
				sel.selectByVisibleText("United States");
				WebElement City = driver.findElement(By.id("inputCity"));
				City.sendKeys("Mumbai");
				WebElement Address1 = driver.findElement(By.id("inputAddress1"));
				Address1.sendKeys("Shree Krishna Tower");
				WebElement Address2 = driver.findElement(By.id("inputAddress2"));
				Address2.sendKeys("Sector 19");
				WebElement State = driver.findElement(By.id("inputState"));
				State.sendKeys("Maharastra");
				WebElement Zipcode = driver.findElement(By.id("inputZip"));
				Zipcode.sendKeys("410209");
		        WebElement Submit = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
		        Submit.click();
		        Boolean ValidationMsg= driver.findElement(By.xpath("//p[contains(text(),'Thanks for contacting us, we will get back to you ')]")).isDisplayed();
				Assert.assertTrue(ValidationMsg);
				driver.quit();  
	        		
	        		} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		}