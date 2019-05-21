package com.itshizhan.common.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class SysUser implements Serializable {
	/**
	 * 用户id
	 */
	private Long id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	@JsonIgnore
	private String userPassword;
	/**
	 * 用户email
	 */
	private String userEmail;
	/**
	 * 用户信息，别名
	 */
	private String userInfo;
	/**
	 * 用户头像，blob
	 */
	private byte[] headImg;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 用户角色，假设为一个用户一个角色
	 */
	private SysRole sysRole;

	/**
	 * 一个用户多个角色
	 */
	private List<SysRole> roleList;

}
