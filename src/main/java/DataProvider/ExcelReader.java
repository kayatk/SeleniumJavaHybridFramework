package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader {
    public Workbook wb;
    
    @DataProvider(name ="")
    public static Object[][] generateTestDataFromExcel(){
        System.out.println("LOG INFO: ");
        Object arr [][] =ExcelReader.getDataFromExcel("");
        return arr;
    }
    
    public static Object[][] getDataFromExcel(String sheetName){
        try {
            wb = new XSSFWorkbook(new FileInputStream(new File("")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int row=wb.getSheet(sheetName).getPhysicalNumberOfRows();
        int column=wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
        Object [][]arr = new Object[row-1][column];
       for(int i=1;i<row;i++){
        for(int y=0;y<column;y++){
            arr[i-1][y] =getData(sheetName,i,y);
        }
       }
       System.out.println("LOG INFO: WorkBook Completed");
       wb.close();
        return arr;
    }
    public static String getData(String sheetName,int row,int column)
	{
		String value="";
		CellType type=wb.getSheet(sheetName).getRow(row).getCell(column).getCellType();
		if(type==CellType.NUMERIC)
		{
			double dValue=wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
			value=String.valueOf(dValue);
		}
		else if(type==CellType.BOOLEAN)
		{
			boolean bValue=wb.getSheet(sheetName).getRow(row).getCell(column).getBooleanCellValue();
			
			value=String.valueOf(bValue);
		}
		else if(type==CellType.STRING)
		{
			value=wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		}
		else if(type==CellType.BLANK)
		{
			value="";
		}
		
		return value;
		
	}
}
