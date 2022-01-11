package com.tests.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecom.pages.CustomerAccount;
import com.ecom.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	protected HomePage homePage;
	protected CustomerAccount custAccount;


	protected WebDriver driver;

	/*
	 * Method to initialize WebDriver. We use RemoteWebDriver to run tests on
	 * selenium grid. host is initialized to 'localhost', to run tests locally, if
	 * HUB_HOST is not specified. HUB_HOST and BROWSER are read as system properties
	 * 
	 */
	
	public void initializeWebDriver() {

		String host = "localhost";
		DesiredCapabilities dc;
		String browser = System.getProperty("BROWSER");
		String url = System.getProperty("URL");
		System.out.println(url+browser);

		if (browser != null && browser.equalsIgnoreCase("firefox")) {
			dc = DesiredCapabilities.firefox();
//			WebDriverManager.firefoxdriver().setup();
//			this.driver=new FirefoxDriver();
		} else {
			dc = DesiredCapabilities.chrome();
//			WebDriverManager.chromedriver().setup();
//			this.driver=new ChromeDriver();
		}

		if (System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}

		String finalUrl = "http://" + host + ":4444/wd/hub";
		try {
			this.driver = new RemoteWebDriver(new URL(finalUrl), dc);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (url != null)
			driver.get(url);
		else
			driver.get("https://www.mytheresa.com/en-de/men.html");
	}

	public void tearDown() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
