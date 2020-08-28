package com.example.companydetails.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.companydetails.dto.StockExchangeDto;
import com.example.companydetails.model.Company;
import com.example.companydetails.service.ExchangeService;

@RestController
@RequestMapping("/exchange")
public class StockExchangeController {
	
	ExchangeService exchangeService;

	public StockExchangeController(ExchangeService exchangeService) {
		super();
		this.exchangeService = exchangeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addExchange(@RequestBody StockExchangeDto stockExchange){
		exchangeService.addNewExchange(stockExchange);
		return new ResponseEntity<String>("Stock Exchange Added", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/view")
	public ResponseEntity<List<StockExchangeDto>> viewExchanges(){
		return new ResponseEntity<List<StockExchangeDto>>(exchangeService.findAllExchanges(), HttpStatus.OK);
	}
	
	@GetMapping("/company/{stock_exchange_name}")
	public ResponseEntity<List<Company>> viewCompaniesInExchange(@PathVariable("stock_exchange_name") String exchange){
		return new ResponseEntity<List<Company>>(exchangeService.findCompanies(exchange), HttpStatus.OK);
	}

}
