package com.opencart.qa.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.opencart.qa.factory.DriverFactory;
import com.opencart.qa.listeners.TestAllureListener;
import com.opencart.qa.pages.HomePage;
import com.opencart.qa.pages.LoginPage;
import com.opencart.qa.pages.ProductInfoPage;
import com.opencart.qa.pages.RegisterPage;
import com.opencart.qa.pages.ResultsPage;


//@Listeners({ChainTestListener.class, TestAllureListener.class})
public class BaseTest {

	protected WebDriver driver;
	protected Properties prop;
	
	DriverFactory df;
	
	protected LoginPage loginPage;
	protected HomePage homePage;
	protected ResultsPage resultsPage;
	protected ProductInfoPage productInfoPage;
	protected RegisterPage registerPage;

	@Parameters({"browser"})
	@BeforeTest
	public void setup(@Optional("chrome") String browserName) {
		df = new DriverFactory();
		prop = df.initProp();
		
			if(browserName!=null) { //browserName is coming from xml file
				prop.setProperty("browser", browserName);
			}	
		
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
	}
	
	
	@AfterMethod // will be running after each @test method
	public void attachScreenshot(ITestResult result) {
		
		if (!result.isSuccess()) {// only for failure test cases -- true
			ChainTestListener.embed(DriverFactory.getScreenshotFile(), "image/png");
		}

		//ChainTestListener.embed(DriverFactory.getScreenshotFile(), "image/png");

	}
	
	
	

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

