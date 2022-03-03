package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.dto.IspDto;
import com.example.demo.model.dto.SummaryDto;
import com.example.demo.service.ispIpServiceInterface;
import com.example.demo.util.api.OkHttpUtils;

@Service
public class OkhttpIspIpService implements ispIpServiceInterface {

	@Override
	public List<SummaryDto> findIspIpSummary() {
		String json;
		json = OkHttpUtils.findIspIpSummary();
		List<SummaryDto> dtos = JSON.parseArray(json, SummaryDto.class);
		return dtos;
	}

	@Override
	public List<String> findIspIp(List<IspDto> dtos) {
		String json = OkHttpUtils.findIspIp(dtos);
		List<String> str = JSON.parseArray(json, String.class);
		return str;
	}
}
