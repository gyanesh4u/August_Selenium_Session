package testNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("/Users/gyaneshkamal/eclipse-workspace/"
				+ "August_Selenium_Session/TestData/Data.xlsx");
		
		Workbook book=WorkbookFactory.create(fis);//1.workbook Sheet Row Cell
		Sheet sheet = book.getSheet("Login");
		Row row = sheet.getRow(1);
		//Cell cell = row.getCell(1);
		//System.out.println(cell);
		
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			for(int j=0;j<row.getLastCellNum();j++) {
				System.out.println(sheet.getRow(i).getCell(j));
			}
		}
	}
}
