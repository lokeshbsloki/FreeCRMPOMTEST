package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventlistener;

	public TestBase() {
		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"G:\\MyJavaProject\\FreeCRMPOMTest\\src\\main\\java" + "\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void initialization() {
		
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "G:\\Selenium\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		e_driver=new EventFiringWebDriver(driver);
		 eventlistener = new WebEventListener();
		 e_driver.register(eventlistener);
		 driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
		driver.get(prop.getProperty("url"));
	}

}
