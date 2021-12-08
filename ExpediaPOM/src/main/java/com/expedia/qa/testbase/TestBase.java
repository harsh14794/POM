package com.expedia.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.expedia.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException {
		
		try {
			prop = new Properties();
			
			FileInputStream ip = new FileInputStream("C:\\Users\\Harsh Patel\\eclipse-workspace\\ExpediaPOM\\src\\main\\java\\com\\expedia\\qa\\config\\config.properties");
			prop.load(ip);
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
	@SuppressWarnings("deprecation")
	public static void initialization() {
		String browsername= prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Harsh Patel\\eclipse-workspace\\ExpediaPOM\\chromedriver_win32 (3)\\chromedriver.exe");	
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
}
