package com.freecrm.testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BeforeAndAfterDemo {

	
	WebDriver driver;
	
	@BeforeMethod 
	public void driverSetUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod 
	public void driverShutDown() {
		
		driver.close();
	}
	
	@Test (priority = 1)
	public void getLoginPageTitle() {
		
		
		String url = "https://freecrm.com/";
		driver.get(url);
		String expectedPageTitle = "Free CRM #1 cloud software for any business large or small";
		String actualPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		System.out.println(actualPageTitle);
		
		
	}
	
	@Test (priority = 2)
	public void checkLogoIsDisplayed() {
		
		String url = "https://freecrm.com/";
		driver.get(url);
		boolean expectedLogoIsDisplayed = true;
		WebElement actualLogoIsDisplayed = driver.findElement(By.className("brand-name"));
		boolean actalResult = actualLogoIsDisplayed.isDisplayed();
		Assert.assertEquals(actalResult, expectedLogoIsDisplayed);
		System.out.println(actalResult);
		
		
	}
	
	@Test (priority = 3)
	public void getCurrentUrl() {
		
		
		String url = "https://freecrm.com/";
		driver.get(url);
		String expectedlCurrentUrl = "https://freecrm.com/";
		String actualCurrentUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualCurrentUrl, expectedlCurrentUrl);
		System.out.println(actualCurrentUrl);
		
		
	}
	
	
	
	@Test (priority = 4)
	public void loginToAccount () {
		
		
		String url = "https://ui.freecrm.com/";
		driver.get(url);
		WebElement emailFeild = driver.findElement(By.name("email"));
		emailFeild.sendKeys("hanoush583@gmail.com");
		WebElement passwordFeild = driver.findElement(By.name("password"));
		passwordFeild.sendKeys("HAni123456789");
		WebElement loginButton = driver.findElement(By.xpath("//div[@class = 'ui fluid large blue submit button']"));
		loginButton.click();
		boolean expectedIconIsDisplayed = true;
		WebElement freeAccountIcon = driver.findElement(By.linkText("Free account"));
		boolean freeAccountIconIsDisplayed = freeAccountIcon.isDisplayed();
		Assert.assertEquals(freeAccountIconIsDisplayed, expectedIconIsDisplayed);
		System.out.println(freeAccountIconIsDisplayed);
		
		
	}

}
