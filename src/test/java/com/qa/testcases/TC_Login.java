package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pageObjects.PomLoginPage;

public class TC_Login extends BaseTest {
	PomLoginPage lp;

	@BeforeMethod
	public void setup() {
		initialization();
		lp = new PomLoginPage(driver);
		lp.login(email, password);
	}

	@Test(description = "Login with valid credentials")
	public void loginPageTest() throws IOException {
		Assert.assertTrue(lp.validateLogoutButton());
		logger.info("Login is successful. Logout button is present in the page.");
		Assert.assertEquals(lp.validateLoginPageTitle(), "Insurance Broker System");
		logger.info("The title of the page is --> " + lp.validateLoginPageTitle());
		Assert.assertEquals(lp.validateCurrentURL(), "http://demo.guru99.com/insurance/v1/header.php");
		logger.info("The current url is --> " + lp.validateCurrentURL());
		Assert.assertEquals(lp.validateTextIsPresent(), "Broker Insurance WebPage");
		logger.info("The text " + lp.validateTextIsPresent() + " is present.");
		captureScreen(driver, "Login");
		logger.info("Testcase passed");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
