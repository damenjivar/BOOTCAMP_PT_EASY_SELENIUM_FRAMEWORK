package com.bootcamp.pt1.easy_selenium_framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Q3_Easy_Selenium_Framework {

	// Q3: Write a TestNG test to navigate to a website, click on a link to navigate
	// to a different page, and verify the presence of certain elements on the new
	// page.

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
	}

	@Test
	public void verifyPresenceOfElementOnNewPage() {
		driver.findElement(By.xpath("//a[text() = 'Desktops']")).click();
		driver.findElement(By.xpath("//a[text() = 'Mac (1)']")).click();
		String actualElement = driver.findElement(By.xpath("//a[text() = 'iMac']")).getText();
		String expectedElement = "iMac";
		Assert.assertEquals(actualElement, expectedElement, "element iMac is not present");
		System.out.println("Element to be present: " + actualElement);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}