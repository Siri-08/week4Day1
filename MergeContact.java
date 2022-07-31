package week4Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriverManager.chromedriver().setup();
		
		// creating an instance for chromeDriver
		
		 ChromeDriver driver = new ChromeDriver();
		 
		//Launch URL "http://leaftaps.com/opentaps/control/login"
		 
		 driver.get("http://leaftaps.com/opentaps/control/login");
		 
		// to maximize
		 
		 driver.manage().window().maximize();
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Enter UserName and Password Using Id Locator
		
		 driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		 driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// Click on Login Button using Class Locator
		 driver.findElement(By.className("decorativeSubmit")).click();
		  
		// Click on CRM/SFA Link
		 driver.findElement(By.linkText("CRM/SFA")).click();
		
		// Click on contacts Button
		 driver.findElement(By.linkText("Contacts")).click();
		 	
		// Click on Merge Contacts using Xpath Locator
		
		 driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		 
		// Click on Widget of From Contact
		 
		 driver.findElement(By.xpath("(//span[text()='From Contact']/following::a)[1]")).click();
		 
		// get primary window handle first
			
			String primarywindowHandle = driver.getWindowHandle();
			
		// switching windows
		 			
			Set<String> windowHandles = driver.getWindowHandles();
			
			List<String> winList = new ArrayList<String>(windowHandles);
			
			String secondWindowHandle = winList.get(1);
			
			driver.switchTo().window(secondWindowHandle);
			driver.manage().window().maximize();
			  
		//  Click on First Resulting Contact
			
			 driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
			
		// widget is on primary window so switch back
			
			 driver.switchTo().window(primarywindowHandle);
			
		// Click on Widget of To Contact
			
			 driver.findElement(By.xpath("(//span[text()='To Contact']/following::a)[1]")).click();
			 
		// switching windows
	 			
		     Set<String> windowHandles2 = driver.getWindowHandles();
		 
		     List<String> winList2 = new ArrayList<String>(windowHandles2);
		  
		     String secondWindowHandle2 = winList2.get(1);
		 
		     driver.switchTo().window(secondWindowHandle2);
		     driver.manage().window().maximize();	 
			
			
		 // Click on Second Resulting Contact
             
			  driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
			 
	          driver.switchTo().window(primarywindowHandle);
	         
	     // Click on Merge button using Xpath Locator
	 		 
	          driver.findElement(By.xpath("//a[text()='Merge']")).click();
	          
	 	 // Accept the Alert
	 		 
	          driver.switchTo().alert().accept();
	          
	 	 // Verify the title of the page
	          
	          System.out.println(driver.getTitle());
	}
}

	         