package com.example.uploadexcel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.uploadexcel.model.StockPrice;

@Repository
public interface ExcelDao extends JpaRepository<StockPrice, Long>{

}
