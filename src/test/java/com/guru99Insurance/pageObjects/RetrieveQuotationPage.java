package com.guru99Insurance.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.guru99Insurance.testCases.BaseClass;

public class RetrieveQuotationPage extends BaseClass{

	public RetrieveQuotationPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='id']")
	WebElement txtIdentificationNumber;
	@FindBy(id="getquote")
	WebElement retrieveBtn;
	@FindBy(xpath="//input[@value='Log out']")
	WebElement logoutBtn;

	public void validateQuotation() throws Exception
	{
		txtIdentificationNumber.click();
		txtIdentificationNumber.sendKeys("12454");
		retrieveBtn.click();		

		int rows=driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();
		System.out.println("No. of Rows--->"+rows);

		int cols=driver.findElements(By.xpath("/html/body/table/tbody/tr[1]/td")).size();
		System.out.println("No. of Columns--->"+cols);

		for(int i=1;i<=rows;i++)
		{
			for(int j=1;j<=cols;j++)
			{
				try {
					String text=driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td["+j+"]")).getText();
					System.out.print(text +  "|");
				} 
				catch (NoSuchElementException e) {

				}
			}

			System.out.println("\n");
		}

		driver.navigate().back();
		logoutBtn.click();
	}


}


