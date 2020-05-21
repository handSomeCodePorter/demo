package com.cloud.zhpt.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {


	@Autowired()
	@Qualifier(value = "RedisTemplateCustom")
	RedisTemplate redisTemplate;


	@GetMapping("/set")
	public String set(String key, String val) {
		System.err.println(key + ":" +val);
		redisTemplate.opsForValue().set(key, val);
		return "success";
	}



	@GetMapping("/get")
	public String get(String key) {
		RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
		String ret = redisTemplate.opsForValue().get(key).toString();
		System.err.println(ret);

		System.err.println(factory.getClusterConnection());
		return ret;
	}




}
