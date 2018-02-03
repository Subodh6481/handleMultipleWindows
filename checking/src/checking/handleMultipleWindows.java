package checking;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class handleMultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","C://Subodh//chromedriver_win32//chromedriver.exe");
		
		ChromeOptions option = new ChromeOptions();
		
		option.addArguments("disable-infobars");
		option.addArguments("user-data-dir=/path/to/your/custom/profile");
		
		WebDriver driver= new ChromeDriver(option);
		
		driver.get("http://toolsqa.com/automation-practice-switch-windows");
		
		////span[contains(text(),'HOME') and @class='menu-text']
		driver.manage().window().maximize();
		
		String parentWindow= driver.getWindowHandle();
		
		System.out.println("parent Window key is " + parentWindow);
		
		driver.findElement(By.xpath("//button[@id='button1']")).click();
		
		Set<String> windowHandle=driver.getWindowHandles();
		
		for(String window:windowHandle) {
			
			System.out.println("window key is" +window);
			
			driver.switchTo().window(window);
			
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//span[contains(text(),'HOME') and @class='menu-text']")).click();
			
			String pageTitle=driver.getTitle();
			
			System.out.println("pageTitle of " + window +" window is " + pageTitle);
			Thread.sleep(3000);
			
			driver.close();
			
		}
		
		
		//driver.switchTo().window(parentWindow);
		
		//driver.get("https://www.google.co.in");
		Thread.sleep(3000);
		driver.quit();
		
	}

}
