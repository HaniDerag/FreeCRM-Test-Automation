package com.freecrm.testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingDataProvidor {
	
WebDriver driver;
	
	@BeforeMethod (groups = {"E2E"})
	public void setUpDriver() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		String url1 = "https://freecrm.com/";
		driver.get(url1);
		WebElement loginUrl = driver.findElement(By.linkText("Log In"));
		Actions actions = new Actions(driver);
		actions.moveToElement(loginUrl).click().build().perform();
		
		
		
		
		
	}
	
	@DataProvider
	public Object[][] myData() {
		
		Object [] [] data = new Object[4] [2];
		data [0][0] = "hanoush583@gmail.com";
		data [0][1] = "HAni123456789";
		data [1][0] = "hhandh@yahoo.com";
		data [1][1] = "HAni123456789";
		data [2][0] = "hanoush583@gmail.com";
		data [2][1] = "hfhfjj7fu77";
		data [3][0] = "hhfhfjj542@gmail.com";
		data [3][1] = "hfhfjfuf7uu";
		return data;
		
		
	}
	
	@AfterMethod (groups = {"E2E"})
	public void shutDownDriver() {
		
	
		driver.close();
		
	}
	
	@Test (dataProvider = "myData", groups = {"E2E"})
	public void testLoginProcess(String userName, String passWord) {
		
		WebElement emailField = driver.findElement(By.name("email"));
		emailField.sendKeys(userName);
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys(passWord);
		WebElement loginButton = driver.findElement(By.cssSelector("div[class = 'ui fluid large blue submit button']"));
		loginButton.click();
		WebElement userDisplay = driver.findElement(By.className("user-display"));
		String expectedUserDisplayText = "Hani Darraj";
		String acutalUserDisplayText = userDisplay.getText();
		Assert.assertEquals(acutalUserDisplayText, expectedUserDisplayText);
		
	}

}
