package com.durgasoft.ecommerce.pageUI;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.durgasoft.ecommerce.basepage.BasePage;

public class CreateLoginAccount extends BasePage{
	
	public static final Logger log=Logger.getLogger(CreateLoginAccount.class.getName());
	
	@FindBy(linkText = "Sign in") WebElement linkSignIN;
	@FindBy(id = "email_create") WebElement txtEmailID;
	@FindBy(id = "SubmitCreat") WebElement btnCreateAnAccount;
	@FindBy(xpath = "//h1[text()='Create an account']") WebElement txtCreateAnAccount;
	@FindBy(id = "id_gender1") WebElement radioMr;
	@FindBy(id = "customer_firstname") WebElement txtFirstName;
	@FindBy(id="customer_lastname") WebElement txtLastName;
	@FindBy(id="passwd") WebElement txtPassword;
	@FindBy(id="days") WebElement dropDownDays;
	@FindBy(id="months") WebElement dropDownMonth;
	@FindBy(id="years") WebElement dropDownYears;
	@FindBy(id="address1") WebElement txtAddress1;
	@FindBy(id="city")WebElement txtCity;
	@FindBy(id="id_state")WebElement dropdownState;
	@FindBy(id="postcode")WebElement txtZipCode;
	@FindBy(id="id_country")WebElement dropdownCountry;
	@FindBy(id="phone_mobile")WebElement txtMobile;
	@FindBy(id="alias")WebElement txtAliasAddress;
	@FindBy(id="submitAccount")WebElement btnRegister;
	@FindBy(xpath="//h1[text()='My account']")WebElement txtMyAccount;
	@FindBy(linkText="Sign out")WebElement linkSignOut;
	
	public CreateLoginAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void createAccount()throws Exception {
		linkSignIN.click();
		log.info("Clicked on SignIN button with object: "+linkSignIN.toString());
		txtEmailID.sendKeys(getData("firstname")+getData("lastname")+randomNumber()+getData("domainname"));
		log.info("Entering Email ID: "+txtEmailID.getAttribute("value")+" using object "+txtEmailID.toString());
		btnCreateAnAccount.click();
		log.info("Clicking on create an account: "+btnCreateAnAccount.toString());
		Thread.sleep(12000);
		assertEquals(txtCreateAnAccount.getText(), "CREATE AN ACCOUNT");
		radioMr.click();
		txtFirstName.sendKeys("Mahesh");
		txtLastName.sendKeys("D");
		txtPassword.sendKeys("abc@123");
		selectOption(dropDownDays, 3);
		selectOption(dropDownMonth, 3);
		selectOption(dropDownYears, 3);
		txtAddress1.sendKeys(getData("address1"));
		txtCity.sendKeys(getData("city"));
		selectOption(dropdownState, 3);
		txtZipCode.sendKeys("12345");
		selectOption(dropdownCountry, 1);
		txtMobile.sendKeys("1234567890");
		txtAliasAddress.sendKeys("UP");
		btnRegister.click();
		Thread.sleep(5000);
		assertEquals(txtMyAccount.getText(), "MY ACCOUNT");
	}
}
