package com.example.stockexchange.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockexchange.model.StockExchange;
import com.example.stockexchange.service.ExchangeService;

@RestController
@RequestMapping("/exchange")
public class StockExchangeController {
	
	ExchangeService exchangeService;

	public StockExchangeController(ExchangeService exchangeService) {
		super();
		this.exchangeService = exchangeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addExchange(@RequestBody StockExchange stockExchange){
		exchangeService.addNewExchange(stockExchange);
		return new ResponseEntity<String>("Stock Exchange Added", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/view")
	public ResponseEntity<List<StockExchange>> viewExchanges(){
		return new ResponseEntity<List<StockExchange>>(exchangeService.findAllExchanges(), HttpStatus.OK);
	}

}
