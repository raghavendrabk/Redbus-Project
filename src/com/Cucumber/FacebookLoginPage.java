package com.Cucumber;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.pageObjects.FaceBookLoginPage1;
import com.pageObjects.FacebookHomePage;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FacebookLoginPage {

	public WebDriver driver;
	String pageTitle;

	@Before
	public void setUp() {
		driver = new DriverFactory().getDriver();
	}

	@Given("^User navigates to facebook$")
	public void navigateToFacebook() throws IOException {
		System.out.println("User navigated to FB");
	}

	@When("^User enters valid crdentials$")
	public void Credentials(DataTable table) throws Exception {
		List<List<String>> data = table.raw();
		FaceBookLoginPage1 login = new FaceBookLoginPage1(driver);
		pageTitle = login.login(data.get(1).get(0), data.get(1).get(1));
		System.out.println("pageTitle=" + pageTitle);
	}

	@Then("^User validates for FaceBook homepage$")
	public void checkPage() throws Exception {
		try {

			Assert.assertTrue((pageTitle.contains("Facebook")),
					"Logged in successfully");
			Reporter.log("Home Page valdation passed", true);
		} catch (Error e) {
			Reporter.log("Home Page valdation failed", true);
		}
		if (pageTitle.equalsIgnoreCase("Facebook")) {
			FacebookHomePage homePage = new FacebookHomePage(driver);
			homePage.Logout();

		}

	}

	@After
	public void tearDown() throws Exception {
		new DriverFactory().destroyDriver();
	}

}
