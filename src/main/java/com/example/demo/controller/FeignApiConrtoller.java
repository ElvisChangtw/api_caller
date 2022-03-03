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
import com.example.demo.service.impl.FeignIspIpService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "feign")
@RestController
@RequestMapping("/feign")
public class FeignApiConrtoller {

	@Autowired
	FeignIspIpService feignIspIpService;

	@GetMapping(value = "/ipSummary")
	@ApiOperation(value = "feign_ipSummary")
	public List<SummaryDto> getIpSummary() {
		return feignIspIpService.findIspIpSummary();
	}

	@PostMapping(value = "/ispIp")
	@ApiOperation(value = "feign_ispIp")
	public List<String> getIspIp(@RequestBody List<IspDto> summary) {
		return feignIspIpService.findIspIp(summary);
	}
}
