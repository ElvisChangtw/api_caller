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
import com.example.demo.service.impl.OkhttpIspIpService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "restTemplate")
@RestController
@RequestMapping("/restTemplate")
public class OkhttpApiConrtoller {

	@Autowired
	OkhttpIspIpService okhttpIspIpService;

	@GetMapping(value = "/ipSummary")
	@ApiOperation(value = "okhttp_ipSummary")
	public List<SummaryDto> getIpSummary() {
		return okhttpIspIpService.findIspIpSummary();
	}

	@ApiOperation(value = "/ispIp")
	@PostMapping(value = "/okhttp_ispIp")
	public List<String> findIspIp(@RequestBody List<IspDto> summary) {
		return okhttpIspIpService.findIspIp(summary);
	}

}
