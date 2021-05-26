package com.rajesh.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.rajesh.constants.FrameworkConstants;
import com.rajesh.enums.ConfigProperties;
import com.rajesh.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	public DriverFactory() {
	
	}
	public static WebDriver driver = null;
	public static WebDriver getDriverInstance(String browser) throws MalformedURLException {
		
		String runMode = PropertyUtils.getValue(ConfigProperties.RUNMODE);
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			if(runMode.equalsIgnoreCase("Remote")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setBrowserName(browser);
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			} else
			{
				driver = new ChromeDriver();
			}
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if(runMode.equalsIgnoreCase("Remote")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setBrowserName(browser);
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			} else
			{
				driver = new FirefoxDriver();
			}
		}
		else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.chrome.driver", FrameworkConstants.getIeDriverPath());
			if(runMode.equalsIgnoreCase("Remote")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setBrowserName(browser);
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			} else
			{
				driver = new InternetExplorerDriver();
			}
		}
		return driver;
	}
}
