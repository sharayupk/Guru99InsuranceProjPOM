package com.guru99Insurance.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99Insurance.testCases.BaseClass;

public class LoginPage extends BaseClass{

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".content h3")
	WebElement loginText;
	@FindBy(id="email")
	WebElement txtUsername;
	@FindBy(id="password")
	WebElement txtPassword;
	@FindBy(name="submit")
	WebElement loginBtn;
	@FindBy(id="ui-id-2")
	WebElement requestQuotationBtn;

	public String validateLoginPageURL()
	{
		return driver.getCurrentUrl();
	}

	public String validateLoginPageText()
	{
		return loginText.getText();
	}

	public RequestQuotationPage loginToApplication(String un,String pwd)
	{
		txtUsername.sendKeys(un);
		txtPassword.sendKeys(pwd);
		loginBtn.click();
		
		//requestQuotationBtn.click();
		
		return new RequestQuotationPage();
		
		
		
	}

}
