package com.generic;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
public WebDriver driver;

@BeforeMethod
public void launchBrowser() {
	ChromeOptions co = new ChromeOptions();
	co.addArguments("--disable-notifications");
	driver = new ChromeDriver(co);
	driver.get("https://login.salesforce.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}

@AfterMethod
public void closeBrowser() {
	driver.quit();
}
}
