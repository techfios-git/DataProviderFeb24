package variousConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LearnParallelExecution {
	
	public WebDriver driver;
	 
	@Test
	  public void FirefoxTest() {	 

		 System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());
		 System.setProperty("webdriver.edge.driver", "drivers\\msedgedriver.exe");
		  driver = new EdgeDriver();	  
		  driver.get("https://www.yahoo.com/"); 

	  }
	 
	 @Test
	 public void ChromeTest(){ 

	       System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getId());
	       System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	       driver = new ChromeDriver();
	       driver.get("https://www.yahoo.com/"); 
	 }
}



