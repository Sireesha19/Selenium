package dataDrivenFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Excels {
	public Workbook wb;
	public Sheet sheet;
	public int row;
	public int cell;
	
	@Test(dataProvider="getexcelsheetvalues")
	public void values(HashMap <String,String> ref) {
		System.out.println(ref.get("Username"));
		System.out.println(ref.get("Password"));
		System.out.println(ref.get("a"));
	}
		
	


@DataProvider
public Object[][] getexcelsheetvalues() throws IOException ,InterruptedException, EncryptedDocumentException, InvalidFormatException{
	FileInputStream file=new FileInputStream("/home/sireesha/login.xls");
	//wb=new HSSFWorkbook("/home/sireesha/login.xls");
	wb=WorkbookFactory.create(file); //any kind of excel (no need to use XSSF,HSSF)
	sheet=wb.getSheet("Sheet1");
	row=sheet.getLastRowNum();
	cell=sheet.getRow(0).getLastCellNum();
	System.out.println("rows are--->"+row);
	System.out.println("cells are----->"+cell);
	Object[][] obj=new Object[row][1]; 

		
	for(int i=1;i<=row;i++) {
		HashMap<String, String> hash=new HashMap<>();
	
	for(int j=0;j<cell;j++) {
		
	  
		DataFormatter data=new DataFormatter();
	    String key=data.formatCellValue(sheet.getRow(0).getCell(j));
	    String value=data.formatCellValue(sheet.getRow(i).getCell(j));
	   
	    hash.put(key, value);
	    System.out.println(i+""+j);
	  //  System.out.println("values--------->"+key + value);
	}    
	
	obj[i-1][0]=hash;
	//System.out.println(i-1+0+"=======>"+obj[i-1] [0]);
	
	}
	
	
	return obj;

	
}
}