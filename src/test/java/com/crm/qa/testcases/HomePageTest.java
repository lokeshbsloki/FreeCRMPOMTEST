package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testutil = new TestUtil();
		 loginpage=new LoginPage();
		 contactspage =new ContactsPage();
		 homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homepagetitle = homepage.getHomePageTitle();
		System.out.println(homepagetitle);
		Assert.assertEquals(homepagetitle, "Cogmento CRM");
	}
	@Test(priority = 2)
	public void verifyUserNametest() {
		String username = homepage.getUserNameCorrect();
		Assert.assertEquals(username, "Lokesh BS");
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		 contactspage = homepage.clickOnContacts();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
