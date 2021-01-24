package com.durgasoft.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcelDataByColumnName {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow r;
	public XSSFCell c;

	@Test
	public void f() throws Exception {
		fi = new FileInputStream("E:\\LiveProject_23_DEC_8AM\\selenium_maven\\testdata\\login.xlsx");
		w = new XSSFWorkbook(fi);
		s = w.getSheet("Sheet1");
		r = null;
		c = null;
		int column = -1;
		r = s.getRow(0);
		for (int i = 0; i < r.getLastCellNum(); i++) {
			System.out.println(r.getCell(i).getStringCellValue());
			if (r.getCell(i).getStringCellValue().equalsIgnoreCase("Results")) {
				column = i;
			}
		}
		r = s.getRow(2);
		if (r == null)
			r = s.createRow(2);
		c = r.getCell(column);
		if (c == null)
			c = r.createCell(column);
		c.setCellValue("BLOCKED");
		fo = new FileOutputStream("E:\\LiveProject_23_DEC_8AM\\selenium_maven\\testdata\\login.xlsx");
		w.write(fo);
		fo.close();
	}
}
