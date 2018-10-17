/**
 * Created by leeson8888 on 2018/10/17.
 */
package com.itshizhan.model;

public class SysUserRole {
	private Long userId;
	private Long roleId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "SysUserRole{" +
						"userId=" + userId +
						", roleId=" + roleId +
						'}';
	}
}
