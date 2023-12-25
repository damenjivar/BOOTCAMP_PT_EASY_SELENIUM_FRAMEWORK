package com.bootcamp.pt1.easy_selenium_framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Q2_Easy_Selenium_Framework {

	// Q2: Write a TestNG test to fill out a login form on a website and verify
	// successful login with valid credentials.

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
	}

	@Test
	public void verifyLoginWithValidCredentials() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualEditYourAccountInfoLink = driver
				.findElement(By.xpath("//a[contains(text(), 'Edit your account information')]")).getText();
		String expectedEditYourAccountInfoLink = "Edit your account information";
		Assert.assertEquals(actualEditYourAccountInfoLink, expectedEditYourAccountInfoLink, "Login unsuccessful");
		System.out.println("Verifying if edit your account information link appears after successful login: " + actualEditYourAccountInfoLink);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
