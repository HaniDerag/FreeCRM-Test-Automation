package com.freecrm.testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {
	
	
	@Test (priority = 1)
	public void getLoginPageTitle() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = "https://freecrm.com/";
		driver.get(url);
		//String expectedPageTitle = "Free CRM #1 cloud software for any business large or small";
		String actualPageTitle = driver.getTitle();
		System.out.println(actualPageTitle);
		driver.close();
		
	}
	
	@Test (priority = 2)
	public void checkLogoIsDisplayed() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = "https://freecrm.com/";
		driver.get(url);
		//boolean expectedLogoIsDisplayed = true;
		WebElement actualLogoIsDisplayed = driver.findElement(By.className("brand-name"));
		boolean actalResult = actualLogoIsDisplayed.isDisplayed();
		System.out.println(actalResult);
		driver.close();
		
	}
	
	@Test (priority = 3)
	public void getCurrentUrl() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = "https://freecrm.com/";
		driver.get(url);
		//String expectedlCurrentUrl = "https://freecrm.com/";
		String actualCurrentUrl = driver.getCurrentUrl();
		System.out.println(actualCurrentUrl);
		driver.close();
		
	}
	
	
	
	@Test (priority = 4)
	public void loginToAccount () {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = "https://ui.freecrm.com/";
		driver.get(url);
		WebElement emailFeild = driver.findElement(By.name("email"));
		emailFeild.sendKeys("hanoush583@gmail.com");
		WebElement passwordFeild = driver.findElement(By.name("password"));
		passwordFeild.sendKeys("HAni123456789");
		WebElement loginButton = driver.findElement(By.xpath("//div[@class = 'ui fluid large blue submit button']"));
		loginButton.click();
		WebElement freeAccountIcon = driver.findElement(By.linkText("Free account"));
		boolean freeAccountIconIsDisplayed = freeAccountIcon.isDisplayed();
		System.out.println(freeAccountIconIsDisplayed);
		driver.close();
		
	}
	
	
	

}
