package com.itshizhan.mybatisbeginner2master.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
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

}
