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
		FileInputStream reader = new FileInputStream("C:\\Users\\vinit\\eclipse-workspace\\SauceDemo\\src\\test\\java\\utilis\\saucedemofile.properties");
		prop.load(reader);
		String value = prop.getProperty(key);
		return value;
	}
	
	public static String readDataFromExcelFile(int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		File myfile = new File("C:\\Users\\vinit\\OneDrive\\Desktop\\SauceDemo.xlsx");
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
