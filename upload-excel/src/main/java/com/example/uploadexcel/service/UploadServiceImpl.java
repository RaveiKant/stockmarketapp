package com.example.uploadexcel.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.uploadexcel.dao.ExcelDao;
import com.example.uploadexcel.dto.SummaryDto;
import com.example.uploadexcel.helper.UploadExcelHelper;
import com.example.uploadexcel.model.StockPrice;

@Service
public class UploadServiceImpl implements UploadService{
	
		ExcelDao excelDao;

		public UploadServiceImpl(ExcelDao excelDao) {
			super();
			this.excelDao = excelDao;
		}
		
		@Transactional
		public List<StockPrice> saveExcel(MultipartFile file) throws Exception {			
			
			try {
				
				String fileName = file.getOriginalFilename();
				String fileType = fileName.substring(fileName.lastIndexOf("."));
		        if (!(fileType.equals(".xls") || fileType.equals(".xlsx") || fileType.equals(".csv"))) 
		        {
		        	throw new Exception("Please upload an excel file");
		        }
		        
	        	List<StockPrice> spList = UploadExcelHelper.readExcel(file.getInputStream());
				excelDao.saveAll(spList);
				
				return spList;

			}
			
			catch(IOException e){
				throw new RuntimeException("fail" + e.getMessage());
			}
		}

		

		@Override
		@Transactional
		public SummaryDto getUploadSummary(List<StockPrice> spList) {
			
			SummaryDto summaryDto = new SummaryDto();
			
			// TODO Auto-generated method stub
			
			if (spList.size() != 0) 
			{
	            summaryDto.setRecordNumber(spList.size());
	            summaryDto.setCompanyCode(spList.get(0).getCompanyCode());
	            summaryDto.setStockExchange(spList.get(0).getStockExchange());
	            
	            spList.sort(Comparator.comparing(StockPrice::getDate));
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            
	            summaryDto.setFromDate(sdf.format(spList.get(0).getDate()));
	            summaryDto.setToDate(sdf.format(spList.get(spList.size()-1).getDate()));
	        }
	        
			return summaryDto;
			
			//return null;
		}

		@Override
		public List<StockPrice> findAll() {
			// TODO Auto-generated method stub
			return excelDao.findAll();
		}
	
	

}
