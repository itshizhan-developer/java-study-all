/**
 * Created by leeson8888 on 2018/10/17.
 */
package com.itshizhan.model;

public class SysRolePrivilege {
	/**
	 * 角色ID
	 */
	private Long roleId;
	/**
	 * 权限ID
	 */
	private Long privilegeId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}
}
