package LambdaDemo;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadAndDownload {

	
RemoteWebDriver driver = null;
	
	
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build","Upload");
        capabilities.setCapability("name", "Testing of Upload");
        capabilities.setCapability("platform","Windows 10"); // If this cap isn't specified, it will just get any available one.
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version","98.0");
        capabilities.setCapability("console","true");
        capabilities.setCapability("network",true);
        capabilities.setCapability("visual",true);
         
        try {
			driver = new RemoteWebDriver(new URL("https://msitara16:PocTkfCm7sBJ5vBjn09HBWExz5uYjVPmQO8POU4wFlXfIlJgSS@hub.lambdatest.com/wd/hub"), capabilities);
		    driver.setFileDetector(new LocalFileDetector());
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
	public void main() {
		//System.setProperty("webdriver.chrome.driver","./DriversList/chromedriver.exe");
		//ChromeDriver driver = new ChromeDriver();
		ChromeOptions option = new ChromeOptions();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.prompt_for_download", false);
		option.setExperimentalOption("prefs", prefs);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://chromedriver.storage.googleapis.com/index.html?path=112.0.5615.49/");
		driver.findElement(By.linkText("chromedriver_win32.zip")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	//	upload();
	}
	private void upload() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
	// WebElement UploadEle = 
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\sitaram\\eclipse-workspace\\LambdaSeleniumDemo\\snap\\img1.png");
		//File file = new File("./img1.png");
		//System.out.println(file.getAbsolutePath());
		//UploadEle.sendKeys(file.getAbsolutePath());
		driver.findElement(By.xpath("//span[.='Start upload']")).click();
		//driver.findElement(By.xpath("//span[normalize-space()='Start']")).click();
		boolean displayed = driver.findElement(By.cssSelector("button[data-type='DELETE'] span")).isDisplayed();
		assertTrue(displayed);
	}
}
