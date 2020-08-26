package com.example.uploadexcel.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.uploadexcel.model.StockPrice;

public class UploadExcelHelper {
	
	public static List<StockPrice> readExcel(InputStream is){
		
		try {
			
			Workbook workbook = new XSSFWorkbook(is);
			Sheet sheet = workbook.getSheetAt(0);
		    Iterator<Row> rows = sheet.iterator();
		    
		    List<StockPrice> priceList = new ArrayList<StockPrice>();
		    
		    int rowNo = 1;
		    
		    while(rows.hasNext()) {
		    	Row currentRow = rows.next();
		    	Iterator<Cell> cells = currentRow.iterator();
		    	
		    	StockPrice sp = new StockPrice();
		    	
		    	sp.setCompanyCode((long)cells.next().getNumericCellValue());
		    	sp.setStockExchange(cells.next().getStringCellValue());
		    	sp.setCurrentPrice(cells.next().getNumericCellValue());
		    	sp.setDate(cells.next().getLocalDateTimeCellValue());
		    	sp.setTime(cells.next().getLocalDateTimeCellValue());
		    	
		    	
		    	
		    }
		    
		    
		    return priceList;
		}
		
		catch(IOException e) {
			throw new RuntimeException("Failed to parse file " + e.getMessage());
		}
		
	}

}
