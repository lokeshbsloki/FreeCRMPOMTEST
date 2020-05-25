package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil  extends TestBase{

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;

	public static String TESTDATA_SHEET_PATH="G:\\MyJavaProject\\FreeCRMPOMTest\\src\\main\\java\\com\\crm\\qa\\"
			+ "testData\\FreeCrmTestdata.xlsx";
	static Workbook book;
	static Sheet sheet;
	public void switchToFrame() {
		
		driver.switchTo().frame("");
	}
	
	public void waitForSomeTime(long seconds) {
		
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Object[][] getTestData(String sheetname){
		
		FileInputStream file=null;
		
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetname);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				
			}
		}
		return data;
	
	}

	public static void takeScreenshotAtEndOfTest() throws Exception {

		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String currentdir = System.getProperty("user.dir");
		
		FileUtils.copyFile(srcfile, new File(currentdir+"/screenshots/"+System.currentTimeMillis()+".png"));
		
		
		
		
		
		
		
	}
}
