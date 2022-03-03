package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.IspDto;
import com.example.demo.model.dto.SummaryDto;

public interface ispIpServiceInterface {

	List<SummaryDto> findIspIpSummary();

	List<String> findIspIp(List<IspDto> dtos);

}
