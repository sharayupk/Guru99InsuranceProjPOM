package com.guru99Insurance.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.guru99Insurance.testCases.BaseClass;

public class RegisterPage extends BaseClass{

	public RegisterPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".content h1")
	WebElement signUpText;
	@FindBy(id="user_firstname")
	WebElement txtfirstName;
	@FindBy(id="user_surname")
	WebElement txtSurName;
	@FindBy(id="user_phone")
	WebElement txtPhone;
	@FindBy(name="year")
	WebElement yearDrpDown;
	@FindBy(name="month")
	WebElement monthDrpDown;
	@FindBy(name="date")
	WebElement daydrpDown;
	@FindBy(id="user_licenceperiod")
	WebElement licencePeriodDrpDown;
	@FindBy(id="user_occupation_id")
	WebElement occupationDrpDown;
	@FindBy(name="street")
	WebElement txtStreet;
	@FindBy(name="city")
	WebElement txtCity;
	@FindBy(name="county")
	WebElement txtCountry;
	@FindBy(name="post_code")
	WebElement txtPostCode;
	@FindBy(name="email")
	WebElement txtEmail;
	@FindBy(name="password")
	WebElement txtPassword;
	@FindBy(name="c_password")
	WebElement txtConPassword;
	@FindBy(name="submit")
	WebElement createBtn;

	public String validateRegisterPageURL()
	{
		return driver.getCurrentUrl();
	}

	public String validateRegisterPageText()
	{
		return signUpText.getText();
	}

	public LoginPage registerUser(String fn,String sn,String phone,String year,String month,String day,String licence,String occupation,
			String street,String city,String country,String postcode,String email,String pwd,String conpwd)
	{
		txtfirstName.sendKeys(fn);
		txtSurName.sendKeys(sn);
		txtPhone.sendKeys(phone);

		//Select Year from Drop Down
		Select yr= new Select(yearDrpDown);
		yr.selectByVisibleText(year);

		//Select Month from Drop Down
		Select mon= new Select(monthDrpDown);
		mon.selectByVisibleText(month);

		//Select Day from Drop Down
		Select d= new Select(daydrpDown);
		d.selectByVisibleText(day);

		//Select Licence Period from Drop Down
		Select l= new Select(licencePeriodDrpDown);
		l.selectByVisibleText(licence);

		//Select Occupation from Drop Down
		Select occu= new Select(occupationDrpDown);
		occu.selectByVisibleText(occupation);

		txtStreet.sendKeys(street);
		txtCity.sendKeys(city);
		txtCountry.sendKeys(country);
		txtPostCode.sendKeys(postcode);
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(pwd);
		txtConPassword.sendKeys(conpwd);
		createBtn.click();

		return new LoginPage();
	}

}
