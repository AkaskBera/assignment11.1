package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomLoginPage {

	WebDriver driver;

	public PomLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement emailId;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginBtn;

	@FindBy(xpath = "//input[@value='Log out']")
	WebElement logoutBtn;

	@FindBy(xpath = "//h2[text()='Broker Insurance WebPage']")
	WebElement text;

	@FindBy(xpath = "//b[text()='Enter your Email address and password correct']")
	WebElement errorMessage;

	public void login(String email, String pwd) {
		emailId.sendKeys(email);
		password.sendKeys(pwd);
		loginBtn.click();
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLoginButton() {
		return loginBtn.isDisplayed();
	}

	public boolean validateLogoutButton() {
		return logoutBtn.isDisplayed();
	}

	public void clickOnLogoutButton() {
		logoutBtn.click();
	}

	public String validateCurrentURL() {
		return driver.getCurrentUrl();
	}

	public String validateTextIsPresent() {
		return text.getText();
	}

	public String verifyErrorMessage() {
		return errorMessage.getText();
	}
}
