package LambdaDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdvancedUserInteractions {

RemoteWebDriver driver;
	
	@BeforeTest
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build","AUI");
        capabilities.setCapability("name","Action");
        capabilities.setCapability("platform","Windows 11"); // If this cap isn't specified, it will just get any available one.
        capabilities.setCapability("browserName","chrome");
        capabilities.setCapability("version","97.0");
        capabilities.setCapability("console","true");
        capabilities.setCapability("network",true);
        capabilities.setCapability("visual",true);
        
        		try {
			driver = new RemoteWebDriver(new URL("https://msitara16:PocTkfCm7sBJ5vBjn09HBWExz5uYjVPmQO8POU4wFlXfIlJgSS@hub.lambdatest.com/wd/hub"), capabilities);
		//	driver = new RemoteWebDriver(new URL("https://sitara.mohan:ivw0RJKjqZnRgzZs4nAHkf1M72qV1MkrcoIONdaitv3cK0JO1d@hub.lambdatest.com/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterTest
	public void Close()

	{ 
		driver.quit();
	}
	@Test(enabled = false)
	
	public void move()
	{
		driver.get("https://www.lambdatest.com/");
		WebElement devs = driver.findElement(By.xpath("//button[normalize-space()='Developers']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(devs).perform();
		driver.findElement(By.xpath("(//h3[contains(text(),'API')])[2]")).click();
		String currentURL= driver.getCurrentUrl();
		Assert.assertEquals(currentURL, "https://www.lambdatest.com/support/api-doc/");
		}
	
	//DragandDrop (When there is source and target)
	@Test
	
	public void dragDrop()
	{
		driver.get("https://letcode.in/dropable");
		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(sourceEle, targetEle).perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Drag and Drop by x and y axis
	@Test
	public void dragDropByLocation()
	{
		driver.get("https://jqueryui.com/draggable/");
		driver.switchTo().frame(0);
		Actions builder = new Actions(driver);
		WebElement SourceEle = driver.findElement(By.id("draggable"));
		Point location =SourceEle.getLocation();
		int x= location.getX();
		int y=location.getY();
		
		builder.dragAndDropBy(SourceEle, x+50, y+20).perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

