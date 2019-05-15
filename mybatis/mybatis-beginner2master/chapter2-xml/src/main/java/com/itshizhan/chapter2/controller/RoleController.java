package com.itshizhan.chapter2.controller;

import com.itshizhan.chapter2.bean.SysRole;
import com.itshizhan.chapter2.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleMapper roleMapper;

	@GetMapping("/getRolesByIdAndEnabled")
	public List<SysRole> getRolesByIdAndEnabled(Long id, Integer enabled){
		List<SysRole> roleList = roleMapper.selectRolesByUserIdAndRoleEnabled(id,enabled);
		return roleList;
	}

	@GetMapping("/getRolesByIdAndEnabled1")
	public List<SysRole> getRolesByIdAndEnabled1(Long id, Integer enabled){
		Map<String,Object> map = new HashMap<>();
		map.put("userId",id);
		map.put("enabled",enabled);
		List<SysRole> roleList = roleMapper.selectRolesByUserIdAndRoleEnabled1(map);
		return roleList;
	}

	@GetMapping("/getRolesByIdAndEnabled2")
	public List<SysRole> getRolesByIdAndEnabled2(Long id, Integer enabled){
		List<SysRole> roleList = roleMapper.selectRolesByUserIdAndRoleEnabled2(id,enabled);
		return roleList;
	}


}
