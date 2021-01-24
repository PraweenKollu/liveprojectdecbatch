package com.durgasoft.excel;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcelFile {
	@Test
	public void f() throws Exception {
		FileInputStream fi = new FileInputStream("E:\\LiveProject_23_DEC_8AM\\selenium_maven\\testdata\\login.xlsx");
		XSSFWorkbook w = new XSSFWorkbook(fi);
		XSSFSheet s = w.getSheet("Sheet1");
		XSSFRow row = s.getRow(1);
		XSSFCell cell = row.getCell(1);
		System.out.println(cell.getStringCellValue());
		w.close();
	}
}
