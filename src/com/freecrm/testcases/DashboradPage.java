package com.freecrm.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DashboradPage extends TestBase{
	
	
	
	@BeforeMethod 
	public void setUpDriver() {
		
		
		
		initiateDriver("https://ui.freecrm.com/");
		
	}
	
	@AfterMethod 
	public void tearDown() {
		
		WebElement settingsIcon = driver.findElement(By.xpath("//i[@class='settings icon']"));
		settingsIcon.click();
		WebElement logOutIcon = driver.findElement(By.linkText("Log Out"));
		logOutIcon.click();
		driver.close();
		
	}
	
	@Test (priority = 1)
	public void testLoginProcess() throws IOException {
		
		WebElement userDisplay = driver.findElement(By.className("user-display"));
		String expectedUserDisplayText = "Hani Darraj";
		String acutalUserDisplayText = userDisplay.getText();
		Assert.assertEquals(acutalUserDisplayText, expectedUserDisplayText);
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C:\\Users\\hanou\\eclipse-workspace\\FreeCRMApplication\\Snapshots\\testLoginProcess.png"));
		
		
	}
	
	@Test (priority = 2)
	public void clickOnCalender() throws IOException {
		
		WebElement calender = driver.findElement(By.linkText("Calendar"));
		calender.click();
		String expectedCalCurrentUrl = "https://ui.freecrm.com/calendar";
		String actualCalCurrentUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualCalCurrentUrl, expectedCalCurrentUrl);
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C:\\Users\\hanou\\eclipse-workspace\\FreeCRMApplication\\Snapshots\\clickOnCalender.png"));
		
	}
	
	@Test (priority = 3)
	public void clickOnContacts() throws IOException {
		
		WebElement calender = driver.findElement(By.linkText("Contacts"));
		calender.click();
		String expectedContactCurrentUrl = "https://ui.freecrm.com/contacts"; 
		String actualContactCurrentUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualContactCurrentUrl, expectedContactCurrentUrl);
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C:\\Users\\hanou\\eclipse-workspace\\FreeCRMApplication\\Snapshots\\clickOnContacts.png"));
		
	}
	
	
	

}
