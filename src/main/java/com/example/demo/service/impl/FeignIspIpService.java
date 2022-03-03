package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.IspDto;
import com.example.demo.model.dto.SummaryDto;
import com.example.demo.service.ispIpServiceInterface;
import com.example.demo.util.api.FeignUtils;

@Service
public class FeignIspIpService implements ispIpServiceInterface {
	@Autowired
	private FeignUtils feignUtils;
	
	@Override
	public List<SummaryDto> findIspIpSummary(){
		return feignUtils.findIspIpSummary();
	}
	
	@Override
	public List<String> findIspIp(List<IspDto> dtos){
		return feignUtils.findIspIp(dtos);
	}
}
