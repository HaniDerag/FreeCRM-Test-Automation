package com.freecrm.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public void initiateDriver(String Url) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(Url);
		WebElement emailField = driver.findElement(By.name("email"));
		emailField.sendKeys("hanoush583@gmail.com");
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("HAni123456789");
		WebElement loginButton = driver.findElement(By.cssSelector("div[class = 'ui fluid large blue submit button']"));
		loginButton.click();
		
	}
	


}
