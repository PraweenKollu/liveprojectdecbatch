package com.durgasoft.excel;

import org.testng.annotations.Test;

public class ReadDataDriverClass {
	@Test
	public void f() throws Exception {

		Excel_API e = new Excel_API("E:\\LiveProject_23_DEC_8AM\\selenium_maven\\testdata\\login.xlsx");
		System.out.println("------Read data from excel fileby using col num-----");
		System.out.println(e.getCellData("Sheet1", 0, 0));
		System.out.println(e.getCellData("Sheet1", 1, 0));
		System.out.println(e.getCellData("Sheet1", 2, 0));
		System.out.println("------Read data from excel fileby using col name-----");
		System.out.println(e.getCellData("Sheet1", "Username", 5));
		System.out.println(e.getCellData("Sheet1", "Password", 5));
		System.out.println(e.getCellData("Sheet1", "Results", 5));
	}
}
