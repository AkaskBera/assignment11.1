package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pageObjects.PomLoginPage;
import com.qa.utilities.XLUtils;

public class TC_MultipleLoginDDT extends BaseTest {
	
	//Login with invalid credentials
	@Test(dataProvider = "LoginData")
	public void loginDDT(String email, String password) throws IOException {
		initialization();
		PomLoginPage lp = new PomLoginPage(driver);
		lp.login(email, password);
		logger.info("Trying to login...");
		Boolean loginButton = lp.validateLoginButton();
		Assert.assertTrue(loginButton);
		logger.info("Login is unsuccessful. Login button is present.");
		String errorMsg = lp.verifyErrorMessage();
		Assert.assertEquals(errorMsg, "Enter your Email address and password correct");
		logger.info("The error message is displayed --> " + errorMsg);
		captureScreen(driver, "MultipleLogin");
		logger.info("Testcase passed");
	}

	@DataProvider(name = "LoginData")
	Object[][] getData() throws IOException {
		int rownum = XLUtils.getRowCount(excelPath, sheetName);
		int colcount = XLUtils.getCellCount(excelPath, sheetName, 1);
		Object logindata[][] = new Object[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(excelPath, sheetName, i, j);
			}
		}
		return logindata;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
