/*package com.Cucumber;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.FirefoxLauncher;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CommonStepDefinition {

	public static WebDriver driver;
	Properties prop;
	
	@Before
	public void BrowserSetup() throws Exception{
		driver = new DriverFactory().createNewDriverInstance();
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\RAGHAVENDRA\\workspace\\CucumberConcepts\\src\\com\\Cucumber\\CommonLibrary.Properties");
		prop.load(fis);
		String URL = prop.getProperty("URL");
		System.out.println("URL:" + URL);
	    driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//return driver;
	}
	
	@After
	public void tearDown() throws Exception{
		new Driverfactory().destroyDriver();
	}
}	
	*/