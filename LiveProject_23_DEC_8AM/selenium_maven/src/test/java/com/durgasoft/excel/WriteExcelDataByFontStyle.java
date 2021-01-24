package com.durgasoft.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcelDataByFontStyle {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow r;
	public XSSFCell c;
	public XSSFFont font;
	public XSSFCellStyle style;

	@Test
	public void f() throws Exception {
		fi = new FileInputStream("E:\\LiveProject_23_DEC_8AM\\selenium_maven\\testdata\\login.xlsx");
		w = new XSSFWorkbook(fi);
		s = w.getSheet("Sheet1");
		r = null;
		c = null;
		font = w.createFont();
		style = w.createCellStyle();
		r = s.getRow(5);
		if (r == null)
			r = s.createRow(5);
		c = r.getCell(2);
		if (c == null)
			c = r.createCell(2);
		font.setFontName("Arial Black");
		font.setBold(true);
		font.setFontHeight(9);
		style.setFont(font);
		c.setCellStyle(style);
		c.setCellValue("PASS");
		fo = new FileOutputStream("E:\\LiveProject_23_DEC_8AM\\selenium_maven\\testdata\\login.xlsx");
		w.write(fo);
		fo.close();

	}
}
