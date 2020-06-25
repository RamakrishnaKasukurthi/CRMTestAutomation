package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
HomePage homePage;
ContactsPage contactsPage;
DealsPage dealsPage;
	public HomePageTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
		contactsPage =new ContactsPage();
		dealsPage=new DealsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}
@Test(priority = 1)
	public void verifyHomePageTitleTest() {
	String homePageTitle=homePage.verifyHomePageTitle();
	Assert.assertEquals(homePageTitle, "Cogmento CRM");
	}
@Test(priority = 2)
public void verifyCTMLogTest() {
	boolean log_CRM=homePage.verifyCRMLog();
	Assert.assertEquals(log_CRM, true);
}

@Test(priority = 3)
	public void clickOnContactsPageTest() throws IOException {
	
	contactsPage=homePage.clickOnContactsPage();
	
	
	}
@Test(priority = 4)
public void clickOnDealsPageTest() {
	
	dealsPage=homePage.clickOnDealsPage();
}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}
