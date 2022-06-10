package com.guru99Insurance.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99Insurance.pageObjects.HomePage;
import com.guru99Insurance.pageObjects.LoginPage;
import com.guru99Insurance.pageObjects.RegisterPage;
import com.guru99Insurance.pageObjects.RequestQuotationPage;
import com.guru99Insurance.pageObjects.RetrieveQuotationPage;

public class RequestQuotationPageTest extends BaseClass{

	HomePage homePage;
	RegisterPage registerPage;
	LoginPage loginPage;
	RequestQuotationPage reqQuotationPage;
	RetrieveQuotationPage retrieveQuotationPage;

	public RequestQuotationPageTest()
	{
		super();
	}

	@Test(priority=1)
	public void validateRequestQuotationPageTextTest()
	{
		homePage=new HomePage();

		loginPage=homePage.clickOnLoginBtn();

		reqQuotationPage=loginPage.loginToApplication(prop.getProperty("email"),prop.getProperty("password"));

		String actRequestQuotationPageText=reqQuotationPage.validateRequestQuotationPageText();
		Assert.assertEquals(actRequestQuotationPageText, "ankush12@gmail.com");

		logger.info("Validated Request Quotation Page Text");

	}

	@Test(priority=2)
	public void requestQuotationTest() throws InterruptedException
	{
		homePage=new HomePage();

		loginPage=homePage.clickOnLoginBtn();

		reqQuotationPage=loginPage.loginToApplication(prop.getProperty("email"),prop.getProperty("password"));

		retrieveQuotationPage=reqQuotationPage.requestQuotation(prop.getProperty("incidents"), prop.getProperty("registration"), prop.getProperty("annualMileage"), prop.getProperty("estimatedValue"), 
				prop.getProperty("parkingLocation"),prop.getProperty("policyYear"), prop.getProperty("policyMonth"), prop.getProperty("policyDay"));

		logger.info("Successfully Requested Quotation");
	}



}
