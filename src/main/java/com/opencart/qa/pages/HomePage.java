package com.opencart.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.opencart.qa.utils.AppConstants;
import com.opencart.qa.utils.ElementUtil;

public class HomePage {

	// 1. initial driver and element util
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 2. page class constructor...
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. private By locators: PO
	private final By logoutLink = By.linkText("Logout");
	private final By headers = By.cssSelector("div#content h2");
	private final By searchTextField = By.name("search");
	private final By searchIcon = By.cssSelector("div#search button");

	// 4. public page actions/methods:

	public String getHomePageTitle() {
		String actTitle = eleUtil.waitForTitleIs(AppConstants.HOME_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
		System.out.println("Home Page title : " + actTitle);
		return actTitle;
	}

	public boolean isLogoutLinkExist() {
		return eleUtil.isElementDisplayed(logoutLink);
	}

	public List<String> getHomePageHeaders() {
		List<WebElement> headersList = eleUtil.waitForAllElementsPresence(headers, AppConstants.SHORT_TIME_OUT);
		List<String> headersValueList = new ArrayList<String>();
		for (WebElement e : headersList) {
			String text = e.getText();
			headersValueList.add(text);
		}

		return headersValueList;
	}

	public ResultsPage doSearch(String searchKey) {
		System.out.println("Search Key: " + searchKey);
		eleUtil.doSendKeys(searchTextField, searchKey, AppConstants.SHORT_TIME_OUT);
		eleUtil.doClick(searchIcon);
		return new ResultsPage(driver);
	}

	//TDD
	
	
	
	
	
	
	
}
