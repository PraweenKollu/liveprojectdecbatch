package com.durgasoft.testNG;

import org.testng.annotations.Test;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class RedBus_Alerts {

	public WebDriver driver;

	@Test(enabled = false)
	public void f() throws Exception {
		driver.findElement(By.id("i-icon-profile")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("signInLink")).click();
		Thread.sleep(6000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='modalIframe']")));
		driver.findElement(By.xpath("//div[text()='Facebook']")).click();
		Thread.sleep(6000);
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		Object[] s = windows.toArray();
		driver.switchTo().window(s[1].toString());
		driver.findElement(By.id("email")).sendKeys("Mahesh");

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://redbus.in");
		driver.manage().window().maximize();
	}

}
