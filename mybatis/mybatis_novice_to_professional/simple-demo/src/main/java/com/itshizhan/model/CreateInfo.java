/**
 * Created by leeson8888 on 2018/10/17.
 */
package com.itshizhan.model;

import java.io.Serializable;
import java.util.Date;

public class CreateInfo implements Serializable{
	public static final long serialVersionUID = 8275281589408844992L;
	private String create_by;
	private Date createTime;

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
