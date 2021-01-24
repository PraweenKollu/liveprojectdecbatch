package com.durgasoft.ecommerce.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.durgasoft.ecommerce.basepage.BasePage;

public class Listeners extends BasePage implements ITestListener {

	public void onTestStart(ITestResult arg0) {
		Reporter.log("Test Start Running:" + arg0.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult arg0) {
		Reporter.log("Test is skipped:" + arg0.getMethod().getMethodName());
	}

	public void onTestSucess(ITestResult arg0) {
		Reporter.log("Test is success:" + arg0.getMethod().getMethodName());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName = arg0.getName();
		if (arg0.isSuccess()) {
			File srcpath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String reportDirectory = (new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/src/main/java/com/durgasoft/ecommerce");
			File targetPath = new File((String) reportDirectory + "/passedscreens/" + methodName
					+ simpleDate.format(cal.getTime()) + ".png");
			try {
				FileUtils.copyFile(srcpath, targetPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void onTestFailure(ITestResult arg0) {
		Reporter.log("Test is Failed:" + arg0.getMethod().getMethodName());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName = arg0.getName();
		if (!arg0.isSuccess()) {
			File srcpath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String reportDirectory = (new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/src/main/java/com/durgasoft/ecommerce");
			File targetPath = new File((String) reportDirectory + "/failedscreens/" + methodName
					+ simpleDate.format(cal.getTime()) + ".png");
			try {
				FileUtils.copyFile(srcpath, targetPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
