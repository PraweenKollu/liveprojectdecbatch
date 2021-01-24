package com.durgasoft.testNG;

import org.testng.annotations.Test;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class CaptureScreenshot {

	public WebDriver driver;

	@Test(enabled = false)
	public void normalScreenshot() throws Exception {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\DELL\\Desktop\\sbm.png"));
	}

	@Test(enabled = false)
	public void conditionBasedScreenshot() throws Exception {
		List<WebElement> links = driver.findElements(By.partialLinkText("New Batches"));
		System.out.println("available links are:" + links.size());
		for (int i = 0; i < links.size(); i++) {
			System.out.println("LinkName:" + links.get(i).getText());
			links.get(i).click();
			Thread.sleep(5000);
		}
		if (!(links.size() == 0)) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\Users\\DELL\\Desktop\\sbm.png"));
		}
	}

	@Test
	public void dateNtimeScreenshot() throws Exception {
		Date dt = new Date();
		DateFormat dtformat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\DELL\\Desktop\\" + dtformat.format(dt) + "sbm.png"));
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://seleniumbymahesh.com");
		driver.manage().window().maximize();
	}
}
