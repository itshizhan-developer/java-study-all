package com.itshizhan.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"测试接口","1.0"})
public class HelloController {

	@ApiOperation(value = "sayHello接口",notes = "sayHello接口详细描述")
	@GetMapping("/")
	public  String sayHello() {

		return "hello chapter13";
	}

}
