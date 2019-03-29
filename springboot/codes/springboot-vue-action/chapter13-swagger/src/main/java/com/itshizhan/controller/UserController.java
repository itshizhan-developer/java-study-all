package com.itshizhan.controller;

import com.itshizhan.entities.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = {"用户接口","1.0"})
@RestController
public class UserController {

	@ApiOperation("根据Id查询用户")
	@ApiImplicitParam(paramType = "path",name = "id",value = "用户Id",required = true)
	@GetMapping("user/{id}")
	public String getUserById(@PathVariable Integer id){
		return "user/" + id;
	}

	@ApiOperation("通过Id删除用户")
	@ApiResponses({
				@ApiResponse(code=1,message="删除成功"),
				@ApiResponse(code=500,message="删除失败")
	})
	@DeleteMapping("/user/{id}")
	public String deleteUserById(@PathVariable Integer id){
		return id + "has deleted";
	}

	@ApiOperation(value = "添加用户",notes = "根据用户名和地址添加用户")
	@ApiImplicitParams({
					@ApiImplicitParam(paramType = "query",name = "username",
					value = "用户名",required = true,defaultValue = "itshizhan"),
					@ApiImplicitParam(paramType = "query",name = "address",dataType = "String",
									value = "用户地址",required = true,defaultValue = "address")
	})
	@PostMapping("/user")
	public String addUser(@RequestParam String username,
												@RequestParam String address){
		return  username + ": " + address;
	}

	@ApiOperation("根据User实体修改用户信息")
	@PutMapping("/user")
	public String updateUser(@RequestBody User user){
		return user.toString();
	}

	@ApiIgnore
	@GetMapping("/ignore")
	public void ignoreMethod(){

	}


}
