package com.example.companydetails.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.companydetails.dto.CompanyDto;
import com.example.companydetails.dto.SectorDto;
import com.example.companydetails.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	CompanyService companyService;
	
	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}

    @GetMapping("/search/{name}")
    public ResponseEntity<List<CompanyDto>> searchCompanyByName(@PathVariable("name") String name){
        return new ResponseEntity<List<CompanyDto>>(companyService.findCompanyLike(name), HttpStatus.OK);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<CompanyDto>> findAllCompany(){
        return new ResponseEntity<List<CompanyDto>>(companyService.findAllCompany(), HttpStatus.OK);
    }
 
    @PostMapping("/add")
    public ResponseEntity<String> addCompany(@RequestBody CompanyDto companyDto) {
        companyService.addCompany(companyDto);
        return new ResponseEntity<String>("Company Added Successfully",HttpStatus.ACCEPTED);
    }
    
   
    @PostMapping("/update")
    public ResponseEntity<String> updateCompany(@RequestBody CompanyDto companyDto) {
        companyService.updateCompany(companyDto);
        return new ResponseEntity<String>("Company Added Successfully",HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<CompanyDto> deleteCompany(@RequestBody Long companyId) {
  
        return new ResponseEntity<CompanyDto>(companyService.deleteCompany(companyId),HttpStatus.OK);
    }
 
    @GetMapping("/sector/{sectorId}")
    public ResponseEntity<List<CompanyDto>> searchCompanyBySector(@PathVariable("sectorId") Integer sectorId){
        return new ResponseEntity<List<CompanyDto>>(companyService.findBySector(sectorId), HttpStatus.OK);
        
    }
    
    @PostMapping("/sector/add")
    public ResponseEntity<String> addSector(@RequestBody SectorDto sectorDto){
    	companyService.addSector(sectorDto);
    	return new ResponseEntity<String>("Sector Added Successfully", HttpStatus.ACCEPTED);
    }

    
    
	
}
