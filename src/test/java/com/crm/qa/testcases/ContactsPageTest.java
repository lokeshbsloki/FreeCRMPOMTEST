package com.crm.qa.testcases;


import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;



public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetName="Contacts";

	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testutil = new TestUtil();
		 loginpage=new LoginPage();
		 contactspage =new ContactsPage();
		 homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		 contactspage= homepage.clickOnContacts();
	}
	
	@Test(priority = 1)
	public void verifyContactsLabelTest() {
		String lable = contactspage.getContactsLable();
		System.out.println(lable+"wowwww");
		Assert.assertEquals(lable, "Contacts");
	}
	@Test(priority = 2)
	public void selectContactsByNameTest() {
		contactspage.selectContactByName("lokesh 8618958043 bs");
		testutil.waitForSomeTime(5);
	}
	
	@Test(priority = 3)
	public void selectMultipleContactsByNameTest() {
		contactspage.selectContactByName("lokesh 8618958043 bs");
		contactspage.selectContactByName("anusha 87657487574 m");
		testutil.waitForSomeTime(5);
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		
		Object[][] data = testutil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 4,dataProvider = "getCRMTestData")
	public void validateCreateNewContactTest(String text,String ftname,String ltname,String company) {
		contactspage.clickOnNewContact();
		testutil.waitForSomeTime(4);
		contactspage.createNewContact(text,ftname ,ltname , company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
