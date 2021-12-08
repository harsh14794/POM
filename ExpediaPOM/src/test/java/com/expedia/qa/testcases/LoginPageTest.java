package com.expedia.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.expedia.qa.pages.LoginPage;
import com.expedia.qa.testbase.TestBase;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test
	public void ValidateTitle() {
		String title = loginpage.ValidateLoginPageTitle();
		Assert.assertEquals(title, "Travel with Expedia.ca: Vacation Homes, Hotels, Car Rentals, Flights & More");
	}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
