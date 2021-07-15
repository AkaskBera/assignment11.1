package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.pageObjects.PomCalculatePremiumPage;
import com.qa.pageObjects.PomLoginPage;

public class TC_RequestQuotation extends BaseTest {
	PomLoginPage lp;
	PomCalculatePremiumPage cp;

	@BeforeMethod
	public void login() {
		initialization();
		lp = new PomLoginPage(driver);
		lp.login(email, password);
		Assert.assertTrue(lp.validateLogoutButton());
		logger.info("Login is successful. Logout button is present in the page.");
	}

	@Test(description = "Calculate Premium")
	public void testCalculatePremiun() throws IOException {
		cp = new PomCalculatePremiumPage(driver);
		cp.clickOnRequestQuotationTab();
		logger.info("Clicked on Request Quotation tab.");
		Assert.assertTrue(cp.validateRequestQuotationTab());
		logger.info("Request Quotation tab is present.");
		Assert.assertTrue(cp.validateRadioButton());
		logger.info("Yes radio button is selected successfully.");
		Assert.assertEquals(cp.validateEstimatedValue(), "1000");
		logger.info("Value is entered successfully and the value is " + cp.validateEstimatedValue());
		Assert.assertEquals(cp.validateParkingLocation(), "Public Place");
		logger.info(cp.validateParkingLocation() + " is selected successfully.");
		Assert.assertNotEquals(cp.validateCalculatePremium(), null);
		logger.info(cp.validateCalculatePremium() + " Discount and Premium are calculated and are not null.");
		cp.clickOnResetForm();
		Assert.assertEquals(cp.afterResetEstimatedValue(), "");
		Assert.assertEquals(cp.afterResetparkingLocation(), "");
		logger.info("Entered value are resetted successfully.");
		captureScreen(driver, "RequestQuotation");
		logger.info("Testcase passed");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
