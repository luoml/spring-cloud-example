package com.example.swagger2.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger2.vo.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@Api("Demo")
@RestController
public class DemoController {
	
	@ApiOperation(value="测试Get请求")
	@ApiImplicitParams(
			@ApiImplicitParam(name="name", dataType="string", required=false, value="昵称", paramType="query")
	)
	@GetMapping("/api/hello")
    public String hello(@RequestParam(required=false) String name) {
        return (StringUtils.isEmpty(name)) ?  "Hello! Swagger" : ("Hello! " + name);
    }
	
	@ApiOperation(value="测试Post请求")
	@PostMapping("/api/hello/{greeting}")
    public String hello(
    		@ApiParam(required=true, name="greeting", value="自定义问候语", defaultValue="hello") @PathVariable String greeting, 
    		@RequestBody(required=false) User user) {
        return greeting + "! " + user;
    }
	
	/**
	 * ApiIgnore注解用于Controller层，当前Controller所有方法不可见
	 * ApiIgnore注解用于方法层，当前方法不可见
	 * ApiIgnore注解用于参数层，当前属性不可见
	 */
	@ApiIgnore
	@ApiOperation(value="测试@ApiIgnore")
	@GetMapping("/api/testIgnore/{name}")
    public String testIgnore(@ApiParam(required=true, name="name", value="昵称") @PathVariable String name) {
        return "Hello! " + name;
    }
}
