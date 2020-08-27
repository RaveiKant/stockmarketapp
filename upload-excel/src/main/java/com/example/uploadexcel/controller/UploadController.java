package com.example.uploadexcel.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.uploadexcel.dto.SummaryDto;
import com.example.uploadexcel.model.StockPrice;
import com.example.uploadexcel.service.UploadService;

//import antlr.collections.List;

@RestController
@RequestMapping("/excel")
public class UploadController {
	UploadService uploadService;

	public UploadController(UploadService uploadService) {
		super();
		this.uploadService = uploadService;
	}
	
	@PostMapping("/upload")
	public ResponseEntity<SummaryDto> uploadExcel(@RequestParam("file") MultipartFile file ) throws Exception
	{		
		List<StockPrice> spList = uploadService.saveExcel(file);
		return new ResponseEntity<SummaryDto>(uploadService.getUploadSummary(spList),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/hello")
	public String hello(){
		
		return "hello";
	}

	@GetMapping("/uploaded")
	public List<StockPrice> view(){
		
		return uploadService.findAll();
	}


}
