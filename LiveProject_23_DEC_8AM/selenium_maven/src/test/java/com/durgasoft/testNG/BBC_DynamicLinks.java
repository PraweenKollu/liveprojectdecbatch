package com.durgasoft.testNG;

import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BBC_DynamicLinks {

	public WebDriver driver;

	@Test
	public void f() throws Exception {
		WebElement header = driver.findElement(By.xpath("//div[@class='most-popular']"));
		List<WebElement> links = header.findElements(By.tagName("a"));
		System.out.println("The available links are:" + links.size());
		for (int i = 0; i < links.size(); i++) {
			System.out.println(links.get(i).getText());
			links.get(i).click();
			Thread.sleep(6000);
			System.out.println(driver.getCurrentUrl());
			driver.navigate().back();
			header = driver.findElement(By.xpath("//div[@class='most-popular']"));
			links = header.findElements(By.tagName("a"));
		}
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://bbc.com");
		driver.manage().window().maximize();
	}
}
