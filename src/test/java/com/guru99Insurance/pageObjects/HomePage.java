package com.guru99Insurance.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99Insurance.testCases.BaseClass;

public class HomePage extends BaseClass{

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="img[role='presentation']")
	WebElement guru99Logo;
	@FindBy(xpath="//a[text()='Register']")
	WebElement registerbtn;
	@FindBy(id="email")
	WebElement loginBtn;

	public boolean validateHomePageLogo()
	{
		return guru99Logo.isDisplayed();
	}

	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}

	public String validateHomePageURL()
	{
		return driver.getCurrentUrl();
	}

	public RegisterPage clickOnRegisterBtn()
	{
		registerbtn.click();

		return new RegisterPage();
	}

	public LoginPage clickOnLoginBtn()
	{
		loginBtn.click();

		return new LoginPage();
	}

}
