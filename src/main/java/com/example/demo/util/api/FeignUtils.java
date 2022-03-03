package com.example.demo.util.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.config.FeignAdapterConfig;
import com.example.demo.model.dto.IspDto;
import com.example.demo.model.dto.SummaryDto;

@FeignClient(name = "pdns-adapter-api", url = "http://127.0.0.1:8086", configuration = FeignAdapterConfig.class)
public interface FeignUtils {
	@RequestMapping(value = "/findIspIpSummary", method = RequestMethod.GET)
	List<SummaryDto> findIspIpSummary();
//	String searchRepo(@RequestParam("q") String queryStr);

	@RequestMapping(value = "/findIspIp", method = RequestMethod.POST)
	List<String> findIspIp(@RequestBody List<IspDto> summary);

}
