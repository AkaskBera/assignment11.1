package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pageObjects.PomLoginPage;

public class TC_Logout extends BaseTest{
	
	PomLoginPage lp;
	
	@BeforeMethod
	public void setup() {
		initialization();
		lp = new PomLoginPage(driver);
		lp.login(email, password);
		Assert.assertTrue(lp.validateLogoutButton());
		logger.info("Login is successful. Logout button is present in the page.");
	}
	
	@Test(description = "Logout from the site")
	public void logout() throws IOException {
		lp.clickOnLogoutButton();
		Assert.assertTrue(lp.validateLoginButton());
		logger.info("Successfully logged out from the site. Login button is present");
		Assert.assertEquals(driver.getCurrentUrl(), "http://demo.guru99.com/insurance/v1/index.php");
		logger.info("Current URL is --> " + driver.getCurrentUrl());
		Assert.assertEquals(driver.getTitle(), "Insurance Broker System - Login");
		logger.info("Current page title is --> " + driver.getTitle());
		captureScreen(driver, "Logout");
		logger.info("Testcase passed");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
