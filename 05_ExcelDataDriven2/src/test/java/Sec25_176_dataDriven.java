import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sec25_176_dataDriven {
	
	// Get project path
	String path = System.getProperty("user.dir") + "\\SampleTC.xlsx";

	public ArrayList<String> getData(String columnName) throws IOException {
		
		
				
				

		ArrayList<String> list = new ArrayList<String>();

		// Step1 : Access to the sheet************************
		FileInputStream fis = new FileInputStream(path);
		
		// XSSFWorkbook accepts fileInputStream argument
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		

		// Step2 : Identify column by scanning entire Ist row*****
		Iterator<Row> rows = sheet.rowIterator();// sheet is collection of rows
		Row firstRow = rows.next();
		Iterator<Cell> cells = firstRow.cellIterator(); // row is collection of cells

		int k = 0;
		int columnNumber = 0;
		while (cells.hasNext()) {
			Cell value = cells.next();
			if (value.getStringCellValue().equalsIgnoreCase(columnName)) {
				columnNumber = k;
			}
			k++;
		}

		System.out.println("ColumnNumber of " + columnName + " is " + columnNumber);

		// Scanning values in that column and adding them in list
		while (rows.hasNext()) {
			Row r = rows.next();
			Cell c = r.getCell(columnNumber);

			// Validate if cell has value String or integer
			if (c != null) {
				if (r.getCell(columnNumber).getCellType() == CellType.STRING) {
					String cellValue = r.getCell(columnNumber).getStringCellValue();
					list.add(cellValue);
				} else {
					double d = r.getCell(columnNumber).getNumericCellValue();
					String cellValue1 = NumberToTextConverter.toText(d);
					list.add(cellValue1);
				}
			}
		}
		return list;
	}
	
	public void addData(String columnName) throws IOException {
		
	}
	
}
