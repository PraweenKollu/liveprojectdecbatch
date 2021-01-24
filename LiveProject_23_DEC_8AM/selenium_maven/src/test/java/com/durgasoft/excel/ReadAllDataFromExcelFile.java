package com.durgasoft.excel;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadAllDataFromExcelFile {

	public FileInputStream fi;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow r;
	public XSSFCell c;

	@Test
	public void f() throws Exception {
		fi = new FileInputStream("E:\\LiveProject_23_DEC_8AM\\selenium_maven\\testdata\\login.xlsx");
		w = new XSSFWorkbook(fi);
		s = w.getSheet("Sheet1");
		int rowCount = s.getLastRowNum() - s.getFirstRowNum();
		System.out.println(rowCount);
		for (int i = 1; i <= rowCount; i++) {
			r = s.getRow(i);
			for (int j = 0; j < r.getLastCellNum(); j++) {
				System.out.println(r.getCell(j).getStringCellValue());
			}
			System.out.println();
		}
	}
}
