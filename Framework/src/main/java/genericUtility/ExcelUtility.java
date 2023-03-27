package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

		public String getExcelData(String sheet, int rowno,int cellno) throws Throwable {
			FileInputStream fis = new FileInputStream("./src/test/resources/propertyfile.txt");

			Workbook book = WorkbookFactory.create(fis);

			/*Sheet sh = book.getSheet("Sheet1");

			Row row = sh.getRow(0);

			Cell cel = row.getCell(0);

			String exceldata = cel.getStringCellValue();

			return exceldata;
			*/
			
			DataFormatter format= new DataFormatter();
			String data = format.formatCellValue(book.getSheet(sheet).getRow(rowno).getCell(cellno));
			return data;
			
	}
		public String getExcelDataByFormatter(String sheet, int rowNum, int cellNum) throws Throwable
		{
			FileInputStream fie=new FileInputStream("./src/test/resources/Seleniumdata.xlsx");
		     Workbook book=WorkbookFactory.create(fie);
		     
		     DataFormatter format=new DataFormatter();
		     String data = format.formatCellValue(book.getSheet(sheet).getRow(rowNum).getCell(cellNum));
		     return data;
		}
		
			
}
