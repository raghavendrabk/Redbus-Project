package com.Cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	public WebDriver driver;

	@Given("^User navigates to zoo website$")
	public void navigate() {
		System.out.println("User navigates to zoo");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www190.lunapic.com/editor/");
	}

	@When("^User enters valid crednetials$")
	public void entry() {
		System.out.println("User enters valid credentials");
		WebElement file = driver.findElement(By.xpath("//a[text()='File']"));
		Actions action = new Actions(driver);
		action.moveToElement(file).click().perform();
		WebElement webcamCapture = driver.findElement(By
				.xpath("//a[text()='Webcam Capture']"));
		webcamCapture.click();
	}

	@Then("^i check to validate zoo page is displayed$")
	public void checkPage() {
		System.out.println("User enters valid credentials");
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "LunaPic | Free Online Photo Editor | Webcam Capture";
		try {
			Assert.assertEquals(actualPageTitle, expectedPageTitle);
			Reporter.log("Page validation passed", true);
		} catch (Exception e) {
			Reporter.log("Page validation failed", true);
		}

		// System.out.println("pageTitle:" + actualPageTitle);

	}
}
