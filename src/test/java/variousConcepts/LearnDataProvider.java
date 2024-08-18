package variousConcepts;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class LearnDataProvider {

	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

//	Element List
	By USER_NAME_FIELD = By.xpath("//*[@id=\"user_name\"]");
	By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By SIGNIN_BUTTON_FIELD = By.xpath("//button[@id='login_submit']");
	By DASHBOARD_HEADER_FIELD = By.xpath("//strong[contains(text(), 'Dashboard')]");
	
	@BeforeClass
	public void reportGenerator() {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output\\extentReport.html");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest("DataProvider test");
		
	}
	
	@AfterClass
	public void closeReporter() {
		extent.flush();
	}

	@BeforeMethod
	public void init() {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(dataProvider = "loginData")
	public void loginTest(String userName, String password) {
		driver.findElement(USER_NAME_FIELD).sendKeys(userName);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		driver.findElement(SIGNIN_BUTTON_FIELD).click();

	}
	
	@DataProvider(name = "loginData")
	public String[][] loginData() {
		
		String[][] data = new String[][] {
			{"demo@codefios.com", "abc123"},
			{"testSelenium@techfios.com", "abc123"}
				
		};
		return data; 
	}

}
