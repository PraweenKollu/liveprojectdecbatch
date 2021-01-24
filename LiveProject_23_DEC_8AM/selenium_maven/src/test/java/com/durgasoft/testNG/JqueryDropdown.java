package com.durgasoft.testNG;

import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class JqueryDropdown {

	public WebDriver driver;

	@Test
	public void f() throws Exception {
		driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).click();
		Thread.sleep(5000);
		WebElement table = driver.findElement(By.xpath("//ul[@class='multiselect-container dropdown-menu']"));
		List<WebElement> ddValues = table.findElements(By.tagName("input"));
		System.out.println("Available values in dropdown:" + ddValues.size());
		/*for (int i = 0; i < ddValues.size(); i++) {
			ddValues.get(i).click();
		}*/
		Random r=new Random();
		int num=r.nextInt(4);
		System.out.println(num);
		ddValues.get(num).click();
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_1");
		driver.manage().window().maximize();
	}
}
