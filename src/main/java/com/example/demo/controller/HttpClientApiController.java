package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.dto.IspDto;
import com.example.demo.model.dto.SummaryDto;
import com.example.demo.util.api.HttpClientUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "httpclient")
@RequestMapping("/httpclient")
public class HttpClientApiController {

	@Autowired
	private HttpClientUtils httpClientDao;

	@GetMapping("/ipSmmary")
	@ApiOperation(value = "httpclient_ipSmmary")
	public List<SummaryDto> getIpSummary() throws Exception {
		String json = httpClientDao.findIspIpSummary();
		List<SummaryDto> result = JSON.parseArray(json, SummaryDto.class);
		return result;
	}

	@PostMapping("/ispIp")
	@ApiOperation(value = "httpclient_ispIp")
	public List<String> findIspIp(@RequestBody List<IspDto> summary) throws Exception {
		String json = httpClientDao.findIspIp(summary);
		List<String> result = JSON.parseArray(json, String.class);
		return result;
	}
}