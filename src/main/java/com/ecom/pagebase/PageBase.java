package com.ecom.pagebase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	protected WebDriver driver = null;
	protected WebDriverWait wait;
	
	public PageBase(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
}