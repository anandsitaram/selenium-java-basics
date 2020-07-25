package com.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo01_ReadExcel {

	public static void main(String... args) {

		// XLSX format
		try {
			FileInputStream  fn = new FileInputStream("./resources/TestData_xlsx.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fn);
			XSSFSheet sheet = workbook.getSheet("Sheet2");
			//Calculate total rows
			int rows=sheet.getLastRowNum()-sheet.getFirstRowNum();
			
			// Displays all rows and columns values 
			sheet.forEach(r->r.forEach(c->System.out.println(c)));
			System.out.println("------------------------------------------------------------------------------");	
			// Displays all rows and columns values 
			for(int i=1;i<rows;i++) {
				
				int col=sheet.getRow(i).getLastCellNum();
				
				for(int j=0;j<col;j++) {
					System.out.println("------ "+sheet.getRow(i).getCell(j).toString());
					
				}
				
			}
			System.out.println("------------------------------------------------------------------------------");
			
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
		
		// XLS format
				try {
					FileInputStream  fn = new FileInputStream("./resources/TestData_xls.xls");
					HSSFWorkbook workbook = new HSSFWorkbook(fn);
					HSSFSheet sheet = workbook.getSheet("Sheet3");
					//Calculate total rows
					int rows=sheet.getLastRowNum()-sheet.getFirstRowNum();
					
					// Displays all rows and columns values 
					sheet.forEach(r->r.forEach(c->System.out.println(c)));
					System.out.println("------------------------------------------------------------------------------");	
					// Displays all rows and columns values 
					for(int i=1;i<rows;i++) {
						
						int col=sheet.getRow(i).getLastCellNum();
						
						for(int j=0;j<col;j++) {
							System.out.println("------ "+sheet.getRow(i).getCell(j).toString());
							
						}
						
					}
					System.out.println("------------------------------------------------------------------------------");
					
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
