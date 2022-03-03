package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.dto.IspDto;
import com.example.demo.model.dto.SummaryDto;
import com.example.demo.service.ispIpServiceInterface;
import com.example.demo.util.api.RestTemplateUtils;

@Service
public class RestTemplateIspIpService implements ispIpServiceInterface {
	@Autowired
	private RestTemplateUtils restTemplateIspIpDao;

	@Override
	public List<SummaryDto> findIspIpSummary() {
		String json = restTemplateIspIpDao.findIspIpSummary();
		List<SummaryDto> dtos = JSON.parseArray(json, SummaryDto.class);
		return dtos;
	}

	@Override
	public List<String> findIspIp(List<IspDto> dtos) {
		String json = restTemplateIspIpDao.findIspIp(dtos);
		List<String> str = JSON.parseArray(json, String.class);
		return str;
	}
}
