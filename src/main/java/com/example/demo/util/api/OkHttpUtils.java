package com.example.demo.util.api;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.dto.IspDto;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtils {

	public static final String URL_PREFIX = "http://127.0.0.1:8086";

	public static String findIspIpSummary() {
		String url = URL_PREFIX + "findIspIpSummary";
		Response response = null;
		String json = "";
		try {
			OkHttpClient client = new OkHttpClient().newBuilder().build();
			Request request = new Request.Builder().url(url).build();
			Call call = client.newCall(request);
			response = call.execute();
			json = response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				response.close();
			}
		}
		return json;
	}

	public static String findIspIp(List<IspDto> summary) {
		String url = URL_PREFIX + "findIspIp";
		Response response = null;
		String json = "";
		try {
			OkHttpClient client = new OkHttpClient().newBuilder().build();
			String content = JSON.toJSONString(summary);

			RequestBody formBody = new FormBody.Builder().add("summary", content).build();
			Request request = new Request.Builder().url(url).post(formBody).build();
			Call call = client.newCall(request);

			response = call.execute();
			json = response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				response.close();
			}
		}
		return json;
	}

}
