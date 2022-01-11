package com.ecom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.pagebase.PageBase;
import com.ecom.utils.EncryptDecrypt;
import com.ecom.utils.PropertyFileReader;


public class HomePage extends PageBase {

	@FindBy(id = "myaccount")
	WebElement myAccountButton;
	@FindBy(id = "email")
	WebElement emailInput;
	@FindBy(id="pass")
	WebElement passwordInput;
	@FindBy(css = "[type='submit']")
	WebElement loginButton;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public CustomerAccount login(String email,String password) {
		Actions act = new Actions(driver);
		act.moveToElement(myAccountButton).build().perform();
		emailInput.click();
		emailInput.sendKeys(email);
		
		passwordInput.sendKeys(password);
		loginButton.click();
		
		return new CustomerAccount(driver);
	}

}
