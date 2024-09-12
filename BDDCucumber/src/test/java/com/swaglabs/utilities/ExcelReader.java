package com.swaglabs.utilities;

	import java.io.FileInputStream;
	import java.io.IOException;
	

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelReader {

		
		public String excelReader(String dataFileName, String sheetName, String rowName, String columnName)
				throws IOException {

			String filePath = "src/test/resources/saucedemo.xlsx";

			String cellValue = null;
			try (FileInputStream fis = new FileInputStream(filePath); 
				Workbook workbook = new XSSFWorkbook(fis)) {
				Sheet sheet = workbook.getSheet("User_Data");
				int rowNum = findRowIndex(sheet, rowName);
				if (rowNum != -1) {
					Row row = sheet.getRow(rowNum);
					int cellNum = findColumnIndex(sheet, columnName);
					if (cellNum != -1) {
						Cell cell = row.getCell(cellNum);
						if (cell != null) {
							cellValue = cell.toString();
						} else {
							System.out.println("Cell with name " + columnName + " not found in row " + rowName);
						}
					} else {
						System.out.println("Column with name " + columnName + " not found in sheet " + sheetName);
					}
				} else {
					System.out.println("Row with name " + rowName + " not found in sheet " + sheetName);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return cellValue;
		}

		private int findRowIndex(Sheet sheet, String rowName) {
			for (Row row : sheet) {
				Cell cell = row.getCell(0); 
				if (cell != null && cell.toString().equals(rowName)) {
					return row.getRowNum();
				}
			}
			return -1; 
		}

		private int findColumnIndex(Sheet sheet, String columnName) {
			Row headerRow = sheet.getRow(0); 
			for (Cell cell : headerRow) {
				if (cell != null && cell.toString().equals(columnName)) {
					return cell.getColumnIndex();
				}
			}
			return -1; 
		}

		public static String readExcel(String sheetName, String rowName, String columnName)  {

			
			ExcelReader reader = new ExcelReader();
			String cellValue = null;
			try {
				cellValue = reader.excelReader("saucedemo", sheetName, rowName, columnName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return cellValue;
		}
		
		
	}



