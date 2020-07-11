package unicodeTech.BasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import unicodeTech.Utility.ExcelFileReader;
import unicodeTech.Utility.MyLibrary;

/*1. Initialize and load properties file
2. Launch browser
3. Define WebDriver
4. Maximize browser window
5. Define TimeUnit
6. Delete All Cookies
7. Create object of ExcelFileReader class
8. Generate logs
9. Create a method isElementPresent*/


public class BaseInit {

	public static WebDriver driver;
	public static Properties storage;
	public static Logger logs;
	public static ExcelFileReader data;
	
	public void startUP() throws Exception {
		
		if(driver==null) {
		
		logs = Logger.getLogger("devpinoyLogger");
		
		logs.info("Properties file is loading now");
		
		storage = new Properties();
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"//src//unicodeTech//PropertiesData//ObjectStorage.properties");
		storage.load(fi);
		
		logs.info("Properties file loaded successfully");
		logs.info("Browser will be launching");
		String browserKey = storage.getProperty("browser");
		
		if(browserKey.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "D:\\Software\\Testing-Tools\\Selenium\\WebDriver\\Drivers\\IEChromeFirefox\\drivers\\windows\\chromedriver.exe");

			driver = new ChromeDriver();
		
			logs.info("Chrome Browser launched..");
			
		}else if(browserKey.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "D:\\Software\\Testing-Tools\\Selenium\\WebDriver\\Drivers\\IEChromeFirefox\\drivers\\windows\\geckodriver.exe");

			driver = new FirefoxDriver();
			logs.info("Firefox Browser launched..");

		}else {
			
			logs.info("No browser defined...");
		}
		
		driver.manage().window().maximize();
		logs.info("Window is maximized");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logs.info("Timeunit is defined");

		driver.manage().deleteAllCookies();
		logs.info("Cookies has been deleting");

		data = new ExcelFileReader(System.getProperty("user.dir")+"//src//unicodeTech//TestData//TestCases.xlsx");
		logs.info("ExcelFileReader object created..");
		
		}
	}
	
	public static WebElement isElementPresent(String propKey) {
		
		try {
			
			if(propKey.contains("xpath")) {
				
				return driver.findElement(By.xpath(storage.getProperty(propKey)));
			
			}else if(propKey.contains("id")) {
				
				return driver.findElement(By.id(storage.getProperty(propKey)));
			
			}else if(propKey.contains("name")) {
				
				return driver.findElement(By.name(storage.getProperty(propKey)));
			
			}else if(propKey.contains("linkText")) {
				
				return driver.findElement(By.linkText(storage.getProperty(propKey)));
			
			}
			
		}catch(Exception e) {
			
			logs.info("Properties key not found in the properties file");
			MyLibrary.getScreenShot("KeyNotFound", driver);
		}
		return null;
		
		
	}
	
	
}
