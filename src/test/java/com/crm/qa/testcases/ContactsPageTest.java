package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	public ContactsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
		homePage =new HomePage();
		contactsPage =new ContactsPage();
		//dealsPage=new DealsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.clickOnContactsPage();
	
	}
	
	@Test(priority = 1)
public void verifyContactsPageTitleTest() {
	String ContactsPageTitle=contactsPage.verifyContactsPageTitle();
	Assert.assertEquals(ContactsPageTitle, "Cogmento CRM");
}
	
	@Test(priority = 2)
	public void verifyContactsPageHeaderTest() {
		
		boolean ContactsPageHeader=contactsPage.verifyContactsPageHeader();
		Assert.assertEquals(ContactsPageHeader, true);
	}
	@Test(priority = 3)
	public void createNewContactTest() throws InterruptedException {
	//contactsPage.clickOnNewContactButton();
		contactsPage.createNewContact("Ramakrishna", "K", "Hexa");
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
