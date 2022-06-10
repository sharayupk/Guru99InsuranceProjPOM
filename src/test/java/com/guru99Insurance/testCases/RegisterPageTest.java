package com.guru99Insurance.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99Insurance.pageObjects.HomePage;
import com.guru99Insurance.pageObjects.LoginPage;
import com.guru99Insurance.pageObjects.RegisterPage;

public class RegisterPageTest extends BaseClass{

	HomePage homePage;
	RegisterPage registerPage;
	LoginPage loginPage;

	public RegisterPageTest()
	{
		super();
	}

	@Test(priority=1)
	public void validateRegisterPageURLTest()
	{
		homePage=new HomePage();

		registerPage=homePage.clickOnRegisterBtn();
		String actRegisterPageURL=registerPage.validateRegisterPageURL();
		Assert.assertEquals(actRegisterPageURL, "https://demo.guru99.com/insurance/v1/register.php");

		logger.info("Validated Register Page URL");
	}

	@Test(priority=2)
	public void validateRegisterPageTextTest()
	{
		homePage=new HomePage();

		registerPage=homePage.clickOnRegisterBtn();
		String actRegisterPageText=registerPage.validateRegisterPageText();
		Assert.assertEquals(actRegisterPageText, "Sign up as a new user");

		logger.info("Validated Register Page Text");

	}

	@Test(priority=3)
	public void registerUserTest()
	{
		homePage=new HomePage();

		registerPage=homePage.clickOnRegisterBtn();	

		loginPage=registerPage.registerUser(prop.getProperty("firstName"), prop.getProperty("surName"), prop.getProperty("phone"), prop.getProperty("year"), prop.getProperty("month"), 
				prop.getProperty("day"), prop.getProperty("licencePeriod"), prop.getProperty("occupation"), prop.getProperty("street"), prop.getProperty("city"), 
				prop.getProperty("country"), prop.getProperty("postCode"), prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("conPassword"));

		logger.info("Successfully Registered User");
	}


}
