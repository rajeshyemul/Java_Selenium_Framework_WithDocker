package com.rajesh.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rajesh.annotations.FrameworkAnnotation;
import com.rajesh.enums.CategoryType;
import com.rajesh.pages.OrangeHRMHomePage;
import com.rajesh.pages.OrangeHRMLoginPage;

public final class OrangeHRMTests extends BaseTest {
	
	private OrangeHRMTests() {
		
	}
	
	@FrameworkAnnotation(author="Rajesh Yemul", category = {CategoryType.SMOKE, CategoryType.REGRESSION})
	@Test
	public void loginLogoutTest(Map<String,String >data) {
		
		OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage();
		OrangeHRMHomePage orangeHRMHomePage = orangeHRMLoginPage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
		orangeHRMLoginPage = orangeHRMHomePage.clickWelcome().clickLogout();
		String actualTitle = orangeHRMLoginPage.getPageTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@Test
	public void newTest(Map<String,String >data) {
		
		OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage();
		OrangeHRMHomePage orangeHRMHomePage = orangeHRMLoginPage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
		orangeHRMLoginPage = orangeHRMHomePage.clickWelcome().clickLogout();
		String actualTitle = orangeHRMLoginPage.getPageTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

/*
	@DataProvider(name = "LoginTestDataProvider", parallel=true)
	public Object[][] getData1() {
		
		return new Object[][] {
			{"admin", "admin123"},
			{"admin123", "admin123"}
		};
	}
		*/
}
