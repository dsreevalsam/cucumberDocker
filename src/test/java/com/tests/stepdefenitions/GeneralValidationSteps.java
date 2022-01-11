package com.tests.stepdefenitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

	
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.gherkin.model.When;
import com.ecom.pages.HomePage;
import com.ecom.utils.ApiUtils;
import com.ecom.utils.EncryptDecrypt;
import com.ecom.utils.PropertyFileReader;
import com.tests.core.TestBase;

import static io.restassured.RestAssured.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GeneralValidationSteps extends TestBase {
	String secret = "this is my mytheresapassword";
	@Given("User launches MyTheresa")
	public void user_login_to_MyTheresa() {
		try {
			initializeWebDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("Check if there are any javascript errors")
	public void check_if_javascript_errors() {
		ApiUtils api = new ApiUtils(driver);
		Assert.assertTrue(api.isLogError(LogType.DRIVER, driver));

	}

	@And("Visit all urls and Validate Status Codes")
	public void validateStatusCodes() {
		ApiUtils api = new ApiUtils(driver);
		ArrayList<String> urlList = api.getInternalUrls();
//		System.out.println(urlList.subList(0, 10));
		int statusCode,statusSeries;
		SoftAssert sAssert=new SoftAssert();
		int i=0;
		while(i<5) {
			statusCode=get(urlList.get(i)).getStatusCode();
			statusSeries=statusCode/100;
			sAssert.assertEquals(statusSeries,2,"Status Code: "+statusCode+" for url: "+urlList.get(i));
			i++;
		}
	}

	@Then("Login with email {string}")
	public void loginWithEmail(String email) {

		homePage = new HomePage(driver);
		
		PropertyFileReader reader = new PropertyFileReader("inputData");
		String password=EncryptDecrypt.decrypt(reader.getString("test123@test123.com"), secret);
		custAccount = homePage.login(email,password);
	}

	@And("Validate login was successful")
	public void validateLoginSuccess() {
		Assert.assertEquals(custAccount.getPageTitle(), "MY OVERVIEW");
	}

	@After
	public void finishTest() {
		tearDown();
	}

}