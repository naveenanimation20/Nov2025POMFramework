package com.opencart.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.qa.base.BaseTest;

public class RegisterPageTest extends BaseTest{
	
	
	
	@BeforeClass
	public void regSetup() {
		registerPage = loginPage.navigateToRegisterPage();
	}
	
	
	@DataProvider
	public Object[][] getUserRegTestData() {
		return new Object[][] {
			{"gaurav", "sharma", "9878987678", "gaurav@123", "yes"},
			{"anurag", "automation", "9878987687", "anurag@123", "no"},
			{"priya", "automation", "2378987678", "priya@123", "yes"},
		};
	}
	
	
	@Test(dataProvider = "getUserRegTestData")
	public void userRegisterTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		
		Assert.assertTrue(registerPage.userRegisteration(firstName, lastName, telephone, password, subscribe));
	
	}
	
	
	

}
