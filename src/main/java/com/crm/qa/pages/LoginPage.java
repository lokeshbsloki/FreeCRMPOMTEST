package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//page factory -OR
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signup;
	
	@FindBy(xpath="//*[name()='circle' and contains(@class,'background')]")
	WebElement crmlogo;
	
	//to initialize this page variables
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isLogoDisplayed() {
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String uname,String pwd) {
		
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
		
		return new HomePage();
	}
	
	
	
	
	
}
