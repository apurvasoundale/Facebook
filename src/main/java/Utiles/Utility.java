package Utiles;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	
	public static String getDatafromExcel(String sheet, int row, int cell) throws IOException 
	{
		String data = "";
		
		String path = "C:\\Users\\DELL\\Desktop\\excel work.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		
		Workbook workbook = WorkbookFactory.create(file);
		
		try
		{
			data = workbook.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
			
		}
		catch(IllegalStateException e)
		{
			double value = workbook.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
			
			data = String.valueOf(value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
		
		
	}
	
	

}
