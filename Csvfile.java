package dataDrivenFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import au.com.bytecode.opencsv.CSVReader;

public class Csvfile {
	@DataProvider
	public Object[][] getCsvData() throws IOException{
	
				String FILE_PATH="/home/sireesha/login.csv";
				CSVReader reader = new CSVReader(new FileReader(FILE_PATH));
				List<String[]> totalRows=reader.readAll();
				String[] fstRow=totalRows.get(0);
				int rowsCount=totalRows.size();
				int colCount=fstRow.length;
				Object[][] obj=new Object[rowsCount-1][1];
				for(int i=1;i<rowsCount;i++) {
					Map<String, String> hash=new HashMap<>();
					for(int j=0;j<colCount;j++) {
						String key=fstRow[j];
						String[] eachRow=totalRows.get(i);
						String val=eachRow[j];
						hash.put(key, val);
						
					}
					obj[i-1][0]=hash;
				}
					return obj;
				}
	
	@Test(dataProvider="getCsvData")
	public void fileData(HashMap<String, String> h) {
		System.out.println("key value: "+h.get("Username"));
		System.out.println("vlaue is:"+h.get("Password"));
		
	}
}
				
			
		
				/*while ((nextLine = reader.readNext()) != null) {
				
					
						for(int j=0;j<2;j++) {
							
							System.out.println(nextLine[j]);
						}
					*/
	
	

