package com.guru99Insurance.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99Insurance.pageObjects.HomePage;
import com.guru99Insurance.pageObjects.LoginPage;
import com.guru99Insurance.pageObjects.RegisterPage;
import com.guru99Insurance.pageObjects.RequestQuotationPage;

public class LoginPageTest extends BaseClass{

	HomePage homePage;
	LoginPage loginPage;
	RequestQuotationPage reqQuotationPage;

	public LoginPageTest()
	{
		super();
	}

	@Test(priority=1)
	public void validateLoginPageURLTest()
	{
		homePage=new HomePage();

		loginPage=homePage.clickOnLoginBtn();

		String actLoginPageURL=loginPage.validateLoginPageURL();
		Assert.assertEquals(actLoginPageURL, "https://demo.guru99.com/insurance/v1/index.php");

		logger.info("Validated Login Page URL");
	}

	@Test(priority=2)
	public void validateLoginPageTextTest()
	{
		homePage=new HomePage();

		loginPage=homePage.clickOnLoginBtn();

		String actLoginPageText=loginPage.validateLoginPageText();
		Assert.assertEquals(actLoginPageText, "Login");

		logger.info("Validated Login Page Text");
	}

	@Test(priority=3)
	public void loginToApplicationTest()
	{
		homePage=new HomePage();

		loginPage=homePage.clickOnLoginBtn();

		reqQuotationPage=loginPage.loginToApplication(prop.getProperty("email"),prop.getProperty("password"));

		logger.info("Successfully Login To Application");
	}
}
