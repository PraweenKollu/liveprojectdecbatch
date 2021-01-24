package com.durgasoft.testNG;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class FaceBook_Login_JSE {

	public WebDriver driver;

	@Test
	public void f() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('email').value='Mahesh'");
		js.executeScript("document.getElementById('pass').value='abc12345'");
		js.executeScript("document.getElementById('u_0_b').click()");
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
	}
}
