package com.durgasoft.testNG;

import org.testng.annotations.Test;
import com.durgasoft.excel.Excel_API;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class HMS_Login_Excel_API {

	public WebDriver driver;

	@Test
	public void f() throws Exception {
		Excel_API e = new Excel_API("E:\\LiveProject_23_DEC_8AM\\selenium_maven\\testdata\\login.xlsx");
		driver.findElement(By.name("username")).sendKeys(e.getCellData("Sheet1", 0, 1));
		driver.findElement(By.name("password")).sendKeys(e.getCellData("Sheet1", 1, 1));
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://seleniumbymahesh.com/HMS");
		driver.manage().window().maximize();
	}

}
