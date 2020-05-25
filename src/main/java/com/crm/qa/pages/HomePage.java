package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{

	//page factory -OR
	@FindBy(xpath="//span[@class='user-display']")
	WebElement usernamelable;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement deals;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasks;
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContacts() {
	contacts.click();
	new TestUtil().waitForSomeTime(5);
	return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
	deals.click();
	return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
	tasks.click();
	return new TasksPage();
	}
	
	public String getUserNameCorrect() {
		return usernamelable.getText();
	}
}
