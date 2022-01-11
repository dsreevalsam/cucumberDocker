package com.ecom.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ecom.pagebase.PageBase;

public class ApiUtils extends PageBase{

	public ApiUtils(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[contains(@href,'http')]")
	List<WebElement> hyperlinks;
	
	public boolean isLogError(String log, WebDriver driver) {
		boolean flag=false;
		List<String> errorStrings = new ArrayList<>(Arrays.asList("SyntaxError", "EvalError", "ReferenceError",
				"RangeError", "TypeError", "URIError", "Uncaught Error"));
		List<LogEntry> entries = driver.manage().logs().get(log).getAll();
		for (LogEntry entry : entries) {
			System.out.println(entry.getMessage());
//			System.out.println(entry.getClass());
			for (String errtype : errorStrings)
				if (entry.getMessage().contains(errtype)) {
					flag=true;
				}
		}
		return flag;
	}
	
	public ArrayList<String> getInternalUrls() {
//		System.out.println(hyperlinks.get(10).getAttribute("href"));
		return (ArrayList<String>) hyperlinks.stream().map(e->e.getAttribute("href")).collect(Collectors.toList());
		
	}
}
