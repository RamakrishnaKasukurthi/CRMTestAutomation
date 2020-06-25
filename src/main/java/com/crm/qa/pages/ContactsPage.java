package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	ContactsPage contactsPage;

	@FindBy(xpath = "//*[contains(text(),'New')]")
	WebElement contactsPageNewBtn;

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement contactsPageNewHeader;

	@FindBy(name = "first_name")
	WebElement contactsPageNewFirstName;

	@FindBy(name = "last_name")
	WebElement contactsPageNewLastName;

	@FindBy(xpath = "//div[@name='company']//input[@class='search']")
	WebElement contactsPageNewSearch;

	@FindBy(xpath = "//*[contains(text(),'Save')]")
	WebElement contactsPageNewSaveBtn;

	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);

	}

	public String verifyContactsPageTitle() {
		return driver.getTitle();

	}

	public boolean verifyContactsPageHeader() {
		contactsPageNewBtn.click();
		return contactsPageNewHeader.isDisplayed();

	}

	/*
	 * public void clickOnNewContactButton() { contactsPageNewBtn.click();
	 * 
	 * }
	 */
	public void createNewContact(String fName, String lName, String companyName) throws InterruptedException {
		contactsPageNewBtn.click();

		contactsPageNewFirstName.sendKeys(fName);
		contactsPageNewLastName.sendKeys(lName);
		contactsPageNewSearch.sendKeys(companyName);
		contactsPageNewSaveBtn.click();

	}

}
