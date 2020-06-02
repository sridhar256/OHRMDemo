package com.gurudemo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class XLUtils {

	public HashMap<String, String> readDataFromExcel(String TCID) throws FileNotFoundException, IOException {

		String flpath = "C:\\Users\\india\\eclipse-workspace\\GuruDemoSite\\src\\test\\java\\com"
				+ "\\gurudemo\\testdata\\OrangeHRM.xls";

		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(flpath));

		HSSFSheet sht = wb.getSheet("Sheet1");

		int rc = sht.getLastRowNum();

		HashMap<String, String> tcData = new HashMap();

		for (int r = 1; r <= rc; r++) {
			int cc = sht.getRow(r).getLastCellNum();

			if (sht.getRow(r).getCell(0).toString().equalsIgnoreCase(TCID)) {
				for (int c = 0; c < cc; c++) {
					String kname = sht.getRow(0).getCell(c).toString();
					String kvalue = sht.getRow(r).getCell(c).toString();

					tcData.put(kname, kvalue);
				}
				break;
			}
		}
		//wb.close();
		return tcData;
	}

}
