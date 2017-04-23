package com.Cucumber;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;

import com.pageObjects.FaceBookLoginPage1;
import com.pageObjects.FaceBookRightClick;
import com.pageObjects.FacebookHomePage;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FacebookRightClick {

	String url;
	String pageTitle;
	String username, password;
	public WebDriver driver;
	public Properties prop;

	/*@Before
	public void LaunchBrowser() throws IOException {
		
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\RAGHAVENDRA\\workspace\\CucumberConcepts\\src\\com\\Cucumber\\CommonLibrary.Properties");
		prop = new Properties();
		prop.load(fis);
		if (prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
			System.out.println("Launching Firefox browser");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.get("http://rediffmail.com");
		}

	}
*/
	@Given("^User Navigates to Facebook website$")
	public void NavigateToFaceBook(DataTable table) throws Exception {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\RAGHAVENDRA\\workspace\\CucumberConcepts\\src\\com\\Cucumber\\CommonLibrary.Properties");
		prop.load(fis);
		url = prop.getProperty("URL");
		driver.get(url);
		List<List<String>> credentials = table.raw();
		username = credentials.get(1).get(0);
		password = credentials.get(1).get(1);
		System.out.println("Username=" + username);
		FaceBookLoginPage1 login = new FaceBookLoginPage1(driver);
		pageTitle = login.login(username, password);
	}

	@When("^User right clicks$")
	public void rightClick() {
		FaceBookRightClick rightClick = new FaceBookRightClick(driver);
		rightClick.rightClick();

	}

	/*
	 * @And("^selects View Page Source option$") public void
	 * selectViewPageSource(){
	 * 
	 * }
	 */

	@Then("^i check to verify respective window is opened$")
	public void checkPageTitle() {
		String expected = "Facebook";
		try {
			Assert.assertEquals(pageTitle, expected);
			Reporter.log("Validation Passed", true);
		} catch (Exception e) {
			Reporter.log("Validation Failed", true);
		}

	}

	@And("^User Logsout$")
	public void logout() throws Exception {
		FacebookHomePage logout = new FacebookHomePage(driver);
		logout.Logout();
	}

}
