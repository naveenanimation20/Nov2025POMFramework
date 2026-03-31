package com.opencart.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.opencart.qa.base.BaseTest;
import com.opencart.qa.utils.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("Epic 100: Design Login Page for Open Cart Application")
@Story("LoginUS 200: Add Login Page Features with title, url, user login etc...")
public class LoginPageTest extends BaseTest {

	@Description("checking login page title...")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void loginPageTitleTest() {
		ChainTestListener.log("starting loginPageTitleTest");
		Assert.assertEquals(loginPage.getLoginPageTitle(), AppConstants.LOGIN_PAGE_TITLE);
	}

	@Description("checking login page url...")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void loginPageURLTest() {
		Assert.assertTrue(loginPage.getLoginPageURL().contains(AppConstants.LOGIN_PAGE_URL));
	}

	@Description("checking forgot pwd link exist on the login page...")
	@Severity(SeverityLevel.BLOCKER)
	@Issue("BUG 9001: forgot pwd link is missing on the login page")
	@Test
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Description("checking user is able to login with valid credentials...")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = Integer.MAX_VALUE)
	public void loginTest() {
		homePage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		ChainTestListener.log("Home Page Title: " + homePage.getHomePageTitle());
		Assert.assertEquals(homePage.getHomePageTitle(), AppConstants.HOME_PAGE_TITLE);
	}

}



