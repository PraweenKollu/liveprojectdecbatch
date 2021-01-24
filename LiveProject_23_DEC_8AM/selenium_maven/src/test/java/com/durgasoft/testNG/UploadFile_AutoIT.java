package com.durgasoft.testNG;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class UploadFile_AutoIT {

	public WebDriver driver;

	@Test
	public void f() throws Exception {
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Registration")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Perminent Registration")).click();
		driver.findElement(By.name("image")).click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\DELL\\Desktop\\upload.exe");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://seleniumbymahesh.com/HMS");
		driver.manage().window().maximize();
	}
}
