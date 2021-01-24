package com.durgasoft.testNG;

import org.testng.annotations.Test;
import com.durgasoft.java.BasePage;
import com.durgasoft.java.PageUI;

import atu.testrecorder.ATUTestRecorder;

import org.testng.annotations.BeforeTest;

public class TC001_HMS_Login_Logout extends BasePage {

	public ATUTestRecorder recorder;

	@Test(description = "This test case is to verify login & logout in HMS")
	public void hmsLoginLogout() throws Exception {
		PageUI p = new PageUI(driver);
		p.hmsLogin();
		p.hmsLogout();
		recorder.stop();
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		recorder = new ATUTestRecorder("E:\\recording", "hms", false);
		recorder.start();
		browserLaunch("chrome", "http://seleniumbymahesh.com");
	}
}
