package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page factory 
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//*[@class='ui fluid large blue submit button']")
	WebElement loginBtn;

	//Initializing the page objects 
	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);
		
	}
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	public HomePage login(String un, String pwd) throws IOException {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		loginBtn.click();
		
		return new HomePage();
		
	}
	

}
