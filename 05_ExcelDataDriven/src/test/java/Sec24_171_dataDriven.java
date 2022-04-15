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

public class Sec24_171_dataDriven {

	public ArrayList<String> getData(String testCaseName) throws IOException {

		ArrayList<String> list = new ArrayList<String>();

		// Step1 : Access to the sheet************************
		// Get project path
		String path = System.getProperty("user.dir") + "\\TestData.xlsx";
		FileInputStream fis = new FileInputStream(path);

		// XSSFWorkbook accepts fileInputStream argument
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheetCount = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetCount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("dataSheet")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				// Step2 : Identify TestCases column by scanning entire Ist row*****
				Iterator<Row> rows = sheet.rowIterator();// sheet is collection of rows
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator(); // row is collection of cells

				int k = 0;
				int columnNumber = 0;
				while (cells.hasNext()) {
					Cell value = cells.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						columnNumber = k;
					}
					k++;
				}

				System.out.println("ColumnNumber of TestCases " + columnNumber);

				// Step3 :Once column is identified then scan entire TestCases column to
				// identify purchase TestCase row *********************************
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(columnNumber).getStringCellValue().equalsIgnoreCase(testCaseName)) {

						// Step4 : Purchase testCase row grab from which pull data and feed into
						// testCase **************************************
						Iterator<Cell> purchaseCells = r.cellIterator();
						while (purchaseCells.hasNext()) {
							Cell c = purchaseCells.next();

							// Validate if cell has value String or integer
							if (c.getCellType() == CellType.STRING) {
								String cellValue = c.getStringCellValue();
								list.add(cellValue);
							} else {
								double d = c.getNumericCellValue();
								String cellValue1 = NumberToTextConverter.toText(d);
								list.add(cellValue1);
							}
						}
					}
				}
			}
		}
		return list;
	}
}
