/**
 * Created by leeson8888 on 2018/9/12.
 */
package com.itshizhan.dao;

import com.itshizhan.entity.Area;

import java.util.List;

public interface AreaDao {

	// 查询所有地区
	List<Area> queryArea();

	// 根据id查询地区
	Area queryAreaById(int areaId);

	// 增
	int insertArea(Area area);

	// 改
	int updateArea(Area area);

	// 删除
	int deleteArea(int areaId);








}
