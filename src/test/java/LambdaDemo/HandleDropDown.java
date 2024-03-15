package LambdaDemo;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HandleDropDown  {
	RemoteWebDriver driver;
	
	@BeforeTest
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build","DropDown");
        capabilities.setCapability("name","Interact with Select");
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
	@Test
	
	public void selectDropDown()
	{ 
		
		driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
		//Single Selection:
		
				WebElement dayDropDown = driver.findElement(By.id("select-demo"));
				Select sel = new Select(dayDropDown);
				sel.selectByValue("Friday"); //in order to select an option we need this and we can also use selectByVisibleText
				WebElement firstSelectedOption = sel.getFirstSelectedOption();
				System.out.println("Select option is: " +firstSelectedOption.getText());
				
				//Multiple Selection:
				WebElement countriesDropDown = driver.findElement(By.id("multi-select"));
				Select countries =new Select(countriesDropDown);
				countries.selectByIndex(0);
				countries.selectByVisibleText("New Jersey");
				
				//To check whether it has selected all the elements in multiple select drop down
			List<WebElement> allSelectedOptions = countries.getAllSelectedOptions();
			for (WebElement country : allSelectedOptions) {
                System.out.println("selected opt:" +country.getText());
			}
		
	}
	
	@AfterTest
	public void tearDown()
	{ 
		driver.quit();
	}
}

