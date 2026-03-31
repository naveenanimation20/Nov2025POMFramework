package com.opencart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.qa.utils.AppConstants;
import com.opencart.qa.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	// 1. initial driver and element util
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 2. page class constructor...
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. private By locators: PO
	private final By emailId = By.id("input-email");
	private final By password = By.id("input-password");
	private final By loginBtn = By.cssSelector("input[type='submit']");
	private final By forgotPwdLink = By.linkText("Forgotten Password");
	private final By registerLink = By.linkText("Register");


	// 4. public page actions/methods:
	
	@Step("getting login page title...")
	public String getLoginPageTitle() {
		String actTitle = eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
		System.out.println("Login Page title : " + actTitle);
		return actTitle;
	}

	@Step("getting login page url...")
	public String getLoginPageURL() {
		String actURL = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL, AppConstants.SHORT_TIME_OUT);
		System.out.println("Login Page URL : " + actURL);
		return actURL;
	}

	@Step("checking forgot pwd link exist on the login page...")
	public boolean isForgotPwdLinkExist() {
		return eleUtil.waitForElementVisible(forgotPwdLink, AppConstants.MEDIUM_TIME_OUT).isDisplayed();
	}

	@Step("user is logged-in with username: {0} and password: {1}")
	public HomePage doLogin(String username, String pwd) {
		System.out.println("App Credentials : " + username + " : " + pwd);
		eleUtil.doSendKeys(emailId, username, AppConstants.MEDIUM_TIME_OUT);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new HomePage(driver);		
	}
	
	@Step("navigating to the register page...")
	public RegisterPage navigateToRegisterPage() {
		eleUtil.waitForElementReadyAndClick(registerLink, AppConstants.SHORT_TIME_OUT);
		return new RegisterPage(driver);
	}
	
	

}
