package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.IspDto;
import com.example.demo.model.dto.SummaryDto;
import com.example.demo.service.impl.RestTemplateIspIpService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "restTemplate")
@RestController
@RequestMapping("/restTemplate")
public class RestTemplateApiConrtoller {

	@Autowired
	RestTemplateIspIpService restTemplateIspIpService;

	@GetMapping(value = "/ipSummary")
	@ApiOperation(value = "restTemplate_ipSummary")
	public List<SummaryDto> getIpSummary() {
		return restTemplateIspIpService.findIspIpSummary();
	}

	@ApiOperation(value = "/ispIp")
	@PostMapping(value = "/restTemplate_ispIp")
	public List<String> findIspIp(@RequestBody List<IspDto> summary) {
		return restTemplateIspIpService.findIspIp(summary);
	}

}
