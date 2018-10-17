/**
 * Created by leeson8888 on 2018/10/17.
 */
package com.itshizhan.model;

import com.itshizhan.type.Enabled;

import java.io.Serializable;
import java.util.Date;

public class SysRole implements Serializable{
	private static final long serialVersionUID = 6320941908222932112L;
	/**
	 * 角色ID
	 */
	private Long id;
	/**
	 * 角色名
	 */
	private String roleName;
	/**
	 * 有效标志
	 */
	private Enabled enabled;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 用户信息
	 */
	private SysUser user;
	/**
	 * 创建信息
	 */
	private CreateInfo createInfo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Enabled getEnabled() {
		return enabled;
	}

	public void setEnabled(Enabled enabled) {
		this.enabled = enabled;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

	public CreateInfo getCreateInfo() {
		return createInfo;
	}

	public void setCreateInfo(CreateInfo createInfo) {
		this.createInfo = createInfo;
	}
}
