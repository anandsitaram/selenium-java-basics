package com.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo02_WriteExcel {

	public static void main(String... args) {

		// XLSX format
		try {
			FileInputStream fn = new FileInputStream("./resources/TestData_xlsx.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fn);
			XSSFSheet sheet = workbook.getSheet("Sheet2");
			// Calculate total rows
			int rows = sheet.getLastRowNum() - sheet.getFirstRowNum();

			for (int i = 1; i <= rows; i++) {

				sheet.getRow(i).getCell(6).setBlank();
				sheet.getRow(i).createCell(6).setCellValue("Write Cell " + i);

			}
			System.out.println("------------------------------------------------------------------------------");

			FileOutputStream fo = new FileOutputStream("./resources/TestData_xlsx.xlsx");

			workbook.write(fo);
			fn.close();
			fo.close();
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("------------------------------------------------------------------------------");

		// XLS format
		try {
			FileInputStream fn = new FileInputStream("./resources/TestData_xls.xls");
			HSSFWorkbook workbook = new HSSFWorkbook(fn);
			HSSFSheet sheet = workbook.getSheet("Sheet2");
			// Calculate total rows
			int rows = sheet.getLastRowNum() - sheet.getFirstRowNum();

		
			for (int i = 1; i <=rows; i++) {
				sheet.getRow(i).getCell(6).setBlank();
				sheet.getRow(i).createCell(6).setCellValue("Write Cell " + i * i);

			}
			System.out.println("------------------------------------------------------------------------------");
			FileOutputStream fo = new FileOutputStream("./resources/TestData_xls.xls");
			workbook.write(fo);
			fn.close();
			fo.close();
			workbook.close();
			fn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("------------------------------------------------------------------------------");

	}

}
