package com.example.demo.util.api;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.dto.IspDto;

@Repository
public class HttpClientUtils {
	public static final String URL_PREFIX = "http://127.0.0.1:8086";
	@Autowired
	private static HttpClient httpClient;

	public static String findIspIpSummary() {
		String url = URL_PREFIX + "/findIspIpSummary";
		HttpGet httpGet = new HttpGet(url);
		HttpResponse res;
		String json = "";
		try {
			res = httpClient.execute(httpGet);
			json = EntityUtils.toString(res.getEntity());
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	public static String findIspIp(@RequestBody List<IspDto> summary) {
		String reqJson = JSON.toJSONString(summary);
		StringEntity requestEntity = new StringEntity(reqJson, ContentType.APPLICATION_JSON);
		HttpPost httpPost = new HttpPost("http://127.0.0.1:8086/findIspIp");
		httpPost.setEntity(requestEntity);
		String resJson = "";
		try {
			HttpResponse res = httpClient.execute(httpPost);
			resJson = EntityUtils.toString(res.getEntity());
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resJson;
	}
}
