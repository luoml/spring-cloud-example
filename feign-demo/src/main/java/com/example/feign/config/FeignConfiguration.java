package com.example.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class FeignConfiguration {
	
	/**
	 * 设置Feign日志级别 ，需要配合 logging.level.<package.FeignClientClassName>=debug 使用（必须是debug级别）
	 * NONE		不记录 (DEFAULT)
	 * BASIC	仅记录请求方式、URL及 响应状态码、执行时间
	 * HEADERS	记录日志基本信息与请求头、响应头
	 * FULL		记录请求头、响应头、正文及元数据
	 */
	@Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}

