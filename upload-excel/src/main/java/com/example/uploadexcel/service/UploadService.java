package com.example.uploadexcel.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.uploadexcel.dto.SummaryDto;
import com.example.uploadexcel.model.StockPrice;


public interface UploadService {
	
	public List<StockPrice> saveExcel(MultipartFile file) throws Exception;
	public SummaryDto getUploadSummary(List<StockPrice> sp);
	public List<StockPrice> findAll();

}
