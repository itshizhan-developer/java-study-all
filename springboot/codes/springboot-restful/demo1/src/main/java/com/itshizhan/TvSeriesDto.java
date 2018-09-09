/**
 * Created by leeson8888 on 2018/9/10.
 */
package com.itshizhan;

import java.util.Date;

public class TvSeriesDto {
	private int id;
	private String name;
	private Date originReleaseDate;


	public TvSeriesDto(){

	}

	public TvSeriesDto(int id, String name, Date originReleaseDate) {
		this.id = id;
		this.name = name;
		this.originReleaseDate = originReleaseDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOriginReleaseDate() {
		return originReleaseDate;
	}

	public void setOriginReleaseDate(Date originReleaseDate) {
		this.originReleaseDate = originReleaseDate;
	}
}
