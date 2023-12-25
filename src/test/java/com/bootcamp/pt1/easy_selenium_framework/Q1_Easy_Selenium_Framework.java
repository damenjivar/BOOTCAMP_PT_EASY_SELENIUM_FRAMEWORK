package com.bootcamp.pt1.easy_selenium_framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Q1_Easy_Selenium_Framework {

	// Q1: Write a TestNG test to navigate to a website and verify the title of the
	// page.

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
	}

	@Test
	public void verifyPageTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Your Store";
		System.out.println("Page title of Tutorials Ninja is: " + actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}