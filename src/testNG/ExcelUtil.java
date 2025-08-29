package testNG;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	
	public static Workbook book;
	public static Sheet sheet;
	
	private static final  String TEST_DATA_SHEET_PATH="/Users/gyaneshkamal/eclipse-workspace/"
			+ "August_Selenium_Session/TestData/Data.xlsx";
	
	public static Object[][] getTestData(String sheetName){//data[4][1] int a[]=new int[5];
		Object data[][]=null;//null
		
		FileInputStream file;
		try {
			file=new FileInputStream(TEST_DATA_SHEET_PATH);
			book=WorkbookFactory.create(file);
			sheet=book.getSheet(sheetName);
			data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
					
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
