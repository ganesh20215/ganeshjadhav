package com.nisum.qa.baseTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.nisum.qa.util.Util;


public class Base {
	
	public static Properties prop;
	public static WebDriver driver;
		
	/**
	 * REading the code from Config.properties file & we are Instantiate the browser.
	 * <code>{@link # initialization()}</code>.
	 * @author GaneshJadhav
	 *
	 *
	 */

	public static void initialization()
	{		
		try
		{
		prop = new Properties();
		FileInputStream fp = new FileInputStream("D:\\Selenium\\studyworkspace\\NisumProject\\src\\main\\java\\com\\nisum\\qa\\config\\config.properties");
		prop.load(fp);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\GoogleChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\SeleniumGecko\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Util.IMPLICITE_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	

}
