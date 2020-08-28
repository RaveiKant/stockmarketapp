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

import com.example.companydetails.dto.IpoDto;
import com.example.companydetails.service.IpoService;

@RestController
@RequestMapping("/ipo")
public class IpoController {

	IpoService ipoService;
		
	public IpoController(IpoService ipoService) {
		super();
		this.ipoService = ipoService;
	}

	@GetMapping("/ipo")
    public ResponseEntity<List<IpoDto>> getAllIpo() 
	{
        return new ResponseEntity<List<IpoDto>>(ipoService.findAllIpo(), HttpStatus.OK);
        
    }
	
	@GetMapping("/ipo/{ipoId}")
    public ResponseEntity<IpoDto> getIpo(@PathVariable("ipoId") Integer ipoId) 
	{
        return new ResponseEntity<IpoDto>(ipoService.findIpobyId(ipoId), HttpStatus.OK);
        
    }

    @PostMapping("/ipo/add")
    public ResponseEntity<String> addNewIpo(@RequestBody IpoDto ipoDetail) {
        ipoService.AddNewIpo(ipoDetail);
        return new ResponseEntity<String>("IPO Added Successfully",HttpStatus.ACCEPTED);
    }

    @PostMapping("/ipo/update")
    public ResponseEntity<String> updateIpo(@RequestBody IpoDto ipoDetail) {
        ipoService.updateIpo(ipoDetail);
        return new ResponseEntity<String>("IPO Updated Successfully",HttpStatus.ACCEPTED);
    }


}
