package LambdaDemo;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class WindowHandling extends ConfigFile{

	@Test
		public void windows()
	{ 
		//System.setProperty("webdriver.chrome.driver","./DriversList/chromedriver.exe");
		//ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
		System.out.println("ParentWindow:" +driver.getTitle());
		String parentWindow =driver.getWindowHandle();
		System.out.println(parentWindow);
		driver.findElement(By.linkText("Follow On Twitter")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));		
		System.out.println("ChildWindow:" +driver.getTitle());
		System.out.println("title");
		
		//Switch to parent window
		driver.switchTo().window(parentWindow);
		System.out.println("Back to parent:" +driver.getTitle());
		driver.quit();
		
	}
		
			
		
		
}
