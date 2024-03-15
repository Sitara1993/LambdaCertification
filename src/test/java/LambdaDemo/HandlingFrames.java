package LambdaDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingFrames extends ConfigFile {
	
	@Test
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./DriversList/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/frame");
		
		//frame
		//driver.switchTo.frame("firstFr);
		//driver.switchTo.frame(1);
		WebElement frameEle = driver.findElement(By.xpath("//iframe[@src='frameUI']"));
		driver.switchTo().frame(frameEle);
		driver.findElement(By.name("fname")).sendKeys("Sitara");
		driver.findElement(By.name("lname")).sendKeys("Mohan");
		
		
		//Nested Frame
		WebElement innerFrames = driver.findElement(By.cssSelector("iframe.has-background-white"));
		driver.switchTo().frame(innerFrames);
		driver.findElement(By.name("email")).sendKeys("msitara16@gmail.com");
		
		//Switching Back to parent frame
		driver.switchTo().parentFrame();
		driver.findElement(By.name("fname")).sendKeys("Sitara");
		
		//defaultContent
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Log in")).click();
	}

}
