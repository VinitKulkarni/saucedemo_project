package utilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class UtilityClass {
	public static String readDataFromPropertiesFile(String key) throws IOException {
		Properties prop = new Properties();
		String filePath = System.getProperty("user.dir");
		FileInputStream reader = new FileInputStream(filePath + "/test_data/saucedemo_data.properties");
		prop.load(reader);
		String value = prop.getProperty(key);
		return value;
	}
	
	public static String readDataFromExcelFile(int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		String excelFilePath = System.getProperty("user.dir")+"/test_data/SauceDemo.xlsx";
		File myfile = new File(excelFilePath);
		Sheet Mysheet = WorkbookFactory.create(myfile).getSheet("Sheet1");
		
		//String loginPageUrl = Mysheet.getRow(0).getCell(0).getStringCellValue();
		//String inventoryPageUrl = Mysheet.getRow(1).getCell(0).getStringCellValue();
		//String productPageUrl = Mysheet.getRow(2).getCell(0).getStringCellValue();
		//String viewCartPageUrl = Mysheet.getRow(3).getCell(0).getStringCellValue();
		//String addPersonInfoPageUrl = Mysheet.getRow(4).getCell(0).getStringCellValue();
		//String checkOutOverViewPageUrl= Mysheet.getRow(5).getCell(0).getStringCellValue();
		//String orderPlacedPageUrl = Mysheet.getRow(6).getCell(0).getStringCellValue();
		
		
		String value = Mysheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		System.out.println("value:"+value);
		return value;
	}
	
	public static void implicitWait() {
		//code
	}
}
