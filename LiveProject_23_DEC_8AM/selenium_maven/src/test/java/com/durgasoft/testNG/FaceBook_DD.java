package com.durgasoft.testNG;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

public class FaceBook_DD {

	public WebDriver driver;

	@Test
	public void f() throws Exception{
		driver.findElement(By.linkText("Create New Account")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("month")).sendKeys("Mar");
		Thread.sleep(3000);
		/*new Select(driver.findElement(By.id("month"))).selectByIndex(5);
		Thread.sleep(3000);
		new Select(driver.findElement(By.id("month"))).selectByValue("7");
		Thread.sleep(3000);
		new Select(driver.findElement(By.id("month"))).selectByVisibleText("Dec");*/
		WebElement ddMonth = driver.findElement(By.id("month"));
		Select monthDD=new Select(ddMonth);
		monthDD.selectByIndex(5);
		Thread.sleep(3000);
		monthDD.selectByValue("7");
		Thread.sleep(3000);
		monthDD.selectByVisibleText("Dec");
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
	}
}
