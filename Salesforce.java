package week4Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce {

	public static void main(String[] args)
	{
		   WebDriverManager.chromedriver().setup();
		// creating an instance for chromeDriver
		   ChromeDriver driver = new ChromeDriver();
		// to launch the URL
		   driver.get("https://login.salesforce.com/");
		// to maximize
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
	   //login
		   driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		   driver.findElement(By.id("password")).sendKeys("Password$123");
		   driver.findElement(By.id("Login")).click();
		
	   // get primary window handle for later use
		
		   String PrimaryWindowHandle = driver.getWindowHandle();
		
	   // click Learn More
		   driver.findElement((By.xpath("//span[text()='Learn More']"))).click();
		
		   Set<String> windowHandles = driver.getWindowHandles();
		
		   List<String> winList = new ArrayList<String>(windowHandles);
		
	   // switch to second window
		   driver.switchTo().window(winList.get(1));
		
		   driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		   System.out.println(driver.getTitle());
		
	   // Get back to the parent window
		   driver.switchTo().window(PrimaryWindowHandle);
		
	   //close the browser
		   driver.quit();
	
	}

}
