package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase {

	public ContactsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactslable;
	
//  not recommended 	
//	@FindBy(xpath="//td[contains(text(),'lokesh 8618958043 bs')]//preceding-sibling::td")
//	WebElement lokeshcheckbox;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newcontact;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastname;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	WebElement company;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement savebutton;
	
	
	
	public String getContactsLable() {
		return contactslable.getText();
	}
	
	public void selectContactByName(String name) {
	
		driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]//preceding-sibling::td")).click();
	}
	
	public void clickOnNewContact() {
		newcontact.click();
		new TestUtil().waitForSomeTime(5);
	}
	
	public void createNewContact(String text,String ftname,String ltname,String companyname) {
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		
		driver.findElement(By.xpath("//div[@name='category']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'"+text+"')]")).click();
		company.sendKeys(companyname);
		new TestUtil().waitForSomeTime(3);
		savebutton.click();
		new TestUtil().waitForSomeTime(3);
        driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
		new TestUtil().waitForSomeTime(3);

	}
}
