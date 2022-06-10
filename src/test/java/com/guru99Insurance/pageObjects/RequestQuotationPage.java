package com.guru99Insurance.pageObjects;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.guru99Insurance.testCases.BaseClass;

public class RequestQuotationPage extends BaseClass{

	public RequestQuotationPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".content h4")
	WebElement emailText;
	@FindBy(name="incidents")
	WebElement txtIncidents;
	@FindBy(name="registration")
	WebElement txtRegistration;
	@FindBy(name="mileage")
	WebElement txtMileage;
	@FindBy(name="value")
	WebElement txtEstimatedValue;
	@FindBy(name="parkinglocation")
	WebElement parkingLocationDrpDown;
	@FindBy(name="year")
	WebElement policyYearDrpDown;
	@FindBy(name="month")
	WebElement policyMonthDrpDown;
	@FindBy(name="date")
	WebElement policyDayDrpDown;
	@FindBy(name="submit")
	WebElement saveQuotationBtn;
	@FindBy(xpath="//html/body")
	WebElement incidentNumber;
	@FindBy(id="ui-id-3")
	WebElement retrieveQuotationBtn;


	public String validateRequestQuotationPageText()
	{
		return emailText.getText();
	}

	public RetrieveQuotationPage requestQuotation(String incident,String registration,String mileage,String value,String parkinglocation,
			String year,String month,String day ) throws InterruptedException
	{
		txtIncidents.sendKeys(incident);
		txtRegistration.sendKeys(registration);
		txtMileage.sendKeys(mileage);
		txtEstimatedValue.sendKeys(value);

		//Select Parking Location from Drop Down
		Select parking=new Select(parkingLocationDrpDown);
		parking.selectByVisibleText(parkinglocation);

		//Select Policy Year from Drop Down
		Select policyYear=new Select(policyYearDrpDown);
		policyYear.selectByVisibleText(year);

		//Select Policy Month from Drop Down
		Select policyMonth=new Select(policyMonthDrpDown);
		policyMonth.selectByVisibleText(month);

		//Select Policy Day from Drop Down
		Select policyDay=new Select(policyDayDrpDown);
		policyDay.selectByVisibleText(day);

		saveQuotationBtn.click();

		//Get Incident Number
		String my_string = incidentNumber.getAttribute("innerHTML");
		String[] stringParts = my_string.split(Pattern.quote("<br>"));
		String partA = stringParts[0];
		String partB = stringParts[1];
		System.out.println("PartB:"+partB);

		System.out.println("Incident Number :"+partB.split(":")[1].trim().replaceAll("</b>", ""));

		driver.navigate().back();

		Thread.sleep(2000);

		//Click on Retrieve QuotationBtn Btn
		retrieveQuotationBtn.click();

		return new RetrieveQuotationPage();


	}

}
