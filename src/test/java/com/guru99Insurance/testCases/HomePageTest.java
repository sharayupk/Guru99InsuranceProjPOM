package com.guru99Insurance.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99Insurance.pageObjects.HomePage;
import com.guru99Insurance.pageObjects.LoginPage;
import com.guru99Insurance.pageObjects.RegisterPage;

public class HomePageTest extends BaseClass{

	HomePage homePage;
	RegisterPage registerPage;
	LoginPage loginPage;

	public HomePageTest()
	{
		super();
	}

	@Test(priority=1)
	public void validateHomePageURLTest()
	{
		homePage=new HomePage();

		String actHomePageURL=homePage.validateHomePageURL();
		Assert.assertEquals(actHomePageURL, prop.getProperty("url"));

		logger.info("Validated Home Page URL");
	}

	@Test(priority=2)
	public void validateHomePageLogoTest()
	{
		homePage=new HomePage();

		boolean actHomePageLogo=homePage.validateHomePageLogo();
		Assert.assertTrue(actHomePageLogo);

		logger.info("Validated Home Page Logo");
	}

	@Test(priority=3)
	public void validateHomePageTitleTest()
	{
		homePage=new HomePage();

		String actHomePageTitle=homePage.validateHomePageTitle();
		Assert.assertEquals(actHomePageTitle, "Insurance Broker System - Login");

		logger.info("Validated Home Page Title");
	}	

	@Test(priority=4)
	public void clickOnRegisterBtnTest()
	{
		homePage=new HomePage();

		registerPage=homePage.clickOnRegisterBtn();	

		logger.info("Clicked On Register Btn");
	}

	@Test(priority=5)
	public void clickOnLoginBtnTest()
	{
		homePage=new HomePage();

		loginPage=homePage.clickOnLoginBtn();

		logger.info("Clicked On Login Btn");
	}

}
