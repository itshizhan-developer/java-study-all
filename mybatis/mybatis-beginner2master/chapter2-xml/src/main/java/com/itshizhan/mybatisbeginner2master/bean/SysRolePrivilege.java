package com.itshizhan.mybatisbeginner2master.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRolePrivilege {
	/**
	 * 角色ID
	 */
	private Long roleId;
	/**
	 * 权限ID
	 */
	private Long privilegeId;
}
