package com.guru99Insurance.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99Insurance.pageObjects.HomePage;
import com.guru99Insurance.pageObjects.LoginPage;
import com.guru99Insurance.pageObjects.RegisterPage;
import com.guru99Insurance.pageObjects.RequestQuotationPage;
import com.guru99Insurance.pageObjects.RetrieveQuotationPage;

public class RetrieveQuotationPageTest extends BaseClass{

	HomePage homePage;
	RegisterPage registerPage;
	LoginPage loginPage;
	RequestQuotationPage reqQuotationPage;
	RetrieveQuotationPage retrieveQuotationPage;

	public RetrieveQuotationPageTest()
	{
		super();
	}

	@Test(priority=1)
	public void validateQuotationTest() throws Exception 
	{
		homePage=new HomePage();

		loginPage=homePage.clickOnLoginBtn();

		reqQuotationPage=loginPage.loginToApplication(prop.getProperty("email"),prop.getProperty("password"));

		retrieveQuotationPage=reqQuotationPage.requestQuotation(prop.getProperty("incidents"), prop.getProperty("registration"), prop.getProperty("annualMileage"), prop.getProperty("estimatedValue"), 
				prop.getProperty("parkingLocation"),prop.getProperty("policyYear"), prop.getProperty("policyMonth"), prop.getProperty("policyDay"));

		retrieveQuotationPage.validateQuotation();

		logger.info("Validated Quotation");
	}



}
