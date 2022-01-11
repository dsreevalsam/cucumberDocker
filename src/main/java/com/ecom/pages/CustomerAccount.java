package com.ecom.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecom.pagebase.PageBase;

public class CustomerAccount extends PageBase{

	public CustomerAccount(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".page-title>h1")
	WebElement pageTitle;
	
	
	public String getPageTitle() {
		wait.until(ExpectedConditions.visibilityOf(pageTitle));
		return pageTitle.getText();
	}
	
}
