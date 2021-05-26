package com.rajesh.driver;

import java.net.MalformedURLException;
import java.util.Objects;

import com.rajesh.enums.ConfigProperties;
import com.rajesh.exceptions.BrowserInvocationFailedException;
import com.rajesh.factories.DriverFactory;
import com.rajesh.utils.PropertyUtils;

public final class Driver {

	private Driver() {
		
	}

	public static void initDriver(String browser) {
		
		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriverInstance(browser));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailedException("Browser invocation exception");
			}
			DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
			DriverManager.getDriver().manage().window().maximize();
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
