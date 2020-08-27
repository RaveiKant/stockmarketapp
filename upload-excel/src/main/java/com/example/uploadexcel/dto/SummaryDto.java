package com.example.uploadexcel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SummaryDto {

	private String companyCode;
    private String stockExchange;
    private Integer recordNumber;
    private String fromDate;
    private String toDate;

}
