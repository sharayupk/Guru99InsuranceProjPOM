package com.guru99Insurance.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99Insurance.pageObjects.HomePage;
import com.guru99Insurance.pageObjects.LoginPage;
import com.guru99Insurance.utilities.XLUtils;

public class LoginPageDDT extends BaseClass{

	HomePage homePage;
	LoginPage loginPage;
	boolean flag;

	@Test(dataProvider="loginData")
	public void loginToApplication(String username,String pwd) throws InterruptedException
	{
		homePage=new HomePage();

		loginPage=homePage.clickOnLoginBtn();

		loginPage.loginToApplication(username,pwd);

		Thread.sleep(2000);

		if(isTextPresent()==true)
		{
			Assert.assertTrue(false);
			//logger.warn("Login Failed");
		}

		else
		{
			Assert.assertTrue(true);
			//logger.info("Login Passed");
		}

	}

	public boolean isTextPresent()
	{
		try {
			driver.findElement(By.xpath("//*[@id='login-form']/div[2]/span/b")).isDisplayed();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@DataProvider
	public Object[][] loginData() throws IOException
	{
		String excelPath= System.getProperty("user.dir")+"\\src\\test\\java\\com\\guru99Insurance\\testData\\loginData.xlsx";
		int rows=XLUtils.getRowCount(excelPath, "Sheet1");
		int cols=XLUtils.getCellCount(excelPath, "Sheet1", 0);

		String loginData[][]=new String[rows][cols];

		for(int i=1;i<=rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(excelPath, "Sheet1", i, j);
			}
		}
		return loginData;

	}

}
