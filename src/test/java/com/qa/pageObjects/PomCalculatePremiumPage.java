package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PomCalculatePremiumPage {

	WebDriver driver;

	public PomCalculatePremiumPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ui-id-2")
	WebElement requestQuotationTab;

	@FindBy(xpath = "//h2[text()='Request a quotation']")
	WebElement rqtext;

	@FindBy(xpath = "//input[@value='Yes']")
	WebElement radioButton;

	@FindBy(name = "value")
	WebElement estimatedValueTxtField;

	@FindBy(name = "parkinglocation")
	WebElement parkingLocationDropdown;

	@FindBy(xpath = "//input[@value='Calculate Premium']")
	WebElement calculatePremiumButton;

	@FindBy(id = "calculatedpremium")
	WebElement premiumDetails;

	@FindBy(id = "resetquote")
	WebElement resetFormButton;

	public void clickOnRequestQuotationTab() {
		requestQuotationTab.click();
	}

	public boolean validateRequestQuotationTab() {
		return requestQuotationTab.isDisplayed();
	}

	public boolean validateRadioButton() {
		radioButton.click();
		return radioButton.isSelected();
	}

	public String validateEstimatedValue() {
		estimatedValueTxtField.sendKeys("1000");
		return estimatedValueTxtField.getAttribute("value");
	}

	public String validateParkingLocation() {
		Select s = new Select(parkingLocationDropdown);
		s.selectByVisibleText("Public Place");
		return s.getFirstSelectedOption().getText();
	}

	public String validateCalculatePremium() {
		calculatePremiumButton.click();
		return premiumDetails.getText();
	}

	public void clickOnResetForm() {
		resetFormButton.click();
	}

	public String afterResetEstimatedValue() {
		return estimatedValueTxtField.getAttribute("value");
	}

	public String afterResetparkingLocation() { 
		return parkingLocationDropdown.getAttribute("value");
	}

}
