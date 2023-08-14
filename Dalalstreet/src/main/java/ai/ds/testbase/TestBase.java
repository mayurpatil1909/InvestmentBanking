package ai.ds.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ai.ds.pagelayer.DashboardPage;
import ai.ds.pagelayer.ExchangePage;
import ai.ds.pagelayer.LoginPage;
import ai.ds.pagelayer.TransactionsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public LoginPage login;
	public DashboardPage dash;
	public ExchangePage exchange;
	public TransactionsPage tran;
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		String br = "CHROME";
		
		if(br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Provide valid browser");
		}
		driver.get("https://www.apps.dalalstreet.ai/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// ---------- Object Creation ---------- 
		login = new LoginPage();
		dash = new DashboardPage();
		exchange = new ExchangePage();
		tran = new TransactionsPage();
		
		//---------- login Steps ---------------------
		login.enterEmailID("amarwaghmare573@gmail.com");
		login.enterPassword("Test@1234");
		login.clickOnLoginButton();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown()
	{
//		driver.quit();
	}
	
}
