package com.example.demo.util.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.dto.IspDto;

@Service
public class RestTemplateUtils {
	public static final String URL_PREFIX = "http://127.0.0.1:8086";

	@Autowired
	private RestTemplate restTemplate;

	public String findIspIpSummary() {
		String url = URL_PREFIX + "findIspIpSummary";
		ResponseEntity<String> getForEntity = restTemplate.getForEntity(url, String.class);
		String json = getForEntity.getBody();
		return json;
	}

	public String findIspIp(List<IspDto> summary) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String content = JSON.toJSONString(summary);
		HttpEntity<String> request = new HttpEntity<>(content, headers);
		String url = URL_PREFIX + "findIspIp";
		ResponseEntity<String> postForEntity = restTemplate.postForEntity(url, request, String.class);
		String json = postForEntity.getBody();
		return json;
	}

}
