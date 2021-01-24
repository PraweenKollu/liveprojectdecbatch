package com.durgasoft.testNG;

import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class PrintAllRadioButtonProperties {

	public WebDriver driver;

	@Test
	public void f() throws Exception {
		WebElement tableLoc = driver.findElement(By.xpath("(//td[@class='table5'])[2]"));
		for (int k = 1; k < 3; k++) {
			List<WebElement> radio = tableLoc.findElements(By.name("group" + k));
			for (int i = 0; i < radio.size(); i++) {
				radio.get(i).click();
				for (int j = 0; j < radio.size(); j++) {
					System.out.println(
							radio.get(j).getAttribute("value") + "-----" + radio.get(j).getAttribute("checked"));
					Thread.sleep(1000);
				}
			}
		}
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://echoecho.com/htmlforms10.htm");
		driver.manage().window().maximize();
	}
}
