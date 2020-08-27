package com.example.uploadexcel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.uploadexcel.model.StockPrice;

public interface ExcelDao extends JpaRepository<StockPrice, Long>{

}
