package com.example.demo.config;

import feign.Logger;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignAdapterConfig {
	/**
	 *
	 * Logger.Level 的具體級別如下： NONE：不記錄任何信息 BASIC：僅記錄請求方法、URL以及響應狀態碼和執行時間 HEADERS：除了記錄
	 * BASIC級別的信息外，還會記錄請求和響應的頭信息 FULL：記錄所有請求與響應的明細，包括頭信息、請求體、元數據
	 * 
	 * @return
	 */
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}
