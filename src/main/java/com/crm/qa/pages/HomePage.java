package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[@class='user-display']")
	WebElement user_display;

	@FindBy(xpath = "//div[@class='header item']")
	WebElement log_CRM;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contacts_link;
	
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement deals_link;
	
	public HomePage() throws IOException {
		//super();
		PageFactory.initElements(driver, this);

	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean verifyUserName() {
		return user_display.isDisplayed();
	}
	public boolean verifyCRMLog() {
		return log_CRM.isDisplayed();
	}
	
	public ContactsPage clickOnContactsPage() throws IOException {
		contacts_link.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsPage() {
		deals_link.click();
		return new DealsPage();
	}
	

}
